package net.brogli.broglisowls.event;


import net.brogli.broglisowls.BroglisOwls;
import net.brogli.broglisowls.entity.BroglisOwlsEntityTypes;
import net.brogli.broglisowls.entity.client.EntityBabyOwlRenderer;
import net.brogli.broglisowls.entity.client.EntityOwlRenderer;
import net.brogli.broglisowls.entity.client.ThrownOwlEggRenderer;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = BroglisOwls.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventClientBusEvents {

    @SubscribeEvent
    public static void clientSetup(final FMLClientSetupEvent event) {
        EntityRenderers.register(BroglisOwlsEntityTypes.ENTITY_OWL.get(), EntityOwlRenderer::new);
        EntityRenderers.register(BroglisOwlsEntityTypes.ENTITY_BABY_OWL.get(), EntityBabyOwlRenderer::new);
        EntityRenderers.register(BroglisOwlsEntityTypes.THROWN_OWL_EGG.get(), ThrownOwlEggRenderer::new);
    }

    @SubscribeEvent
    public static void registerRenderers(final EntityRenderersEvent.RegisterRenderers event) {
    }

    @SubscribeEvent
    public static void registerParticleFactories(final RegisterParticleProvidersEvent event) {
//        Minecraft.getInstance().particleEngine.register(BroglisOwlsParticles.FEATHER_PARTICLES.get(),
//                FeatherParticles.Provider::new);
    }

}
