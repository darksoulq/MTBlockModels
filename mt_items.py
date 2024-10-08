from org.bukkit import Material
from org.bukkit.inventory import ItemStack

# Helper function to create an ItemStack with custom model data
def create_custom_item(material, custom_model_data):
    item = ItemStack(material)
    item_meta = item.getItemMeta()
    item_meta.setCustomModelData(custom_model_data)
    item.setItemMeta(item_meta)
    return item

# Create custom items
human_teleporter = create_custom_item(Material.PAPER, 8008)
cold_fusion_reactor = create_custom_item(Material.PAPER, 8009)
infuser = create_custom_item(Material.PAPER, 8010)
pollution_generator = create_custom_item(Material.PAPER, 8011)
sifter = create_custom_item(Material.PAPER, 8012)
crafter = create_custom_item(Material.PAPER, 8013)
pump = create_custom_item(Material.PAPER, 8014)
moonlight_panel = create_custom_item(Material.PAPER, 8015)
solar_panel = create_custom_item(Material.PAPER, 8016)
auto_collector = create_custom_item(Material.PAPER, 8017)
elevator = create_custom_item(Material.PAPER, 8018)
item_teleporter = create_custom_item(Material.PAPER, 8019)
auto_timer = create_custom_item(Material.PAPER, 8020)
auto_shearer = create_custom_item(Material.PAPER, 8021)
auto_milker = create_custom_item(Material.PAPER, 8022)
auto_breeder = create_custom_item(Material.PAPER, 8023)
deep_drill = create_custom_item(Material.PAPER, 8024)
bow_turret = create_custom_item(Material.PAPER, 8025)
auto_plucker = create_custom_item(Material.PAPER, 8026)
auto_planter = create_custom_item(Material.PAPER, 8027)
auto_logger = create_custom_item(Material.PAPER, 8028)
auto_harvester = create_custom_item(Material.PAPER, 8029)
auto_miner = create_custom_item(Material.PAPER, 8030)
incinerator = create_custom_item(Material.PAPER, 8031)
auto_butcher = create_custom_item(Material.PAPER, 8032)
power_reciever = create_custom_item(Material.PAPER, 8033)
advanced_bow_turret = create_custom_item(Material.PAPER, 8034)
laser_turret = create_custom_item(Material.PAPER, 8035)
biter_detector = create_custom_item(Material.PAPER, 8036)
redstone_emitter = create_custom_item(Material.PAPER, 8037)
heat_exchanger = create_custom_item(Material.PAPER, 8038)
nuclear_reactor = create_custom_item(Material.PAPER, 8039)
power_meter = create_custom_item(Material.PAPER, 8040)
power_transmitter = create_custom_item(Material.PAPER, 8041)
item_forge = create_custom_item(Material.PAPER, 8042)
battery = create_custom_item(Material.PAPER, 8043)
battery_monitor = create_custom_item(Material.PAPER, 8044)
power_pylon = create_custom_item(Material.PAPER, 8045)
power_pylon_mk2 = create_custom_item(Material.PAPER, 8046)
power_substation = create_custom_item(Material.PAPER, 8047)
centrifuge = create_custom_item(Material.PAPER, 8048)
production_monitor = create_custom_item(Material.PAPER, 8049)
combustion_generator = create_custom_item(Material.PAPER, 8050)
oil_refinery = create_custom_item(Material.PAPER, 8051)
boiler = create_custom_item(Material.PAPER, 8052)
steam_engine = create_custom_item(Material.PAPER, 8053)
petroleum_engine = create_custom_item(Material.PAPER, 8054)
basic_assembler = create_custom_item(Material.PAPER, 8055)
advanced_assembler = create_custom_item(Material.PAPER, 8056)
research_lab = create_custom_item(Material.PAPER, 8057)
electric_furnace = create_custom_item(Material.PAPER, 8058)
overdriver = create_custom_item(Material.PAPER, 8059)
train_station = create_custom_item(Material.PAPER, 8060)
auto_placer = create_custom_item(Material.PAPER, 8061)
auto_breaker = create_custom_item(Material.PAPER, 8062)
geothermal_generator = create_custom_item(Material.PAPER, 8063)
wind_turbine = create_custom_item(Material.PAPER, 8064)
tidal_generator = create_custom_item(Material.PAPER, 8065)
heavy_steam_generator = create_custom_item(Material.PAPER, 8066)
roboport = create_custom_item(Material.PAPER, 8067)
auto_cauldron = create_custom_item(Material.PAPER, 8068)
mine_layer = create_custom_item(Material.PAPER, 8069)
barrel_pump = create_custom_item(Material.PAPER, 8070)
flood_light = create_custom_item(Material.PAPER, 8071)
mover = create_custom_item(Material.PAPER, 8072)
