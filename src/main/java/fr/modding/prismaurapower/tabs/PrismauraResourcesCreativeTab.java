package fr.modding.prismaurapower.tabs;

import fr.modding.prismaurapower.item.PPItems;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class PrismauraResourcesCreativeTab extends CreativeModeTab {
    public PrismauraResourcesCreativeTab(String label) {
        super(label);
    }

    @Override
    public @NotNull ItemStack makeIcon() {
        return new ItemStack(PPItems.INFINITUM_CRYSTAL.get());
    }
}
