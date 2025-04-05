package com.mrbysco.peanutcraft;

import com.mrbysco.peanutcraft.init.ModRegistry;
import com.mrbysco.peanutcraft.village.VillageCompat;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(PeanutCraft.MOD_ID)
public class PeanutCraft {
	public static final String MOD_ID = "peanutcraft";
	public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

	public PeanutCraft(IEventBus eventBus) {
		ModRegistry.BLOCKS.register(eventBus);
		ModRegistry.ITEMS.register(eventBus);
		ModRegistry.CREATIVE_MODE_TABS.register(eventBus);
		ModRegistry.GLM.register(eventBus);

		NeoForge.EVENT_BUS.addListener(VillageCompat::modifyVillageStructures);
	}
}
