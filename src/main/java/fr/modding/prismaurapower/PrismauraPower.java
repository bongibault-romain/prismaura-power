package fr.modding.prismaurapower;

import com.mojang.logging.LogUtils;
import fr.modding.prismaurapower.block.PPBlocks;
import fr.modding.prismaurapower.block.entity.PPBlockEntities;
import fr.modding.prismaurapower.item.PPItems;
import fr.modding.prismaurapower.recipe.PPSerializers;
import fr.modding.prismaurapower.screen.PPMenuTypes;
import fr.modding.prismaurapower.screen.screen.PrismaticForgeScreen;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(PrismauraPower.MOD_ID)
public class PrismauraPower
{
    public static final String MOD_ID = "prismaurapower";

    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public PrismauraPower()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        PPItems.register(modEventBus);
        PPBlocks.register(modEventBus);

        PPBlockEntities.register(modEventBus);
        PPMenuTypes.register(modEventBus);

        PPSerializers.register(modEventBus);

        // Register the setup method for modloading
        modEventBus.addListener(this::setup);
        modEventBus.addListener(this::clientSetup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        // some preinit code
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }

    private void clientSetup(final FMLClientSetupEvent  event) {
        MenuScreens.register(PPMenuTypes.PRISMATIC_FORGE_MENU.get(), PrismaticForgeScreen::new);
    }
}
