package com.mrbysco.peanutcraft.datagen;

import com.mrbysco.peanutcraft.datagen.client.PeanutLanguageProvider;
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

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class PeanutDataGen {

	@SubscribeEvent
	public static void gatherData(GatherDataEvent event) {
		DataGenerator generator = event.getGenerator();
		PackOutput packOutput = generator.getPackOutput();
		CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

		generator.addProvider(event.includeServer(), new PeanutLootModifierProvider(packOutput, lookupProvider));
		generator.addProvider(event.includeServer(), new PeanutLootProvider(packOutput, lookupProvider));
		generator.addProvider(event.includeServer(), new PeanutRecipeProvider(packOutput, lookupProvider));

		generator.addProvider(event.includeClient(), new PeanutLanguageProvider(packOutput));
	}
}
