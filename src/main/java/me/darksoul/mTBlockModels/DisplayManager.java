package me.darksoul.mTBlockModels;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.ItemDisplay;
import org.bukkit.entity.Display.Brightness;
import org.bukkit.util.Vector;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class DisplayManager {

    private final MTBlockModels plugin; // Reference to the main plugin class
    private final Map<String, String> entityMap = new HashMap<>();
    private File configFile;
    private FileConfiguration config;

    public DisplayManager(MTBlockModels plugin) {
        this.plugin = plugin; // Store reference to the plugin instance
        createConfigFolder();
        loadConfig(); // Load the config when the manager is created
    }

    private void createConfigFolder() {
        File dataFolder = plugin.getDataFolder();
        if (!dataFolder.exists()) {
            dataFolder.mkdirs(); // Create the folder if it doesn't exist
        }
        configFile = new File(dataFolder, "mtentitydata.yml");
        if (!configFile.exists()) {
            try {
                configFile.createNewFile(); // Create the config file if it doesn't exist
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void loadConfig() {
        config = YamlConfiguration.loadConfiguration(configFile);
        if (config.contains("mtentitydata")) {
            Map<String, Object> tempMap = config.getConfigurationSection("mtentitydata").getValues(false);
            for (Map.Entry<String, Object> entry : tempMap.entrySet()) {
                entityMap.put(entry.getKey(), entry.getValue().toString());
            }
            Bukkit.getLogger().info("Loaded " + entityMap.size() + " entities from mtentitydata.yml");
        }
    }

    public void saveConfig() {
        config.createSection("mtentitydata", entityMap);
        try {
            config.save(configFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Vector snapToCardinalDirection(float yaw) {
        if (yaw < 0) {
            yaw += 360;
        }
        if (yaw >= 315 || yaw < 45) {
            return new Vector(0, 0, -1);  // East
        } else if (yaw >= 45 && yaw < 135) {
            return new Vector(1, 0, 0);   // North
        } else if (yaw >= 135 && yaw < 225) {
            return new Vector(0, 0, 1);   // West
        } else {
            return new Vector(-1, 0, 0);  // South
        }
    }

    public void setupDisplay(Location location, Object item, Float yaw, Float pitch, String type) {
        ItemDisplay itemDisplay = (ItemDisplay) location.getWorld().spawn(location.add(0.5, 0.5, 0.5), ItemDisplay.class);
        entityMap.put(locationToString(location), itemDisplay.getUniqueId().toString());
        saveConfig();

        // Adjust the item display
        itemDisplay.setItemStack((org.bukkit.inventory.ItemStack) item);
        itemDisplay.setBrightness(new Brightness(0, 15));

        Vector directionVector = null;
        if ("xz".equals(type) || "DUNWES".equals(type)) {
            directionVector = snapToCardinalDirection(yaw);
            if ("DUNWES".equals(type)) {
                if (pitch != null && pitch > 45) {
                    directionVector = new Vector(0, 1, 0);  // Face up
                } else if (pitch != null && pitch < -45) {
                    directionVector = new Vector(0, -1, 0);  // Face down
                }
            }
        } else if ("static".equals(type)) {
            directionVector = new Vector(0, 1, 0);  // Upwards by default
        }

        if (directionVector != null) {
            Location displayLocation = itemDisplay.getLocation();
            displayLocation.setDirection(directionVector);
            itemDisplay.teleport(displayLocation);
        }
    }

    public void destroyDisplay(Location blockLocation) {
        String entityUUIDString = entityMap.get(locationToString(blockLocation));
        if (entityUUIDString != null) {
            UUID entityUUID = UUID.fromString(entityUUIDString);
            Entity entity = Bukkit.getEntity(entityUUID);
            if (entity != null) {
                entity.remove();
            }
            entityMap.remove(locationToString(blockLocation));
            saveConfig();
        } else {
            Bukkit.getLogger().warning("No entity found for location: " + locationToString(blockLocation));
        }
    }

    private String locationToString(Location location) {
        return location.getBlockX() + "," + location.getBlockY() + "," + location.getBlockZ();
    }
}
