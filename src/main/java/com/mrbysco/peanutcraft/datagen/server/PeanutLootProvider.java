package com.mrbysco.peanutcraft.datagen.server;

import com.mrbysco.peanutcraft.blocks.PeanutCropBlock;
import com.mrbysco.peanutcraft.init.ModRegistry;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.WritableRegistry;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.ProblemReporter;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.ValidationContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class PeanutLootProvider extends LootTableProvider {
	public PeanutLootProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
		super(packOutput, Set.of(), List.of(
				new SubProviderEntry(PeanutBlocks::new, LootContextParamSets.BLOCK)
		), lookupProvider);
	}

	@Override
	protected void validate(WritableRegistry<LootTable> writableregistry, ValidationContext validationcontext, ProblemReporter.Collector problemreporter$collector) {
		super.validate(writableregistry, validationcontext, problemreporter$collector);
	}

	private static class PeanutBlocks extends BlockLootSubProvider {

		protected PeanutBlocks() {
			super(Set.of(), FeatureFlags.REGISTRY.allFlags());
		}

		@Override
		protected void generate() {
			LootItemCondition.Builder peanutCropConditionBuilder = LootItemBlockStatePropertyCondition
					.hasBlockStateProperties(ModRegistry.PEANUT_CROP.get())
					.setProperties(StatePropertiesPredicate.Builder.properties()
							.hasProperty(PeanutCropBlock.AGE, PeanutCropBlock.MAX_AGE));
			this.add(ModRegistry.PEANUT_CROP.get(), (block) -> createCropDrops(ModRegistry.PEANUT_CROP.get(), ModRegistry.PEANUT.get(), ModRegistry.PEANUT_SEEDS.get(), peanutCropConditionBuilder));
		}

		@Override
		protected Iterable<Block> getKnownBlocks() {
			return (Iterable<Block>) ModRegistry.BLOCKS.getEntries().stream().map(holder -> (Block) holder.get())::iterator;
		}
	}
}
