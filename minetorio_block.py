import pyspigot as ps
from org.bukkit.event.block import BlockPlaceEvent, BlockBreakEvent
from com.MT.xxxtrigger50xxx.Devices import Device, Mover
from mt_machines import block_dict, machine_list
from mtblockmain import setup_display, destroy_display

def on_block_place(event):
    device = Device.getDevice(event.block.location)
    mover = Mover.getMover(event.block.location)
    player_location = event.player.getLocation()
    yaw = player_location.getYaw()
    pitch = player_location.getPitch()

    # Check if the device is a recognized machine and setup the display
    for machine_class in machine_list:
        if isinstance(device, machine_class) or isinstance(mover, machine_class):
            item = block_dict[machine_class][0]
            display_settings = block_dict[machine_class][1]
            setup_display(event.block.location, item, yaw, pitch, display_settings)
            break

def on_block_break(event):
    # Remove the display associated with the broken block
    destroy_display(event.block)

# Register event listeners
ps.listener.registerListener(on_block_place, BlockPlaceEvent)
ps.listener.registerListener(on_block_break, BlockBreakEvent)
