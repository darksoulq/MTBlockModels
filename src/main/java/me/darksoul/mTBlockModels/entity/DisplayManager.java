package me.darksoul.mTBlockModels.entity;

import me.darksoul.mTBlockModels.MTBlockModels;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Display.Brightness;
import org.bukkit.entity.Entity;
import org.bukkit.entity.ItemDisplay;
import org.bukkit.entity.Player;
import org.bukkit.util.Transformation;
import org.bukkit.util.Vector;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class DisplayManager {

    private final MTBlockModels plugin;
    private final Map<String, String> entityMap = new HashMap<>();
    private File configFile;
    private FileConfiguration config;
    private final List<Location> locationList;

    public DisplayManager(MTBlockModels plugin) {
        this.plugin = plugin;
        createConfigFolder();
        loadConfig();
        locationList = getAllMachineLocations(Bukkit.getWorld("world"));
    }

    public List<Location> getAllMachineLocations(World world) {
        List<Location> locations = new ArrayList<>();

        Set<String> keys = entityMap.keySet();
        for (String key : keys) {
            String cleanedKey = key.replace("(", "").replace(")", "").trim(); // Remove ( and )
            String[] parts = cleanedKey.split(",");

            if (parts.length == 3) {
                try {
                    int x = Integer.parseInt(parts[0].trim());
                    int y = Integer.parseInt(parts[1].trim());
                    int z = Integer.parseInt(parts[2].trim());

                    Location location = new Location(world, x, y, z);
                    locations.add(location);
                } catch (NumberFormatException e) {
                }
            }
        }

        return locations;
    }

    private void createConfigFolder() {
        File dataFolder = plugin.getDataFolder();
        if (!dataFolder.exists()) {
            dataFolder.mkdirs();
        }
        configFile = new File(dataFolder, "mtentitydata.yml");
        if (!configFile.exists()) {
            try {
                configFile.createNewFile();
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

    public void setupDisplay(Location location, Object item, Float yaw, Float pitch, String type, Player player) {
        this.locationList.add(location);
        ItemDisplay itemDisplay = location.getWorld().spawn(location.add(0.5, 0.5, 0.5), ItemDisplay.class);
        entityMap.put(locationToString(location), itemDisplay.getUniqueId().toString());
        saveConfig();

        Transformation itemTransformation = itemDisplay.getTransformation();
        itemTransformation.getScale().set(1.01);

        itemDisplay.setItemStack((org.bukkit.inventory.ItemStack) item);
        itemDisplay.setTransformation(itemTransformation);
        itemDisplay.setBrightness(new Brightness(0, 15));

        Vector directionVector = null;
        if ("xz".equals(type) || "DUNWES".equals(type)) {
            directionVector = snapToCardinalDirection(checkIfNullYaw(yaw));

            if ("DUNWES".equals(type)) {
                if (pitch != null && pitch > 45) {
                    directionVector = new Vector(0, 1, 0);
                } else if (pitch != null && pitch < -45) {
                    directionVector = new Vector(0, -1, 0);
                } else {
                    directionVector = getBlockFaceDirection(location);
                }
            }
        } else if ("static".equals(type)) {
            directionVector = new Vector(0, 1, 0);
        }

        if (directionVector != null) {
            Location displayLocation = itemDisplay.getLocation();
            displayLocation.setDirection(directionVector);
            itemDisplay.teleport(displayLocation);
        }
    }

    public Vector getBlockFaceDirection(Location location) {
        org.bukkit.block.Block block = location.getBlock();

        if (block.getBlockData() instanceof org.bukkit.block.data.Directional blockData) {

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
                    return new Vector(0, 1, 0);
                case DOWN:
                    return new Vector(0, -1, 0);
                default:
                    return new Vector(0, 1, 0);
            }
        } else {
            return new Vector(0, 1, 0);  // Upwards
        }
    }


    public void destroyDisplay(Location blockLocation, Player player) {
        this.locationList.add(blockLocation);
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