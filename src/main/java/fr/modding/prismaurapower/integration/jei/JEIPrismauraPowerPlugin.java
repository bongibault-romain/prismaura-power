package fr.modding.prismaurapower.integration.jei;

import fr.modding.prismaurapower.PrismauraPower;
import fr.modding.prismaurapower.block.PPBlocks;
import fr.modding.prismaurapower.recipe.PrismaticForgeRecipe;
import fr.modding.prismaurapower.screen.menu.PrismaticForgeMenu;
import fr.modding.prismaurapower.screen.screen.PrismaticForgeScreen;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.registration.*;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.List;

@JeiPlugin
public class JEIPrismauraPowerPlugin implements IModPlugin {
    @Override
    public @NotNull ResourceLocation getPluginUid() {
        return new ResourceLocation(PrismauraPower.MOD_ID, "jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new
                PrismaticForgeRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerGuiHandlers(IGuiHandlerRegistration registration) {
        registration.addRecipeClickArea(PrismaticForgeScreen.class, 124, 60, 25, 18, RecipeTypes.PRISMATIC_FORGE);
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        registration.addRecipeCatalyst(new ItemStack(PPBlocks.PRISMATIC_FORGE.get().asItem(), 1), RecipeTypes.PRISMATIC_FORGE);
    }

    @Override
    public void registerRecipeTransferHandlers(IRecipeTransferRegistration registration) {
        registration.addRecipeTransferHandler(PrismaticForgeMenu.class, RecipeTypes.PRISMATIC_FORGE, 36, 21, 0, 36);
    }

    @Override
    public void registerRecipes(@NotNull IRecipeRegistration registration) {
        ClientLevel world = Minecraft.getInstance().level;

        if (world == null) return;

        List<PrismaticForgeRecipe> recipes = world.getRecipeManager().getAllRecipesFor(PrismaticForgeRecipe.Type.getInstance());
        registration.addRecipes((RecipeType<PrismaticForgeRecipe>) RecipeTypes.PRISMATIC_FORGE, recipes);
    }
}
