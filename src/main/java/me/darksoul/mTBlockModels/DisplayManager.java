package me.darksoul.mTBlockModels;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Display.Brightness;
import org.bukkit.entity.Entity;
import org.bukkit.entity.ItemDisplay;
import org.bukkit.util.Transformation;
import org.bukkit.util.Vector;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.logging.Level;

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
        ItemDisplay itemDisplay = location.getWorld().spawn(location.add(0.5, 0.5, 0.5), ItemDisplay.class);
        entityMap.put(locationToString(location), itemDisplay.getUniqueId().toString());
        saveConfig();

        Transformation itemTransformation = itemDisplay.getTransformation();
        itemTransformation.getScale().set(1.01);

        // Adjust the item display
        itemDisplay.setItemStack((org.bukkit.inventory.ItemStack) item);
        itemDisplay.setTransformation(itemTransformation);
        itemDisplay.setBrightness(new Brightness(0, 15));

        Vector directionVector = null;
        if ("xz".equals(type) || "DUNWES".equals(type)) {
            directionVector = snapToCardinalDirection(checkIfNullYaw(yaw));

            if ("DUNWES".equals(type)) {
                // Handle up/down faces based on pitch
                if (pitch != null && pitch > 45) {
                    directionVector = new Vector(0, 1, 0);  // Facing up
                } else if (pitch != null && pitch < -45) {
                    directionVector = new Vector(0, -1, 0);  // Facing down
                } else {
                    // Use block face method to get the correct orientation for DUNWES
                    directionVector = getBlockFaceDirection(location);
                }
            }
        } else if ("static".equals(type)) {
            directionVector = new Vector(0, 1, 0);  // Default upwards direction
        }

        if (directionVector != null) {
            Location displayLocation = itemDisplay.getLocation();
            displayLocation.setDirection(directionVector);
            itemDisplay.teleport(displayLocation);
        }
    }

    public Vector getBlockFaceDirection(Location location) {
        org.bukkit.block.Block block = location.getBlock();

        // Check if the block has directional data
        if (block.getBlockData() instanceof org.bukkit.block.data.Directional blockData) {

            // Get the block face direction and translate it into a Vector
            switch (blockData.getFacing()) {
                case NORTH:
                    return new Vector(0, 0, -1);
                case SOUTH:
                    return new Vector(0, 0, 1);
                case EAST:
                    return new Vector(1, 0, 0);
                case WEST:
                    return new Vector(-1, 0, 0);
                case UP:
                    return new Vector(0, 1, 0);  // Upwards
                case DOWN:
                    return new Vector(0, -1, 0);  // Downwards
                default:
                    return new Vector(0, 1, 0);  // Fallback to up
            }
        } else {
            // If the block is not directional, default to facing up
            return new Vector(0, 1, 0);  // Upwards
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
        }
    }

    private String locationToString(Location location) {
        return location.getBlockX() + "," + location.getBlockY() + "," + location.getBlockZ();
    }

    private Float checkIfNullYaw(Float yaw) {
        if (yaw == null) {
            yaw = 0.0f;
            return yaw;
        } else {
            return yaw;
        }
    }

    public boolean doesDisplayExist(Location location) {
        String entityUUIDString = entityMap.get(locationToString(location));
        return entityUUIDString != null;
    }
}
