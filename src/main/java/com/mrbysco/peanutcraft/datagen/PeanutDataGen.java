package com.mrbysco.peanutcraft.datagen;

import com.mrbysco.peanutcraft.datagen.client.PeanutLanguageProvider;
import com.mrbysco.peanutcraft.datagen.client.PeanutModelProvider;
import com.mrbysco.peanutcraft.datagen.server.PeanutBlockTagsProvider;
import com.mrbysco.peanutcraft.datagen.server.PeanutItemTagsProvider;
import com.mrbysco.peanutcraft.datagen.server.PeanutLootModifierProvider;
import com.mrbysco.peanutcraft.datagen.server.PeanutLootProvider;
import com.mrbysco.peanutcraft.datagen.server.PeanutRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.concurrent.CompletableFuture;

@EventBusSubscriber
public class PeanutDataGen {

	@SubscribeEvent
	public static void gatherData(GatherDataEvent.Client event) {
		DataGenerator generator = event.getGenerator();
		PackOutput packOutput = generator.getPackOutput();
		CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

		generator.addProvider(true, new PeanutLootModifierProvider(packOutput, lookupProvider));
		generator.addProvider(true, new PeanutLootProvider(packOutput, lookupProvider));
		generator.addProvider(true, new PeanutRecipeProvider.Runner(packOutput, lookupProvider));

		PeanutBlockTagsProvider blockTagProvider;
		generator.addProvider(true, blockTagProvider = new PeanutBlockTagsProvider(packOutput, lookupProvider));
		generator.addProvider(true, new PeanutItemTagsProvider(packOutput, lookupProvider));

		generator.addProvider(true, new PeanutLanguageProvider(packOutput));
		generator.addProvider(true, new PeanutModelProvider(packOutput));
	}
}
