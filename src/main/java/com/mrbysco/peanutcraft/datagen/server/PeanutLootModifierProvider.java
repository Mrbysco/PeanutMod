package com.mrbysco.peanutcraft.datagen.server;

import com.mrbysco.peanutcraft.PeanutCraft;
import com.mrbysco.peanutcraft.init.GrassDrops;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.predicates.AnyOfCondition;
import net.minecraft.world.level.storage.loot.predicates.InvertedLootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.predicates.MatchTool;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.GlobalLootModifierProvider;

public class PeanutLootModifierProvider extends GlobalLootModifierProvider {
	public PeanutLootModifierProvider(PackOutput packOutput) {
		super(packOutput, PeanutCraft.MOD_ID);
	}

	@Override
	protected void start() {
		this.add("peanuts_from_grass", new GrassDrops(new LootItemCondition[]{
				LootItemRandomChanceCondition.randomChance(0.1F).build(),
				InvertedLootItemCondition.invert(MatchTool.toolMatches(ItemPredicate.Builder.item().of(Tags.Items.SHEARS))).build(),
				AnyOfCondition.anyOf(
						LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.GRASS),
						LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.TALL_GRASS),
						LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.FERN),
						LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.LARGE_FERN)
				).build()
		}));
	}
}
