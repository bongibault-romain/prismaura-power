package fr.modding.prismaurapower.integration.jei;

import fr.modding.prismaurapower.recipe.PrismaticForgeRecipe;
import fr.modding.prismaurapower.screen.menu.PrismaticForgeMenu;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.recipe.transfer.IRecipeTransferError;
import mezz.jei.api.recipe.transfer.IRecipeTransferHandler;
import mezz.jei.api.recipe.transfer.IRecipeTransferHandlerHelper;
import mezz.jei.api.recipe.transfer.IRecipeTransferInfo;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class PrismaticForgeRecipeTransferHandler implements IRecipeTransferInfo<PrismaticForgeMenu, PrismaticForgeRecipe> {
    @Override
    public @NotNull Class<PrismaticForgeMenu> getContainerClass() {
        return PrismaticForgeMenu.class;
    }

    @Override
    public boolean canHandle(@NotNull PrismaticForgeMenu container, @NotNull PrismaticForgeRecipe recipe) {
        return true;
    }

    @Override
    public @NotNull List<Slot> getRecipeSlots(@NotNull PrismaticForgeMenu container, @NotNull PrismaticForgeRecipe recipe) {
        return container.slots;
    }

    @Override
    public @NotNull List<Slot> getInventorySlots(@NotNull PrismaticForgeMenu container, @NotNull PrismaticForgeRecipe recipe) {
        return container.slots;
    }


    @Override
    public @NotNull Class<PrismaticForgeRecipe> getRecipeClass() {
        return PrismaticForgeRecipe.class;
    }

    @Override
    public @NotNull ResourceLocation getRecipeCategoryUid() {
        return null;
    }
}
