package fr.modding.prismaurapower.event;

import fr.modding.prismaurapower.PrismauraPower;
import fr.modding.prismaurapower.recipe.PrismaticForgeRecipe;
import net.minecraft.core.Registry;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = PrismauraPower.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class PPEventBusEvents {

    @SubscribeEvent
    public static void registerRecipeTypes(final RegistryEvent.Register<RecipeSerializer<?>> event) {
        Registry.register(Registry.RECIPE_TYPE, PrismaticForgeRecipe.Type.getInstance().getId(), PrismaticForgeRecipe.Type.getInstance());

    }

}
