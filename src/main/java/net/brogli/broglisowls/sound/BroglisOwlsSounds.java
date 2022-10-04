package net.brogli.broglisowls.sound;

import net.brogli.broglisowls.BroglisOwls;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BroglisOwlsSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, BroglisOwls.MOD_ID);

    public static final RegistryObject<SoundEvent> OWL_AMBIENT_1 =
            registerSoundEvent("owl_ambient_1");

    public static final RegistryObject<SoundEvent> OWL_AMBIENT_2 =
            registerSoundEvent("owl_ambient_2");

    public static final RegistryObject<SoundEvent> BABY_OWL_AMBIENT_1 =
            registerSoundEvent("baby_owl_ambient_1");

    public static final RegistryObject<SoundEvent> BABY_OWL_AMBIENT_2 =
            registerSoundEvent("baby_owl_ambient_2");


    private static RegistryObject<SoundEvent> registerSoundEvent(String name) {
        return SOUND_EVENTS.register(name, () -> new SoundEvent(new ResourceLocation(BroglisOwls.MOD_ID, name)));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}
