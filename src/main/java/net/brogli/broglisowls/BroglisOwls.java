package net.brogli.broglisowls;

import com.mojang.logging.LogUtils;
import net.brogli.broglisowls.entity.BroglisOwlsEntityTypes;
import net.brogli.broglisowls.item.BroglisOwlsItems;
import net.brogli.broglisowls.sound.BroglisOwlsSounds;
import net.brogli.broglisowls.world.biomemods.BroglisOwlsBiomeModifiers;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import software.bernie.example.GeckoLibMod;
import software.bernie.geckolib3.GeckoLib;


@Mod(BroglisOwls.MOD_ID)
public class BroglisOwls
{
    public static final String MOD_ID = "broglisowls";
    private static final Logger LOGGER = LogUtils.getLogger();

    public BroglisOwls()
    {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        BroglisOwlsEntityTypes.register(eventBus);
        BroglisOwlsItems.register(eventBus);
        BroglisOwlsSounds.register(eventBus);
        BroglisOwlsBiomeModifiers.register(eventBus);

        eventBus.addListener(this::setup);

        FMLJavaModLoadingContext.get().getModEventBus();

        GeckoLibMod.DISABLE_IN_DEV = true;
        GeckoLib.initialize();

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {

            SpawnPlacements.register(BroglisOwlsEntityTypes.ENTITY_OWL.get(),
                    SpawnPlacements.Type.ON_GROUND,
                    Heightmap.Types.MOTION_BLOCKING,
                    Animal::checkAnimalSpawnRules);
        });
    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
        }
    }
}
