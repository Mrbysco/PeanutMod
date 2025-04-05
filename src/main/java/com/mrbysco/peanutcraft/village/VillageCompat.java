package com.mrbysco.peanutcraft.village;

import com.mrbysco.peanutcraft.init.ModRegistry;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.structure.templatesystem.AlwaysTrueTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.ProcessorRule;
import net.minecraft.world.level.levelgen.structure.templatesystem.RandomBlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorList;
import net.neoforged.neoforge.event.server.ServerAboutToStartEvent;

import java.util.ArrayList;
import java.util.List;

public class VillageCompat {

	public static void modifyVillageStructures(final ServerAboutToStartEvent event) {
		Registry<StructureProcessorList> processorListRegistry = event.getServer().registryAccess().lookupOrThrow(Registries.PROCESSOR_LIST);

		StructureProcessor cropProcessor = new RuleProcessor(List.of(
				new ProcessorRule(new RandomBlockMatchTest(Blocks.WHEAT, 0.1F), AlwaysTrueTest.INSTANCE, ModRegistry.PEANUT_CROP.get().defaultBlockState())
		));

		addNewRuleToProcessorList(ResourceLocation.tryParse("minecraft:farm_plains"), cropProcessor, processorListRegistry);
		addNewRuleToProcessorList(ResourceLocation.tryParse("minecraft:farm_savanna"), cropProcessor, processorListRegistry);
		addNewRuleToProcessorList(ResourceLocation.tryParse("minecraft:farm_snowy"), cropProcessor, processorListRegistry);
		addNewRuleToProcessorList(ResourceLocation.tryParse("minecraft:farm_taiga"), cropProcessor, processorListRegistry);
		addNewRuleToProcessorList(ResourceLocation.tryParse("minecraft:farm_desert"), cropProcessor, processorListRegistry);

		// Can target other mod's processor lists
		addNewRuleToProcessorList(ResourceLocation.tryParse("repurposed_structures:villages/badlands/crop_replacement"), cropProcessor, processorListRegistry);
		addNewRuleToProcessorList(ResourceLocation.tryParse("repurposed_structures:villages/birch/crop_randomizer"), cropProcessor, processorListRegistry);
		addNewRuleToProcessorList(ResourceLocation.tryParse("repurposed_structures:villages/dark_forest/crop_randomizer"), cropProcessor, processorListRegistry);
		addNewRuleToProcessorList(ResourceLocation.tryParse("repurposed_structures:villages/giant_taiga/crop_randomizer"), cropProcessor, processorListRegistry);
		addNewRuleToProcessorList(ResourceLocation.tryParse("repurposed_structures:villages/jungle/crop_randomizer"), cropProcessor, processorListRegistry);
		addNewRuleToProcessorList(ResourceLocation.tryParse("repurposed_structures:villages/mountains/crop_randomizer"), cropProcessor, processorListRegistry);
		addNewRuleToProcessorList(ResourceLocation.tryParse("repurposed_structures:villages/oak/crop_randomizer"), cropProcessor, processorListRegistry);
		addNewRuleToProcessorList(ResourceLocation.tryParse("repurposed_structures:villages/swamp/crop_randomizer"), cropProcessor, processorListRegistry);
	}

	private static void addNewRuleToProcessorList(ResourceLocation targetProcessorList, StructureProcessor processorToAdd, Registry<StructureProcessorList> processorListRegistry) {
		processorListRegistry.getOptional(targetProcessorList)
				.ifPresent(processorList -> {
					List<StructureProcessor> newSafeList = new ArrayList<>(processorList.list());
					newSafeList.add(processorToAdd);
					processorList.list = newSafeList; //Have to use an AT to be able to modify the list (or Accessor Mixin)
				});
	}
}
