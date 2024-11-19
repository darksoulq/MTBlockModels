package me.darksoul.mTBlockModels;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class MTItems {

    public static final ItemStack HUMAN_TELEPORTER = createCustomItem(Material.PAPER, 8008);
    public static final ItemStack COLD_FUSION_REACTOR = createCustomItem(Material.PAPER, 8009);
    public static final ItemStack INFUSER = createCustomItem(Material.PAPER, 8010);
    public static final ItemStack POLLUTION_GENERATOR = createCustomItem(Material.PAPER, 8011);
    public static final ItemStack SIFTER = createCustomItem(Material.PAPER, 8012);
    public static final ItemStack CRAFTER = createCustomItem(Material.PAPER, 8013);
    public static final ItemStack PUMP = createCustomItem(Material.PAPER, 8014);
    public static final ItemStack MOONLIGHT_PANEL = createCustomItem(Material.PAPER, 8015);
    public static final ItemStack SOLAR_PANEL = createCustomItem(Material.PAPER, 8016);
    public static final ItemStack AUTO_COLLECTOR = createCustomItem(Material.PAPER, 8017);
    public static final ItemStack ELEVATOR = createCustomItem(Material.PAPER, 8018);
    public static final ItemStack ITEM_TELEPORTER = createCustomItem(Material.PAPER, 8019);
    public static final ItemStack AUTO_TIMER = createCustomItem(Material.PAPER, 8020);
    public static final ItemStack AUTO_SHEARER = createCustomItem(Material.PAPER, 8021);
    public static final ItemStack AUTO_MILKER = createCustomItem(Material.PAPER, 8022);
    public static final ItemStack AUTO_BREEDER = createCustomItem(Material.PAPER, 8023);
    public static final ItemStack DEEP_DRILL = createCustomItem(Material.PAPER, 8024);
    public static final ItemStack BOW_TURRET = createCustomItem(Material.PAPER, 8025);
    public static final ItemStack AUTO_PLUCKER = createCustomItem(Material.PAPER, 8026);
    public static final ItemStack AUTO_PLANTER = createCustomItem(Material.PAPER, 8027);
    public static final ItemStack AUTO_LOGGER = createCustomItem(Material.PAPER, 8028);
    public static final ItemStack AUTO_HARVESTER = createCustomItem(Material.PAPER, 8029);
    public static final ItemStack AUTO_MINER = createCustomItem(Material.PAPER, 8030);
    public static final ItemStack INCINERATOR = createCustomItem(Material.PAPER, 8031);
    public static final ItemStack AUTO_BUTCHER = createCustomItem(Material.PAPER, 8032);
    public static final ItemStack POWER_RECEIVER = createCustomItem(Material.PAPER, 8033);
    public static final ItemStack ADVANCED_BOW_TURRET = createCustomItem(Material.PAPER, 8034);
    public static final ItemStack LASER_TURRET = createCustomItem(Material.PAPER, 8035);
    public static final ItemStack BITER_DETECTOR = createCustomItem(Material.PAPER, 8036);
    public static final ItemStack REDSTONE_EMITTER = createCustomItem(Material.PAPER, 8037);
    public static final ItemStack HEAT_EXCHANGER = createCustomItem(Material.PAPER, 8038);
    public static final ItemStack NUCLEAR_REACTOR = createCustomItem(Material.PAPER, 8039);
    public static final ItemStack POWER_METER = createCustomItem(Material.PAPER, 8040);
    public static final ItemStack POWER_TRANSMITTER = createCustomItem(Material.PAPER, 8041);
    public static final ItemStack ITEM_FORGE = createCustomItem(Material.PAPER, 8042);
    public static final ItemStack BATTERY = createCustomItem(Material.PAPER, 8043);
    public static final ItemStack BATTERY_MONITOR = createCustomItem(Material.PAPER, 8044);
    public static final ItemStack POWER_PYLON = createCustomItem(Material.PAPER, 8045);
    public static final ItemStack POWER_PYLON_MK2 = createCustomItem(Material.PAPER, 8046);
    public static final ItemStack POWER_SUBSTATION = createCustomItem(Material.PAPER, 8047);
    public static final ItemStack CENTRIFUGE = createCustomItem(Material.PAPER, 8048);
    public static final ItemStack PRODUCTION_MONITOR = createCustomItem(Material.PAPER, 8049);
    public static final ItemStack COMBUSTION_GENERATOR = createCustomItem(Material.PAPER, 8050);
    public static final ItemStack OIL_REFINERY = createCustomItem(Material.PAPER, 8051);
    public static final ItemStack BOILER = createCustomItem(Material.PAPER, 8052);
    public static final ItemStack STEAM_ENGINE = createCustomItem(Material.PAPER, 8053);
    public static final ItemStack PETROLEUM_ENGINE = createCustomItem(Material.PAPER, 8054);
    public static final ItemStack BASIC_ASSEMBLER = createCustomItem(Material.PAPER, 8055);
    public static final ItemStack ADVANCED_ASSEMBLER = createCustomItem(Material.PAPER, 8056);
    public static final ItemStack RESEARCH_LAB = createCustomItem(Material.PAPER, 8057);
    public static final ItemStack ELECTRIC_FURNACE = createCustomItem(Material.PAPER, 8058);
    public static final ItemStack OVERDRIVER = createCustomItem(Material.PAPER, 8059);
    public static final ItemStack TRAIN_STATION = createCustomItem(Material.PAPER, 8060);
    public static final ItemStack AUTO_PLACER = createCustomItem(Material.PAPER, 8061);
    public static final ItemStack AUTO_BREAKER = createCustomItem(Material.PAPER, 8062);
    public static final ItemStack GEOTHERMAL_GENERATOR = createCustomItem(Material.PAPER, 8063);
    public static final ItemStack WIND_TURBINE = createCustomItem(Material.PAPER, 8064);
    public static final ItemStack TIDAL_GENERATOR = createCustomItem(Material.PAPER, 8065);
    public static final ItemStack HEAVY_STEAM_GENERATOR = createCustomItem(Material.PAPER, 8066);
    public static final ItemStack ROBOPORT = createCustomItem(Material.PAPER, 8067);
    public static final ItemStack AUTO_CAULDRON = createCustomItem(Material.PAPER, 8068);
    public static final ItemStack MINE_LAYER = createCustomItem(Material.PAPER, 8069);
    public static final ItemStack BARREL_PUMP = createCustomItem(Material.PAPER, 8070);
    public static final ItemStack FLOOD_LIGHT = createCustomItem(Material.PAPER, 8071);
    public static final ItemStack MOVER = createCustomItem(Material.PAPER, 8072);
    public static final ItemStack CRANK_GENERATOR = createCustomItem(Material.PAPER, 8073);
    public static final ItemStack LIGHTNING_GENERATOR = createCustomItem(Material.PAPER, 8074);
    public static final ItemStack MOB_BLOCKER = createCustomItem(Material.PAPER, 8075);
    public static final ItemStack CRUSHER = createCustomItem(Material.PAPER, 8076);
    public static final ItemStack ROCKET_SILO = createCustomItem(Material.PAPER, 8077);
    public static final ItemStack CHUNK_LOADER = createCustomItem(Material.PAPER, 8078);
    public static final ItemStack ARTILLERY_DEVICE = createCustomItem(Material.PAPER, 8079);

    private static ItemStack createCustomItem(Material material, int customModelData) {
        ItemStack item = new ItemStack(material);
        ItemMeta itemMeta = item.getItemMeta();
        if (itemMeta != null) {
            itemMeta.setCustomModelData(customModelData);
            item.setItemMeta(itemMeta);
        }
        return item;
    }
}
