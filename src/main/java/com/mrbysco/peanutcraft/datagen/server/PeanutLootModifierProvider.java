package com.mrbysco.peanutcraft.datagen.server;

import com.mrbysco.peanutcraft.PeanutCraft;
import com.mrbysco.peanutcraft.init.GrassDrops;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.predicates.InvertedLootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.predicates.MatchTool;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.GlobalLootModifierProvider;

import java.util.List;

public class PeanutLootModifierProvider extends GlobalLootModifierProvider {
	public PeanutLootModifierProvider(PackOutput packOutput) {
		super(packOutput, PeanutCraft.MOD_ID);
	}

	@Override
	protected void start() {
		var blockList = List.of(
				Blocks.SHORT_GRASS,
				Blocks.TALL_GRASS,
				Blocks.FERN,
				Blocks.LARGE_FERN
		);
		for(var block : blockList) {
			String path = BuiltInRegistries.BLOCK.getKey(block).getPath();
			addLootModifier("peanut_seeds_drops_" + path, block);
		}
	}

	private void addLootModifier(String name, Block block) {
		add(name, new GrassDrops(new LootItemCondition[] {
				LootItemBlockStatePropertyCondition.hasBlockStateProperties(block).build(),
				LootItemRandomChanceCondition.randomChance(0.1f).build()
		}));
	}
}
