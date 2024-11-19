package me.darksoul.mTBlockModels;

import com.MT.xxxtrigger50xxx.Devices.Device;
import com.MT.xxxtrigger50xxx.Devices.Mover;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ExistingLoader implements CommandExecutor {

    private final DisplayManager displayManager;

    public ExistingLoader(MTBlockModels plugin, DisplayManager displayManager) {
        this.displayManager = displayManager;
        plugin.getCommand("mtmodel").setExecutor(this); // Register the command
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 1 && args[0].equalsIgnoreCase("loadexisting")) {
            if (sender instanceof Player player) {
                loadExistingDevices(player);
                player.sendMessage("Devices have been loaded and displays spawned.");
            }
            return true;
        }
        return false;
    }

    private void loadExistingDevices(Player player) {
        // Process all Devices
        for (Device device : Device.getDevices()) {
            Location deviceLocation = device.getLocation();
            handleDisplaySetup(deviceLocation, MTMachines.getDeviceItem(device), MTMachines.getDeviceType(device), player);
        }

        // Process all Movers
        for (Mover mover : Mover.getMovers()) {
            Location moverLocation = mover.getLocation();
            handleDisplaySetup(moverLocation, MTMachines.getDeviceItem(mover), MTMachines.getDeviceType(mover), player); // Assuming MTMachines has similar methods for Mover
        }
    }

    // Helper method to handle display setup for both Devices and Movers
    private void handleDisplaySetup(Location location, Object item, String type, Player player) {
        Block block = location.getBlock();

        // Check if an ItemDisplay already exists at this location
        if (!displayManager.doesDisplayExist(location)) {
            if ("xz".equals(type)) {
                displayManager.setupDisplay(location, item, null, null, type, player);
            } else if ("DUNWES".equals(type)) {
                displayManager.setupDisplay(location, item, null, null, type, player);
            } else {
                displayManager.setupDisplay(location, item, null, null, type, player);
            }
        }
    }
}
