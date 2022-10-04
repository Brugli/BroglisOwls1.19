package net.brogli.broglisowls.event;


import net.brogli.broglisowls.BroglisOwls;
import net.brogli.broglisowls.entity.BroglisOwlsEntityTypes;
import net.brogli.broglisowls.entity.custom.EntityBabyOwl;
import net.brogli.broglisowls.entity.custom.EntityOwl;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = BroglisOwls.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {


    @SubscribeEvent
    public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
        event.put(BroglisOwlsEntityTypes.ENTITY_OWL.get(), EntityOwl.setAttributes());
        event.put(BroglisOwlsEntityTypes.ENTITY_BABY_OWL.get(), EntityBabyOwl.setAttributes());
    }
}
