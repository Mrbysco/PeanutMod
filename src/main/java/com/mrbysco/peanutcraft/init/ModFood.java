package com.mrbysco.peanutcraft.init;

import net.minecraft.item.Food;
import net.minecraft.item.Food.Builder;

public class ModFood {
    public static final Food PEANUT = (new Builder()).hunger(2).saturation(0.1F).build();
    public static final Food PEANUT_PIE = (new Food.Builder()).hunger(6).saturation(0.2F).build();
    public static final Food PEANUT_BUTTER = (new Food.Builder()).hunger(3).saturation(0.2F).build();
    public static final Food PEANUT_BREAD = (new Food.Builder()).hunger(5).saturation(0.5F).build();
    public static final Food PEANUT_BUTTER_BREAD = (new Food.Builder()).hunger(6).saturation(0.7F).build();
}
