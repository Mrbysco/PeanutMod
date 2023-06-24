package com.mrbysco.peanutcraft.datagen;

import com.mrbysco.peanutcraft.datagen.client.PeanutLanguageProvider;
import com.mrbysco.peanutcraft.datagen.server.PeanutLootModifierProvider;
import com.mrbysco.peanutcraft.datagen.server.PeanutLootProvider;
import com.mrbysco.peanutcraft.datagen.server.PeanutRecipeProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class PeanutDataGen {

	@SubscribeEvent
	public static void gatherData(GatherDataEvent event) {
		DataGenerator generator = event.getGenerator();
		PackOutput packOutput = generator.getPackOutput();

		generator.addProvider(event.includeServer(), new PeanutLootModifierProvider(packOutput));
		generator.addProvider(event.includeServer(), new PeanutLootProvider(packOutput));
		generator.addProvider(event.includeServer(), new PeanutRecipeProvider(packOutput));

		generator.addProvider(event.includeClient(), new PeanutLanguageProvider(packOutput));
	}
}
