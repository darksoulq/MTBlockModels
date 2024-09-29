from com.MT.xxxtrigger50xxx.Devices.Transport import HumanTeleporter, Elevator, ItemTeleporter, TrainStation, Roboport
from com.MT.xxxtrigger50xxx.Devices.Generators import ColdFusionReactor, PollutionGenerator, MoonlightPanel, SolarPanel, HeatExchanger, NuclearReactor, Centrifuge, CombustionGenerator, SteamEngine, PetroleumEngine, GeothermalGenerator, HeavySteamGenerator, TidalGenerator, WindTurbine
from com.MT.xxxtrigger50xxx.Devices.Manufactoring import Infuser, Sifter, Crafter2, AutoTimer, Incinerator, ItemForge, BasicAssembler, AdvancedAssembler, OilRefinery
from com.MT.xxxtrigger50xxx.Devices.Liquids import Pump, Boiler
from com.MT.xxxtrigger50xxx.Devices.Producers import AutoCauldron, AutoCollector, AutoShearer, AutoMilker, AutoBreeder, DeepDrill, AutoPlucker, AutoPlanter, AutoLogger, AutoHarvester, AutoMiner, AutoButcher, ElectricFurnace, AutoBreaker, AutoPlacer
from com.MT.xxxtrigger50xxx.Devices.Defense import AdvancedBowTurret, BowTurret, LaserTurret, BiterDetector, MineLayer, FloodLight
from com.MT.xxxtrigger50xxx.Devices.Utility import PowerReceiver, RedstoneEmitter, PowerTransmitter, PowerMeter, ProductionMonitor
from com.MT.xxxtrigger50xxx.Devices import BatteryMonitor, Battery2, PowerPylon, PowerPylonMk2, PowerSubstation, OverDriver, Mover
from com.MT.xxxtrigger50xxx.Technology import ResearchLab
import mt_items


block_dict = {
    HumanTeleporter: (mt_items.human_teleporter, "xz"),
    ColdFusionReactor: (mt_items.cold_fusion_reactor, "xz"),
    Infuser: ("xz", mt_items.infuser),
    PollutionGenerator: (mt_items.pollution_generator, "xz"),
    Sifter: (mt_items.sifter, "xz"),
    Crafter2: (mt_items.crafter, "xz"),
    Pump: (mt_items.pump, "xz"),
    MoonlightPanel: (mt_items.moonlight_panel, "xz"),
    SolarPanel: (mt_items.solar_panel, "xz"),
    AutoCollector: (mt_items.auto_collector, "xz"),
    Elevator: (mt_items.elevator, "xz"),
    ItemTeleporter: (mt_items.item_teleporter, "xz"),
    AutoTimer: (mt_items.auto_timer, "xz"),
    AutoShearer: (mt_items.auto_shearer, "xz"),
    AutoMilker: (mt_items.auto_milker, "xz"),
    AutoBreeder: (mt_items.auto_breeder, "xz"),
    DeepDrill: (mt_items.deep_drill, "xz"),
    AutoPlucker: (mt_items.auto_plucker, "xz"),
    BowTurret: (mt_items.bow_turret, "xz"),
    AutoPlanter: (mt_items.auto_planter, "xz"),
    AutoLogger: (mt_items.auto_logger, "xz"),
    AutoHarvester: (mt_items.auto_harvester, "xz"),
    AutoMiner: (mt_items.auto_miner, "xz"),
    AutoButcher: (mt_items.auto_butcher, "xz"),
    Incinerator: (mt_items.incinerator, "xz"),
    PowerReceiver: (mt_items.power_reciever, "xz"),
    AdvancedBowTurret: (mt_items.advanced_bow_turret, "xz"),
    LaserTurret: (mt_items.laser_turret, "xz"),
    BiterDetector: (mt_items.biter_detector, "xz"),
    HeatExchanger: (mt_items.heat_exchanger, "xz"),
    RedstoneEmitter: (mt_items.redstone_emitter, "xz"),
    PowerTransmitter: (mt_items.power_transmitter, "xz"),
    PowerMeter: (mt_items.power_meter, "xz"),
    NuclearReactor: (mt_items.nuclear_reactor, "xz"),
    ItemForge: (mt_items.item_forge, "xz"),
    BatteryMonitor: (mt_items.battery_monitor, "xz"),
    Battery2: (mt_items.battery, "xz"),
    PowerPylon: (mt_items.power_pylon, "xz"),
    PowerPylonMk2: (mt_items.power_pylon_mk2, "xz"),
    PowerSubstation: (mt_items.power_substation, "xz"),
    Centrifuge: (mt_items.centrifuge, "xz"),
    ProductionMonitor: (mt_items.production_monitor, "xz"),
    GeothermalGenerator: (mt_items.geothermal_generator, "xz"),
    SteamEngine: (mt_items.steam_engine, "xz"),
    PetroleumEngine: (mt_items.petroleum_engine, "xz"),
    HeavySteamGenerator: (mt_items.heavy_steam_generator, "xz"),
    TidalGenerator: (mt_items.tidal_generator, "xz"),
    CombustionGenerator: (mt_items.combustion_generator, "xz"),
    WindTurbine: (mt_items.wind_turbine, "xz"),
    Boiler: (mt_items.boiler, "xz"),
    AdvancedAssembler: (mt_items.advanced_assembler, "xz"),
    BasicAssembler: (mt_items.basic_assembler, "xz"),
    AutoBreaker: (mt_items.auto_breaker, "DUNWES"),
    AutoPlacer: (mt_items.auto_placer, "DUNWES"),
    TrainStation: (mt_items.train_station, "xz"),
    OverDriver: (mt_items.overdriver, "DUNWES"),
    ElectricFurnace: (mt_items.electric_furnace, "xz"),
    OilRefinery: (mt_items.oil_refinery, "xz"),
    Roboport: (mt_items.roboport, "xz"),
    MineLayer: (mt_items.mine_layer, "DUNWES"),
    AutoCauldron: (mt_items.auto_cauldron, "xz"),
    FloodLight: (mt_items.flood_light, "DUNWES"),
    Mover: (mt_items.mover, "DUNWES"),
    ResearchLab: (mt_items.research_lab, "xz")
}

machine_list = list(block_dict.keys())
