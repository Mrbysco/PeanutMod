package com.mrbysco.peanutcraft.datagen.server;

import com.mrbysco.peanutcraft.init.ModRegistry;
import com.mrbysco.peanutcraft.init.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.common.Tags;

import java.util.concurrent.CompletableFuture;

public class PeanutRecipeProvider extends RecipeProvider {

	public PeanutRecipeProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
		super(packOutput, lookupProvider);
	}

	@Override
	protected void buildRecipes(RecipeOutput recipeOutput) {
		ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModRegistry.PEANUT_BREAD.get())
				.pattern("#P#")
				.define('#', Tags.Items.CROPS_WHEAT)
				.define('P', ModTags.CROPS_PEANUT)
				.unlockedBy("has_peanut", has(ModTags.CROPS_PEANUT)).save(recipeOutput);
		ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModRegistry.PEANUT_BUTTER.get())
				.pattern("PMP")
				.define('M', Items.MILK_BUCKET)
				.define('P', ModTags.CROPS_PEANUT)
				.unlockedBy("has_peanut", has(ModTags.CROPS_PEANUT)).save(recipeOutput);
		ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModRegistry.PEANUT_BUTTER_BREAD.get())
				.pattern("PB")
				.define('P', ModRegistry.PEANUT_BUTTER.get())
				.define('B', Items.BREAD)
				.unlockedBy("has_peanut", has(ModTags.CROPS_PEANUT)).save(recipeOutput);
		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModRegistry.PEANUT_PIE.get())
				.requires(Tags.Items.EGGS)
				.requires(Items.SUGAR)
				.requires(ModTags.CROPS_PEANUT)
				.unlockedBy("has_peanut", has(ModTags.CROPS_PEANUT)).save(recipeOutput);

	}
}
