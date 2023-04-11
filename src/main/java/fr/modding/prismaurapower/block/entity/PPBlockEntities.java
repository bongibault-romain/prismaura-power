package fr.modding.prismaurapower.block.entity;

import fr.modding.prismaurapower.PrismauraPower;
import fr.modding.prismaurapower.block.PPBlocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class PPBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, PrismauraPower.MOD_ID);

    public static final RegistryObject<BlockEntityType<PrismaticForgeBlockEntity>> PRISMATIC_FORGE_BLOCK_ENTITY = PPBlockEntities.BLOCK_ENTITIES.register("prismatic_forge_block_entity", (() -> BlockEntityType.Builder.of(PrismaticForgeBlockEntity::new, PPBlocks.PRISMATIC_FORGE.get()).build(null)));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
