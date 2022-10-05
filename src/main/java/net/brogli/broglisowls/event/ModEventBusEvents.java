package net.brogli.broglisowls.event;


import net.brogli.broglisowls.BroglisOwls;
import net.brogli.broglisowls.entity.BroglisOwlsEntityTypes;
import net.brogli.broglisowls.entity.custom.Owl;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = BroglisOwls.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {

    @SubscribeEvent
    public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
        event.put(BroglisOwlsEntityTypes.OWL_ENTITY_TYPE.get(), Owl.setAttributes());
    }
}
