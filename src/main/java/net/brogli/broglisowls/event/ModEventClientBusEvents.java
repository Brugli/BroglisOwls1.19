package net.brogli.broglisowls.event;


import net.brogli.broglisowls.BroglisOwls;
import net.brogli.broglisowls.entity.BroglisOwlsEntityTypes;
import net.brogli.broglisowls.entity.client.OwlRenderer;
import net.brogli.broglisowls.entity.client.ThrownOwlEggRenderer;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = BroglisOwls.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventClientBusEvents {

    @SubscribeEvent
    public static void clientSetup(final FMLClientSetupEvent event) {
        EntityRenderers.register(BroglisOwlsEntityTypes.OWL_ENTITY_TYPE.get(), OwlRenderer::new);
        EntityRenderers.register(BroglisOwlsEntityTypes.THROWN_OWL_EGG.get(), ThrownOwlEggRenderer::new);
    }

    @SubscribeEvent
    public static void registerRenderers(final EntityRenderersEvent.RegisterRenderers event) {
    }
}
