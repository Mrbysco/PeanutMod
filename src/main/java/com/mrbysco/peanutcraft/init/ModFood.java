package com.mrbysco.peanutcraft.init;

import net.minecraft.item.Food;
import net.minecraft.item.Food.Builder;

public class ModFood {
	public static final Food PEANUT = (new Builder()).nutrition(2).saturationMod(0.1F).build();
	public static final Food PEANUT_PIE = (new Food.Builder()).nutrition(6).saturationMod(0.2F).build();
	public static final Food PEANUT_BUTTER = (new Food.Builder()).nutrition(3).saturationMod(0.2F).build();
	public static final Food PEANUT_BREAD = (new Food.Builder()).nutrition(5).saturationMod(0.5F).build();
	public static final Food PEANUT_BUTTER_BREAD = (new Food.Builder()).nutrition(6).saturationMod(0.7F).build();
}
