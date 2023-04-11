package fr.modding.prismaurapower.recipe;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import fr.modding.prismaurapower.PrismauraPower;
import fr.modding.prismaurapower.block.entity.PrismaticForgeBlockEntity;
import net.minecraft.core.NonNullList;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.registries.ForgeRegistryEntry;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Map;
import java.util.Set;

public class PrismaticForgeRecipe implements Recipe<SimpleContainer> {
    private final ResourceLocation id;

    private final ItemStack output;

    private final NonNullList<Ingredient> recipeItems;

    private final Ingredient infuser;

    public PrismaticForgeRecipe(ResourceLocation id, ItemStack output,
                                   NonNullList<Ingredient> recipeItems, Ingredient infuser) {
        this.id = id;
        this.output = output;
        this.recipeItems = recipeItems;
        this.infuser = infuser;
    }

    @Override
    public boolean matches(@NotNull SimpleContainer pContainer, @NotNull Level pLevel) {
        for (int i = 0; i < this.recipeItems.size(); i++) {
            if (!this.recipeItems.get(i).test(pContainer.getItem(i))) {
                return false;
            }
        }

        return this.infuser .test(pContainer.getItem(20));
    }

    public Ingredient getInfuser() {
        return infuser;
    }

    public ItemStack getOutput() {
        return output;
    }

    @Override
    public @NotNull NonNullList<Ingredient> getIngredients() {
        return this.recipeItems;
    }

    @Override
    public @NotNull ItemStack assemble(@NotNull SimpleContainer pContainer) {
        return output;
    }

    @Override
    public boolean canCraftInDimensions(int pWidth, int pHeight) {
        return true;
    }

    @Override
    public @NotNull ItemStack getResultItem() {
        return output.copy();
    }

    @Override
    public @NotNull ResourceLocation getId() {
        return id;
    }

    @Override
    public @NotNull RecipeSerializer<?> getSerializer() {
        return Serializer.getInstance();
    }

    @Override
    public @NotNull RecipeType<PrismaticForgeRecipe> getType() {
        return Type.getInstance();
    }

    public static class Type implements RecipeType<PrismaticForgeRecipe> {
        private static final Type instance = new Type();

        private final String id = "prismatic_forge";

        public static Type getInstance() {
            return instance;
        }

        public String getId() {
            return id;
        }
    }

    public static class Serializer implements RecipeSerializer<PrismaticForgeRecipe> {
        private static Serializer instance = new Serializer();

        private static final int[] MAX_WIDTHS = {4, 5, 2, 5, 4};

        private static final int MAX_HEIGHT = 5;

        private ResourceLocation id = new ResourceLocation(PrismauraPower.MOD_ID, "prismatic_forge");

        private Map<String, Ingredient> keyFromJson(JsonObject pKeyEntry) {
            Map<String, Ingredient> map = Maps.newHashMap();

            for(Map.Entry<String, JsonElement> entry : pKeyEntry.entrySet()) {
                if (entry.getKey().length() != 1) {
                    throw new JsonSyntaxException("Invalid key entry: '" + entry.getKey() + "' is an invalid symbol (must be 1 character only).");
                }

                if (" ".equals(entry.getKey())) {
                    throw new JsonSyntaxException("Invalid key entry: ' ' is a reserved symbol.");
                }

                map.put(entry.getKey(), Ingredient.fromJson(entry.getValue()));
            }

            map.put(" ", Ingredient.EMPTY);
            return map;
        }

        private NonNullList<Ingredient> dissolvePattern(String[] pattern, Map<String, Ingredient> keys) {
            NonNullList<Ingredient> ingredients = NonNullList.withSize(20, Ingredient.EMPTY);
            Set<String> unusedKeys = Sets.newHashSet(keys.keySet());
            unusedKeys.remove(" ");

            int totalBefore = 0;

            for(int i = 0; i < pattern.length; i++) {
                for(int j = 0; j < pattern[i].length(); j++) {
                    String s = pattern[i].substring(j, j + 1);
                    Ingredient ingredient = keys.get(s);

                    if (ingredient == null) {
                        throw new JsonSyntaxException("Pattern references symbol '" + s + "' but it's not defined in the key");
                    }

                    unusedKeys.remove(s);
                    ingredients.set(j + totalBefore, ingredient);
                }

                totalBefore += MAX_WIDTHS[i];
            }

            if (!unusedKeys.isEmpty()) {
                throw new JsonSyntaxException("Key defines symbols that aren't used in pattern: " + unusedKeys);
            } else {
                return ingredients;
            }
        }

        private String[] patternFromJson(JsonArray pPatternArray) {
            String[] astring = new String[pPatternArray.size()];
            if (astring.length > MAX_HEIGHT) {
                throw new JsonSyntaxException("Invalid pattern: too many rows, " + MAX_HEIGHT + " is maximum");
            } else if (astring.length == 0) {
                throw new JsonSyntaxException("Invalid pattern: empty pattern not allowed");
            } else {
                for(int i = 0; i < astring.length; ++i) {
                    String s = GsonHelper.convertToString(pPatternArray.get(i), "pattern[" + i + "]");
                    if (s.length() > MAX_WIDTHS[i]) {
                        throw new JsonSyntaxException("Invalid pattern: too many columns for this line (" + i + "), " + MAX_WIDTHS[i] + " is maximum");
                    }

                    astring[i] = s;
                }

                return astring;
            }
        }


        @Override
        public @NotNull PrismaticForgeRecipe fromJson(@NotNull ResourceLocation pRecipeId, @NotNull JsonObject pJson) {
            Map<String, Ingredient> keys = this.keyFromJson(GsonHelper.getAsJsonObject(pJson, "key"));
            Ingredient infuser = Ingredient.fromJson(pJson.get("infuser"));

            ItemStack itemstack = CraftingHelper.getItemStack(GsonHelper.getAsJsonObject(pJson, "result"), true, true);

            String[] pattern = this.patternFromJson(pJson.getAsJsonArray("pattern"));

            NonNullList<Ingredient> ingredients = this.dissolvePattern(pattern, keys);

            return new PrismaticForgeRecipe(pRecipeId, itemstack, ingredients, infuser);

        }

        @Nullable
        @Override
        public PrismaticForgeRecipe fromNetwork(@NotNull ResourceLocation pRecipeId, @NotNull FriendlyByteBuf pBuffer) {
            int size = pBuffer.readVarInt();

            NonNullList<Ingredient> ingredients = NonNullList.withSize(size, Ingredient.EMPTY);

            Ingredient infuser = Ingredient.EMPTY;

            for (int i = 0; i < size - 1; i++) {
                if (i == 0) {
                    infuser = Ingredient.fromNetwork(pBuffer);
                    continue;
                }

                ingredients.add(Ingredient.fromNetwork(pBuffer));
            }

            ItemStack itemstack = pBuffer.readItem();

            return new PrismaticForgeRecipe(pRecipeId, itemstack, ingredients, infuser);
        }

        @Override
        public void toNetwork(@NotNull FriendlyByteBuf pBuffer, @NotNull PrismaticForgeRecipe pRecipe) {
            pBuffer.writeVarInt(PrismaticForgeBlockEntity.getInventorySize());

            pRecipe.infuser.toNetwork(pBuffer);

            for (Ingredient ingredient : pRecipe.getIngredients()) {
                ingredient.toNetwork(pBuffer);
            }

            pBuffer.writeItem(pRecipe.getOutput());
        }

        @Override
        public RecipeSerializer<?> setRegistryName(ResourceLocation name) {
            return Serializer.getInstance();
        }

        @Nullable
        @Override
        public ResourceLocation getRegistryName() {
            return Serializer.getInstance().getId();
        }

        @Override
        public Class<RecipeSerializer<?>> getRegistryType() {
            return Serializer.castClass(RecipeSerializer.class);
        }

        @SuppressWarnings("unchecked") // Need this wrapper, because generics
        private static <G> Class<G> castClass(Class<?> cls) {
            return (Class<G>)cls;
        }

        public static Serializer getInstance() {
            return instance;
        }

        public ResourceLocation getId() {
            return this.id;
        }
    }

}
