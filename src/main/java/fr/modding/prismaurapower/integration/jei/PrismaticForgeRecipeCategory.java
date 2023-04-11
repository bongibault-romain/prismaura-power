package fr.modding.prismaurapower.integration.jei;

import fr.modding.prismaurapower.PrismauraPower;
import fr.modding.prismaurapower.block.PPBlocks;
import fr.modding.prismaurapower.recipe.PrismaticForgeRecipe;
import fr.modding.prismaurapower.screen.slot.ResultSlot;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.items.SlotItemHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class PrismaticForgeRecipeCategory implements IRecipeCategory<PrismaticForgeRecipe> {
    public final static ResourceLocation UID = new ResourceLocation(PrismauraPower.MOD_ID, "prismatic_forge");
    public final static ResourceLocation TEXTURE =
            new ResourceLocation(PrismauraPower.MOD_ID, "textures/gui/prismatic_forge.png");

    private final IDrawable background;
    private final IDrawable icon;

    public PrismaticForgeRecipeCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 9, 12, 175, 113);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(PPBlocks.PRISMATIC_FORGE.get()));
    }

    @Override
    public @NotNull ResourceLocation getUid() {
        return UID;
    }

    @Override
    public @NotNull Class<? extends PrismaticForgeRecipe> getRecipeClass() {
        return PrismaticForgeRecipe.class;
    }

    @Override
    public @Nullable ResourceLocation getRegistryName(PrismaticForgeRecipe recipe) {
        return recipe.getId();
    }

    @Override
    public @NotNull Component getTitle() {
        return new TextComponent("Prismatic Forge");
    }

    @Override
    public @NotNull IDrawable getBackground() {
        return this.background;
    }

    @Override
    public @NotNull IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public void setRecipe(@NotNull IRecipeLayoutBuilder builder, @NotNull PrismaticForgeRecipe recipe, @NotNull IFocusGroup focusGroup) {
        builder.addSlot(RecipeIngredientRole.INPUT, 5, 5).addIngredients(recipe.getIngredients().get(0));
        builder.addSlot(RecipeIngredientRole.INPUT, 23, 5).addIngredients(recipe.getIngredients().get(1));
        builder.addSlot(RecipeIngredientRole.INPUT, 75, 5).addIngredients(recipe.getIngredients().get(2));
        builder.addSlot(RecipeIngredientRole.INPUT, 93, 5).addIngredients(recipe.getIngredients().get(3));

        builder.addSlot(RecipeIngredientRole.INPUT, 5, 23).addIngredients(recipe.getIngredients().get(4));
        builder.addSlot(RecipeIngredientRole.INPUT, 31, 31).addIngredients(recipe.getIngredients().get(5));
        builder.addSlot(RecipeIngredientRole.INPUT, 49, 31).addIngredients(recipe.getIngredients().get(6));
        builder.addSlot(RecipeIngredientRole.INPUT, 67, 31).addIngredients(recipe.getIngredients().get(7));
        builder.addSlot(RecipeIngredientRole.INPUT, 93, 23).addIngredients(recipe.getIngredients().get(8));

        builder.addSlot(RecipeIngredientRole.INPUT, 31, 49).addIngredients(recipe.getIngredients().get(9));
        builder.addSlot(RecipeIngredientRole.INPUT, 67, 49).addIngredients(recipe.getIngredients().get(10));

        builder.addSlot(RecipeIngredientRole.INPUT, 5, 75).addIngredients(recipe.getIngredients().get(11));
        builder.addSlot(RecipeIngredientRole.INPUT, 31, 67).addIngredients(recipe.getIngredients().get(12));
        builder.addSlot(RecipeIngredientRole.INPUT, 49, 67).addIngredients(recipe.getIngredients().get(13));
        builder.addSlot(RecipeIngredientRole.INPUT, 67, 67).addIngredients(recipe.getIngredients().get(14));
        builder.addSlot(RecipeIngredientRole.INPUT, 93, 75).addIngredients(recipe.getIngredients().get(15));

        builder.addSlot(RecipeIngredientRole.INPUT, 5, 93).addIngredients(recipe.getIngredients().get(16));
        builder.addSlot(RecipeIngredientRole.INPUT, 23, 93).addIngredients(recipe.getIngredients().get(17));
        builder.addSlot(RecipeIngredientRole.INPUT, 75, 93).addIngredients(recipe.getIngredients().get(18));
        builder.addSlot(RecipeIngredientRole.INPUT, 93, 93).addIngredients(recipe.getIngredients().get(19));

        builder.addSlot(RecipeIngredientRole.INPUT, 151, 20).addIngredients(recipe.getInfuser());
        builder.addSlot(RecipeIngredientRole.OUTPUT, 151, 77).addItemStack(recipe.getOutput());
    }
}
