package fr.modding.prismaurapower.integration.jei;

import fr.modding.prismaurapower.recipe.PrismaticForgeRecipe;
import mezz.jei.api.recipe.RecipeType;

public class RecipeTypes {
    public static final RecipeType<PrismaticForgeRecipe> PRISMATIC_FORGE = new RecipeType<PrismaticForgeRecipe>(PrismaticForgeRecipeCategory.UID, PrismaticForgeRecipe.class);
}
