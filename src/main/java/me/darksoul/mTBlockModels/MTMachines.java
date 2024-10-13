package me.darksoul.mTBlockModels;

import com.MT.xxxtrigger50xxx.Devices.*;
import com.MT.xxxtrigger50xxx.Devices.Defense.*;
import com.MT.xxxtrigger50xxx.Devices.Generators.*;
import com.MT.xxxtrigger50xxx.Devices.Liquids.BarrelPump;
import com.MT.xxxtrigger50xxx.Devices.Liquids.Boiler;
import com.MT.xxxtrigger50xxx.Devices.Liquids.Pump;
import com.MT.xxxtrigger50xxx.Devices.Manufactoring.*;
import com.MT.xxxtrigger50xxx.Devices.Producers.*;
import com.MT.xxxtrigger50xxx.Devices.Transport.*;
import com.MT.xxxtrigger50xxx.Devices.Utility.*;
import com.MT.xxxtrigger50xxx.Technology.ResearchLab;

import java.util.HashMap;
import java.util.Map;

public class MTMachines {

    // HashMap to store machines and their corresponding items and settings
    public static final Map<Class<?>, Object[]> blockDict = new HashMap<>();

    static {
        blockDict.put(HumanTeleporter.class, new Object[]{MTItems.HUMAN_TELEPORTER, "xz"});
        blockDict.put(ColdFusionReactor.class, new Object[]{MTItems.COLD_FUSION_REACTOR, "xz"});
        blockDict.put(Infuser.class, new Object[]{"xz", MTItems.INFUSER});
        blockDict.put(PollutionGenerator.class, new Object[]{MTItems.POLLUTION_GENERATOR, "xz"});
        blockDict.put(Sifter.class, new Object[]{MTItems.SIFTER, "xz"});
        blockDict.put(Crafter2.class, new Object[]{MTItems.CRAFTER, "xz"});
        blockDict.put(Pump.class, new Object[]{MTItems.PUMP, "xz"});
        blockDict.put(MoonlightPanel.class, new Object[]{MTItems.MOONLIGHT_PANEL, "xz"});
        blockDict.put(SolarPanel.class, new Object[]{MTItems.SOLAR_PANEL, "xz"});
        blockDict.put(AutoCollector.class, new Object[]{MTItems.AUTO_COLLECTOR, "xz"});
        blockDict.put(Elevator.class, new Object[]{MTItems.ELEVATOR, "xz"});
        blockDict.put(ItemTeleporter.class, new Object[]{MTItems.ITEM_TELEPORTER, "xz"});
        blockDict.put(AutoTimer.class, new Object[]{MTItems.AUTO_TIMER, "xz"});
        blockDict.put(AutoShearer.class, new Object[]{MTItems.AUTO_SHEARER, "xz"});
        blockDict.put(AutoMilker.class, new Object[]{MTItems.AUTO_MILKER, "xz"});
        blockDict.put(AutoBreeder.class, new Object[]{MTItems.AUTO_BREEDER, "xz"});
        blockDict.put(DeepDrill.class, new Object[]{MTItems.DEEP_DRILL, "xz"});
        blockDict.put(AutoPlucker.class, new Object[]{MTItems.AUTO_PLUCKER, "xz"});
        blockDict.put(BowTurret.class, new Object[]{MTItems.BOW_TURRET, "xz"});
        blockDict.put(AutoPlanter.class, new Object[]{MTItems.AUTO_PLANTER, "xz"});
        blockDict.put(AutoLogger.class, new Object[]{MTItems.AUTO_LOGGER, "xz"});
        blockDict.put(AutoHarvester.class, new Object[]{MTItems.AUTO_HARVESTER, "xz"});
        blockDict.put(AutoMiner.class, new Object[]{MTItems.AUTO_MINER, "xz"});
        blockDict.put(AutoButcher.class, new Object[]{MTItems.AUTO_BUTCHER, "xz"});
        blockDict.put(Incinerator.class, new Object[]{MTItems.INCINERATOR, "xz"});
        blockDict.put(PowerReceiver.class, new Object[]{MTItems.POWER_RECEIVER, "xz"});
        blockDict.put(AdvancedBowTurret.class, new Object[]{MTItems.ADVANCED_BOW_TURRET, "xz"});
        blockDict.put(LaserTurret.class, new Object[]{MTItems.LASER_TURRET, "xz"});
        blockDict.put(BiterDetector.class, new Object[]{MTItems.BITER_DETECTOR, "xz"});
        blockDict.put(HeatExchanger.class, new Object[]{MTItems.HEAT_EXCHANGER, "xz"});
        blockDict.put(RedstoneEmitter.class, new Object[]{MTItems.REDSTONE_EMITTER, "xz"});
        blockDict.put(PowerTransmitter.class, new Object[]{MTItems.POWER_TRANSMITTER, "xz"});
        blockDict.put(PowerMeter.class, new Object[]{MTItems.POWER_METER, "xz"});
        blockDict.put(NuclearReactor.class, new Object[]{MTItems.NUCLEAR_REACTOR, "xz"});
        blockDict.put(ItemForge.class, new Object[]{MTItems.ITEM_FORGE, "xz"});
        blockDict.put(BatteryMonitor.class, new Object[]{MTItems.BATTERY_MONITOR, "xz"});
        blockDict.put(Battery2.class, new Object[]{MTItems.BATTERY, "xz"});
        blockDict.put(BarrelPump.class, new Object[]{MTItems.BARREL_PUMP, "xz"});
        blockDict.put(PowerPylon.class, new Object[]{MTItems.POWER_PYLON, "xz"});
        blockDict.put(PowerPylonMk2.class, new Object[]{MTItems.POWER_PYLON_MK2, "xz"});
        blockDict.put(PowerSubstation.class, new Object[]{MTItems.POWER_SUBSTATION, "xz"});
        blockDict.put(Centrifuge.class, new Object[]{MTItems.CENTRIFUGE, "xz"});
        blockDict.put(ProductionMonitor.class, new Object[]{MTItems.PRODUCTION_MONITOR, "xz"});
        blockDict.put(GeothermalGenerator.class, new Object[]{MTItems.GEOTHERMAL_GENERATOR, "xz"});
        blockDict.put(SteamEngine.class, new Object[]{MTItems.STEAM_ENGINE, "xz"});
        blockDict.put(PetroleumEngine.class, new Object[]{MTItems.PETROLEUM_ENGINE, "xz"});
        blockDict.put(HeavySteamGenerator.class, new Object[]{MTItems.HEAVY_STEAM_GENERATOR, "xz"});
        blockDict.put(TidalGenerator.class, new Object[]{MTItems.TIDAL_GENERATOR, "xz"});
        blockDict.put(CombustionGenerator.class, new Object[]{MTItems.COMBUSTION_GENERATOR, "xz"});
        blockDict.put(WindTurbine.class, new Object[]{MTItems.WIND_TURBINE, "xz"});
        blockDict.put(Boiler.class, new Object[]{MTItems.BOILER, "xz"});
        blockDict.put(AdvancedAssembler.class, new Object[]{MTItems.ADVANCED_ASSEMBLER, "xz"});
        blockDict.put(BasicAssembler.class, new Object[]{MTItems.BASIC_ASSEMBLER, "xz"});
        blockDict.put(AutoBreaker.class, new Object[]{MTItems.AUTO_BREAKER, "DUNWES"});
        blockDict.put(AutoPlacer.class, new Object[]{MTItems.AUTO_PLACER, "DUNWES"});
        blockDict.put(TrainStation.class, new Object[]{MTItems.TRAIN_STATION, "xz"});
        blockDict.put(OverDriver.class, new Object[]{MTItems.OVERDRIVER, "DUNWES"});
        blockDict.put(ElectricFurnace.class, new Object[]{MTItems.ELECTRIC_FURNACE, "xz"});
        blockDict.put(OilRefinery.class, new Object[]{MTItems.OIL_REFINERY, "xz"});
        blockDict.put(Roboport.class, new Object[]{MTItems.ROBOPORT, "xz"});
        blockDict.put(MineLayer.class, new Object[]{MTItems.MINE_LAYER, "DUNWES"});
        blockDict.put(AutoCauldron.class, new Object[]{MTItems.AUTO_CAULDRON, "xz"});
        blockDict.put(FloodLight.class, new Object[]{MTItems.FLOOD_LIGHT, "DUNWES"});
        blockDict.put(Mover.class, new Object[]{MTItems.MOVER, "DUNWES"});
        blockDict.put(ResearchLab.class, new Object[]{MTItems.RESEARCH_LAB, "xz"});
    }
    // Machine list for easy access
    public static final Class<?>[] machineList = blockDict.keySet().toArray(new Class<?>[0]);

    // Method to get device type based on the class of the device
    public static String getDeviceType(Object device) {
        for (Map.Entry<Class<?>, Object[]> entry : blockDict.entrySet()) {
            if (entry.getKey().isInstance(device)) {
                return (String) entry.getValue()[1]; // Return the type associated with the device class
            }
        }
        return "unknown"; // Default if not found
    }

    // New method to get the item associated with the device
    public static Object getDeviceItem(Object device) {
        for (Map.Entry<Class<?>, Object[]> entry : blockDict.entrySet()) {
            if (entry.getKey().isInstance(device)) {
                return entry.getValue()[0]; // Return the item associated with the device class
            }
        }
        return null; // Default if not found
    }
}
