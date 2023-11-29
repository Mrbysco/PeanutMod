package com.mrbysco.peanutcraft.datagen.client;

import com.mrbysco.peanutcraft.PeanutCraft;
import com.mrbysco.peanutcraft.init.ModRegistry;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class PeanutLanguageProvider extends LanguageProvider {
	public PeanutLanguageProvider(PackOutput packOutput) {
		super(packOutput, PeanutCraft.MOD_ID, "en_us");
	}

	@Override
	protected void addTranslations() {
		add("itemGroup.peanutTab", "PeanutCraft Tab");

		addBlock(ModRegistry.PEANUT_CROP, "Peanut Crop");

		addItem(ModRegistry.PEANUT_SEEDS, "Peanut Seeds");
		addItem(ModRegistry.PEANUT, "Peanut");
		addItem(ModRegistry.PEANUT_PIE, "Peanut Pie");
		addItem(ModRegistry.PEANUT_BUTTER, "Peanutbutter");
		addItem(ModRegistry.PEANUT_BREAD, "Peanut Bread");
		addItem(ModRegistry.PEANUT_BUTTER_BREAD, "Peanutbutter Bread");
	}
}
