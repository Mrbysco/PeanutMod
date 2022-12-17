package com.mrbysco.peanutcraft.datagen;

import com.mrbysco.peanutcraft.PeanutCraft;
import com.mrbysco.peanutcraft.init.GrassDrops;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.predicates.AlternativeLootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.InvertedLootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.predicates.MatchTool;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class PeanutDataGen {

	@SubscribeEvent
	public static void gatherData(GatherDataEvent event) {
		DataGenerator generator = event.getGenerator();
		PackOutput packOutput = generator.getPackOutput();

		generator.addProvider(event.includeServer(), new PeanutLootModifiers(packOutput));
	}

	public static class PeanutLootModifiers extends GlobalLootModifierProvider {
		public PeanutLootModifiers(PackOutput packOutput) {
			super(packOutput, PeanutCraft.MOD_ID);
		}

		@Override
		protected void start() {
			this.add("peanuts_from_grass", new GrassDrops(new LootItemCondition[]{
					LootItemRandomChanceCondition.randomChance(0.1F).build(),
					InvertedLootItemCondition.invert(MatchTool.toolMatches(ItemPredicate.Builder.item().of(Tags.Items.SHEARS))).build(),
					AlternativeLootItemCondition.alternative(
							LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.GRASS),
							LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.TALL_GRASS),
							LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.FERN),
							LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.LARGE_FERN)
					).build()
			}));
		}
	}
}
