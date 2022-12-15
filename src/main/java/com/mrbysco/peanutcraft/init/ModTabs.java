package com.mrbysco.peanutcraft.init;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModTabs {
	public static final ItemGroup PEANUT_TAB = (new ItemGroup("peanutTab") {
		public ItemStack createIcon() {
			return new ItemStack(ModRegistry.PEANUT.get());
		}
	}).setTabPath("peanut_tab");
}
