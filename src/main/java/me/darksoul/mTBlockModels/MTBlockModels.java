package me.darksoul.mTBlockModels;

import com.MT.xxxtrigger50xxx.Devices.Device;
import com.MT.xxxtrigger50xxx.Devices.Mover;
import me.darksoul.mTBlockModels.entity.DisplayManager;
import me.darksoul.mTBlockModels.entity.ExistingLoader;
import me.darksoul.mTBlockModels.internals.MTMachines;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class MTBlockModels extends JavaPlugin implements Listener {

    private DisplayManager displayManager;
    private ExistingLoader existingLoader;
    private static MTBlockModels instance;

    @Override
    public void onEnable() {
        instance = this;
        this.displayManager = new DisplayManager(this);
        this.existingLoader = new ExistingLoader(displayManager);
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
                displayManager.setupDisplay(event.getBlock().getLocation(), item, yaw, pitch, displayType, event.getPlayer());
                break;
            }
        }
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        displayManager.destroyDisplay(event.getBlock().getLocation(), event.getPlayer());
    }
    public DisplayManager getDisplayManager() {
        return displayManager; // Return the instance of DisplayManager
    }
    public static MTBlockModels getInstance() {
        return instance;
    }
}
