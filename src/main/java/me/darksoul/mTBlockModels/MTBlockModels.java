package me.darksoul.mTBlockModels;

import com.MT.xxxtrigger50xxx.Devices.Device;
import com.MT.xxxtrigger50xxx.Devices.Mover;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class MTBlockModels extends JavaPlugin implements Listener {

    private DisplayManager displayManager;
    private ExistingLoader existingLoader;

    @Override
    public void onEnable() {
        this.displayManager = new DisplayManager(this);
        this.existingLoader = new ExistingLoader(this, displayManager);
        getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        Device device = Device.getDevice(event.getBlock().getLocation());
        Mover mover = Mover.getMover(event.getBlock().getLocation());

        float yaw = event.getPlayer().getLocation().getYaw();
        float pitch = event.getPlayer().getLocation().getPitch();

        // Find if placed block is part of recognized machines
        for (Class<?> machineClass : MTMachines.machineList) {
            if (machineClass.isInstance(device) || machineClass.isInstance(mover)) {
                Object item = MTMachines.blockDict.get(machineClass)[0];
                String displayType = (String) MTMachines.blockDict.get(machineClass)[1];
                displayManager.setupDisplay(event.getBlock().getLocation(), item, yaw, pitch, displayType);
                break;
            }
        }
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        displayManager.destroyDisplay(event.getBlock().getLocation());
    }

    public DisplayManager getDisplayManager() {
        return displayManager; // Return the instance of DisplayManager
    }
}
