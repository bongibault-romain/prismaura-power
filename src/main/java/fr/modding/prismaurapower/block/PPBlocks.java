package fr.modding.prismaurapower.block;

import fr.modding.prismaurapower.PrismauraPower;
import fr.modding.prismaurapower.item.PPItems;
import fr.modding.prismaurapower.tabs.PPCreativeTabs;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class PPBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, PrismauraPower.MOD_ID);

    public static final RegistryObject<Block> PRISMAURA_BLOCK = registerBlock("prismaura_block", () -> new Block(BlockBehaviour.Properties.of(Material.HEAVY_METAL).requiresCorrectToolForDrops().strength(9f).destroyTime(3f)), PPCreativeTabs.TAB_RESOURCES);

    public static final RegistryObject<Block> TENEBRISITE_BLOCK = registerBlock("tenebrisite_block", () -> new Block(BlockBehaviour.Properties.of(Material.HEAVY_METAL).requiresCorrectToolForDrops().strength(9f).destroyTime(3f)), PPCreativeTabs.TAB_RESOURCES);

    public static final RegistryObject<Block> TEMPORITH_BLOCK = registerBlock("temporith_block", () -> new Block(BlockBehaviour.Properties.of(Material.HEAVY_METAL).requiresCorrectToolForDrops().strength(9f).destroyTime(3f)), PPCreativeTabs.TAB_RESOURCES);

    public static final RegistryObject<Block> IGNISIUM_BLOCK = registerBlock("ignisium_block", () -> new Block(BlockBehaviour.Properties.of(Material.HEAVY_METAL).requiresCorrectToolForDrops().strength(9f).destroyTime(3f)), PPCreativeTabs.TAB_RESOURCES);

    public static final RegistryObject<Block> OMBRELIA_BLOCK = registerBlock("ombrelia_block", () -> new Block(BlockBehaviour.Properties.of(Material.HEAVY_METAL).requiresCorrectToolForDrops().strength(9f).destroyTime(3f)), PPCreativeTabs.TAB_RESOURCES);

    public static final RegistryObject<Block> INFINITUM_BLOCK = registerBlock("infinitum_block", () -> new Block(BlockBehaviour.Properties.of(Material.HEAVY_METAL).requiresCorrectToolForDrops().strength(9f).destroyTime(3f)), PPCreativeTabs.TAB_RESOURCES);

    public static final RegistryObject<Block> HEAVY_FRAME = registerBlock("heavy_frame", () -> new Block(BlockBehaviour.Properties.of(Material.HEAVY_METAL).requiresCorrectToolForDrops().strength(9f).destroyTime(3f)), PPCreativeTabs.TAB_RESOURCES);

    public static final RegistryObject<Block> PRISMAURA_HEAVY_FRAME = registerBlock("prismaura_heavy_frame", () -> new Block(BlockBehaviour.Properties.of(Material.HEAVY_METAL).requiresCorrectToolForDrops().strength(9f).destroyTime(3f)), PPCreativeTabs.TAB_RESOURCES);

    public static final RegistryObject<Block> TENEBRISITE_HEAVY_FRAME = registerBlock("tenebrisite_heavy_frame", () -> new Block(BlockBehaviour.Properties.of(Material.HEAVY_METAL).requiresCorrectToolForDrops().strength(9f).destroyTime(3f)), PPCreativeTabs.TAB_RESOURCES);

    public static final RegistryObject<Block> TEMPORITH_HEAVY_FRAME = registerBlock("temporith_heavy_frame", () -> new Block(BlockBehaviour.Properties.of(Material.HEAVY_METAL).requiresCorrectToolForDrops().strength(9f).destroyTime(3f)), PPCreativeTabs.TAB_RESOURCES);

    public static final RegistryObject<Block> IGNISIUM_HEAVY_FRAME = registerBlock("ignisium_heavy_frame", () -> new Block(BlockBehaviour.Properties.of(Material.HEAVY_METAL).requiresCorrectToolForDrops().strength(9f).destroyTime(3f)), PPCreativeTabs.TAB_RESOURCES);

    public static final RegistryObject<Block> OMBRELIA_HEAVY_FRAME = registerBlock("ombrelia_heavy_frame", () -> new Block(BlockBehaviour.Properties.of(Material.HEAVY_METAL).requiresCorrectToolForDrops().strength(9f).destroyTime(3f)), PPCreativeTabs.TAB_RESOURCES);

    public static final RegistryObject<Block> INFINITUM_HEAVY_FRAME = registerBlock("infinitum_heavy_frame", () -> new Block(BlockBehaviour.Properties.of(Material.HEAVY_METAL).requiresCorrectToolForDrops().strength(9f).destroyTime(3f)), PPCreativeTabs.TAB_RESOURCES);

    public static final RegistryObject<Block> COMPRESSED_IRON_BLOCK = registerBlock("compressed_iron_block", () -> new Block(BlockBehaviour.Properties.of(Material.HEAVY_METAL).requiresCorrectToolForDrops().strength(9f).destroyTime(3f)), PPCreativeTabs.TAB_RESOURCES);

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = PPBlocks.BLOCKS.register(name, block);
        PPBlocks.registerBlockItem(name, toReturn, tab);

        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab) {
        return PPItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus) {
        PPBlocks.BLOCKS.register(eventBus);
    }
}
