package com.mrbysco.peanutcraft.init;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModTabs {
    public static final CreativeModeTab PEANUT_TAB = (new CreativeModeTab("peanutTab") {
        public ItemStack makeIcon() {
            return new ItemStack(ModRegistry.PEANUT.get());
        }
    }).setRecipeFolderName("peanut_tab");
}
