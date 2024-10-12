package me.darksoul.mTBlockModels;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.plugin.java.JavaPlugin;
import com.MT.xxxtrigger50xxx.Devices.Device;
import com.MT.xxxtrigger50xxx.Devices.Mover;

import java.util.Map;

public class MTBlockModels extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
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
            if (device != null && machineClass.isInstance(device) || mover != null && machineClass.isInstance(mover)) {
                Object item = MTMachines.blockDict.get(machineClass)[0];
                String displayType = (String) MTMachines.blockDict.get(machineClass)[1];
                DisplayManager.setupDisplay(event.getBlock().getLocation(), item, yaw, pitch, displayType);
                break;
            }
        }
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        DisplayManager.destroyDisplay(event.getBlock().getLocation());
    }
}
