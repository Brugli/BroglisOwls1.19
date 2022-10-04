package net.brogli.broglisowls.item;

import net.brogli.broglisowls.BroglisOwls;
import net.brogli.broglisowls.item.custom.ItemOwlEgg;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.EggItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BroglisOwlsItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, BroglisOwls.MOD_ID);

    public static final RegistryObject<ItemOwlEgg> ITEM_OWL_EGG = ITEMS.register("item_owl_egg",
            () -> new ItemOwlEgg(new Item.Properties().stacksTo(16).tab(CreativeModeTab.TAB_MATERIALS)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
