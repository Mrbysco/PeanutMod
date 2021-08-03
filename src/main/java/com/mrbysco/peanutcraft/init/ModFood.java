package com.mrbysco.peanutcraft.init;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.food.FoodProperties.Builder;

public class ModFood {
    public static final FoodProperties PEANUT = (new Builder()).nutrition(2).saturationMod(0.1F).build();
    public static final FoodProperties PEANUT_PIE = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.2F).build();
    public static final FoodProperties PEANUT_BUTTER = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.2F).build();
    public static final FoodProperties PEANUT_BREAD = (new FoodProperties.Builder()).nutrition(5).saturationMod(0.5F).build();
    public static final FoodProperties PEANUT_BUTTER_BREAD = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.7F).build();
}
