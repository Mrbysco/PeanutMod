package com.mrbysco.peanutcraft.init;

import com.mrbysco.peanutcraft.PeanutCraft;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.List;

public class ModTabs {
	private static CreativeModeTab PEANUT_TAB;

	@SubscribeEvent
	public void registerCreativeTabs(final CreativeModeTabEvent.Register event) {
		PEANUT_TAB = event.registerCreativeModeTab(new ResourceLocation(PeanutCraft.MOD_ID, "tab"), builder ->
				builder.icon(() -> new ItemStack(ModRegistry.PEANUT.get()))
						.title(Component.translatable("itemGroup.peanutTab"))
						.displayItems((features, output, hasPermissions) -> {
							List<ItemStack> stacks = ModRegistry.ITEMS.getEntries().stream()
									.filter(reg -> reg.get() instanceof BlockItem).map(reg -> new ItemStack(reg.get())).toList();
							output.acceptAll(stacks);
						}));
	}
}
