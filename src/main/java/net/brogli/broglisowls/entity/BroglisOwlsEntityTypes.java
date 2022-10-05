package net.brogli.broglisowls.entity;


import net.brogli.broglisowls.BroglisOwls;
import net.brogli.broglisowls.entity.custom.Owl;
import net.brogli.broglisowls.entity.projectile.ThrownOwlEgg;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BroglisOwlsEntityTypes {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, BroglisOwls.MOD_ID);
    public static final RegistryObject<EntityType<Owl>> OWL_ENTITY_TYPE =
            ENTITY_TYPES.register("entity_owl",
                    () -> EntityType.Builder.of(Owl::new, MobCategory.CREATURE)
                            .clientTrackingRange(9)
                            .sized(0.7f, 0.9f)
                            .build(new ResourceLocation(BroglisOwls.MOD_ID, "entity_owl").toString()));

    public static final RegistryObject<EntityType<ThrownOwlEgg>> THROWN_OWL_EGG =
            ENTITY_TYPES.register("thrown_owl_egg",
                    () -> EntityType.Builder.<ThrownOwlEgg>of(ThrownOwlEgg::new, MobCategory.MISC)
                            .sized(0.25F, 0.25F)
                            .clientTrackingRange(4)
                            .updateInterval(10)
                            .build(new ResourceLocation(BroglisOwls.MOD_ID, "thrown_owl_egg").toString()));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
