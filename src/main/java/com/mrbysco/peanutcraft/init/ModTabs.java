package com.mrbysco.peanutcraft.init;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModTabs {
	public static final ItemGroup PEANUT_TAB = (new ItemGroup("peanutTab") {
		public ItemStack makeIcon() {
			return new ItemStack(ModRegistry.PEANUT.get());
		}
	}).setRecipeFolderName("peanut_tab");
}
