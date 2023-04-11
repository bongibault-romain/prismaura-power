package fr.modding.prismaurapower.recipe;

import fr.modding.prismaurapower.PrismauraPower;
import fr.modding.prismaurapower.recipe.PrismaticForgeRecipe;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class PPSerializers {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, PrismauraPower.MOD_ID);

    public static final RegistryObject<RecipeSerializer<PrismaticForgeRecipe>> PRISMATIC_FORGE_SERIALIZER = SERIALIZERS.register("prismatic_forge", PrismaticForgeRecipe.Serializer::getInstance);

    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
    }
}
