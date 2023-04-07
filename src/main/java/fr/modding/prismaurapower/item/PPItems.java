package fr.modding.prismaurapower.item;

import fr.modding.prismaurapower.PrismauraPower;
import fr.modding.prismaurapower.tabs.PPCreativeTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class PPItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, PrismauraPower.MOD_ID);

    public static final RegistryObject<Item> PRISMAURA_CRYSTAL = PPItems.ITEMS.register("prismaura_crystal", () -> new Item(new Item.Properties().tab(PPCreativeTabs.TAB_RESOURCES)));

    public static final RegistryObject<Item> TENEBRISITE_CRYSTAL = PPItems.ITEMS.register("tenebrisite_crystal", () -> new Item(new Item.Properties().tab(PPCreativeTabs.TAB_RESOURCES)));

    public static final RegistryObject<Item> TEMPORITH_CRYSTAL = PPItems.ITEMS.register("temporith_crystal", () -> new Item(new Item.Properties().tab(PPCreativeTabs.TAB_RESOURCES)));

    public static final RegistryObject<Item> IGNISIUM_CRYSTAL = PPItems.ITEMS.register("ignisium_crystal", () -> new Item(new Item.Properties().tab(PPCreativeTabs.TAB_RESOURCES)));

    public static final RegistryObject<Item> OMBRELIA_CRYSTAL = PPItems.ITEMS.register("ombrelia_crystal", () -> new Item(new Item.Properties().tab(PPCreativeTabs.TAB_RESOURCES)));

    public static final RegistryObject<Item> INFINITUM_CRYSTAL = PPItems.ITEMS.register("infinitum_crystal", () -> new Item(new Item.Properties().tab(PPCreativeTabs.TAB_RESOURCES)));

    public static void register(IEventBus eventBus) {
        PPItems.ITEMS.register(eventBus);
    }
}
