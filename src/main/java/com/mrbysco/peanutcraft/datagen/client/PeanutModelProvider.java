package com.mrbysco.peanutcraft.datagen.client;

import com.mrbysco.peanutcraft.PeanutCraft;
import com.mrbysco.peanutcraft.init.ModRegistry;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.blockstates.PropertyDispatch;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.Property;
import net.neoforged.neoforge.client.model.generators.template.ExtendedModelTemplate;
import org.jetbrains.annotations.NotNull;

public class PeanutModelProvider extends ModelProvider {
	public PeanutModelProvider(PackOutput output) {
		super(output, PeanutCraft.MOD_ID);
	}

	@Override
	protected void registerModels(@NotNull BlockModelGenerators blockModels, ItemModelGenerators itemModels) {
		createCropBlock(blockModels, ModRegistry.PEANUT_CROP.get(), BlockStateProperties.AGE_7, 0, 0, 1, 1, 2, 2, 2, 3);
		itemModels.generateFlatItem(ModRegistry.PEANUT.get(), ModelTemplates.FLAT_ITEM);
		itemModels.generateFlatItem(ModRegistry.PEANUT_PIE.get(), ModelTemplates.FLAT_ITEM);
		itemModels.generateFlatItem(ModRegistry.PEANUT_BUTTER.get(), ModelTemplates.FLAT_ITEM);
		itemModels.generateFlatItem(ModRegistry.PEANUT_BREAD.get(), ModelTemplates.FLAT_ITEM);
		itemModels.generateFlatItem(ModRegistry.PEANUT_BUTTER_BREAD.get(), ModelTemplates.FLAT_ITEM);
	}

	public void createCropBlock(BlockModelGenerators blockModels, Block cropBlock, Property<Integer> ageProperty, int... ageToVisualStageMapping) {
		blockModels.registerSimpleFlatItemModel(cropBlock.asItem());
		if (ageProperty.getPossibleValues().size() != ageToVisualStageMapping.length) {
			throw new IllegalArgumentException();
		} else {
			Int2ObjectMap<Identifier> int2objectmap = new Int2ObjectOpenHashMap<>();
			ExtendedModelTemplate cropTemplate = ModelTemplates.CROP.extend().renderType("cutout").build();
			blockModels.blockStateOutput
					.accept(
							MultiVariantGenerator.dispatch(cropBlock)
									.with(
											PropertyDispatch.initial(ageProperty)
													.generate(
															age -> {
																int i = ageToVisualStageMapping[age];
																return BlockModelGenerators.plainVariant(
																		int2objectmap.computeIfAbsent(
																				i,
																				stage -> blockModels.createSuffixedVariant(
																						cropBlock, "_stage" + stage, cropTemplate, TextureMapping::crop
																				)
																		)
																);
															}
													)
									)
					);
		}
	}
}
