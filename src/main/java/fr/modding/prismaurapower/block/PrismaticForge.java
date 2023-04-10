package fr.modding.prismaurapower.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import org.jetbrains.annotations.Nullable;

public class PrismaticForge extends Block {
    public PrismaticForge() {
        super(BlockBehaviour.Properties.of(Material.WOOD).requiresCorrectToolForDrops().strength(1f));
    }
}
