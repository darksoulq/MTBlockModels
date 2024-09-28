import pyspigot as ps
from org.bukkit import Bukkit
from java.util import UUID as uid
from org.bukkit.util import Vector
from org.bukkit.entity import ItemDisplay
from org.bukkit.entity.Display import Brightness

# Map to store entity locations and UUIDs
entity_map = {}
config = ps.config.loadConfig("mtentitydata.yml")

def get_loc_and_uuid(memory_section):
    keys = memory_section.getKeys(False)
    data = {}
    
    for key in keys:
        value = memory_section.getString(key)
        data[key] = value

    return data

# Load entity data from config
if config.get("mtentitydata"):
    entity_map = get_loc_and_uuid(config.get("mtentitydata"))

def save_config():
    config.set('mtentitydata', entity_map)
    config.save()

def snap_to_cardinal_direction(yaw):
    """Snap yaw to the nearest cardinal direction."""
    if yaw < 0:
        yaw += 360
    if (yaw >= 315 or yaw < 45):
        return Vector(0, 0, -1)  # East
    elif (yaw >= 45 and yaw < 135):
        return Vector(1, 0, 0)  # North
    elif (yaw >= 135 and yaw < 225):
        return Vector(0, 0, 1)  # West
    elif (yaw >= 225 and yaw < 315):
        return Vector(-1, 0, 0)  # South

def setup_display(location, item, yaw=None, pitch=None, type="static"):
    item_display = location.getWorld().spawn(location.add(0.5, 0.5, 0.5), ItemDisplay)
    entity_map[str((location.getBlockX(), location.getBlockY(), location.getBlockZ()))] = str(item_display.getUniqueId())
    save_config()

    transformation = item_display.getTransformation()
    transformation.getScale().set(1.01)
    item_display.setItemStack(item)
    item_display.setTransformation(transformation)
    item_display.setBrightness(Brightness(0, 15))

    direction_vector = None
    if type in ["xz", "DUNWES"]:
        direction_vector = snap_to_cardinal_direction(yaw)

        # Handle pitch snapping for "DUNWES"
        if type == "DUNWES":
            if pitch > 45:
                direction_vector = Vector(0, 1, 0)  # Face up
            elif pitch < -45:
                direction_vector = Vector(0, -1, 0)  # Face down
            else:
                direction_vector.setY(0)  # Keep level

    # Set direction for static type
    if type == "static":
        direction_vector = Vector(0, 1, 0)

    # Apply direction vector if available
    if direction_vector:
        display_location = item_display.getLocation()
        display_location.setDirection(direction_vector)
        item_display.teleport(display_location)

def destroy_display(block):
    e_uuid = entity_map[str((block.getLocation().getBlockX(), block.getLocation().getBlockY(), block.getLocation().getBlockZ()))]
    if isinstance(e_uuid, str):
        e_uuid = uid.fromString(e_uuid)
        
    entity = Bukkit.getEntity(e_uuid)
    if entity:
        entity.remove()
    del entity_map[str((block.getLocation().getBlockX(), block.getLocation().getBlockY(), block.getLocation().getBlockZ()))]
    save_config()
