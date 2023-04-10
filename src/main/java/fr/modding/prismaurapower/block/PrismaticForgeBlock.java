package fr.modding.prismaurapower.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;

public class PrismaticForgeBlock extends Block {
    public PrismaticForgeBlock() {
        super(BlockBehaviour.Properties.of(Material.WOOD).requiresCorrectToolForDrops().strength(1f));
    }
}
