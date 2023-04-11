package fr.modding.prismaurapower.screen;

import fr.modding.prismaurapower.PrismauraPower;
import fr.modding.prismaurapower.screen.menu.PrismaticForgeMenu;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.network.IContainerFactory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class PPMenuTypes {
    public static DeferredRegister<MenuType<?>> MENUS = DeferredRegister.create(ForgeRegistries.CONTAINERS, PrismauraPower.MOD_ID);

    public static final RegistryObject<MenuType<PrismaticForgeMenu>> PRISMATIC_FORGE_MENU = registerMenu(PrismaticForgeMenu::new, "prismatic_forge_menu");

    private static <T extends AbstractContainerMenu>RegistryObject<MenuType<T>> registerMenu(IContainerFactory<T> factory, String name) {
        return PPMenuTypes.MENUS.register(name, () -> IForgeMenuType.create(factory));
    }

    public static void register(IEventBus eventBus) {
        PPMenuTypes.MENUS.register(eventBus);
    }
}
