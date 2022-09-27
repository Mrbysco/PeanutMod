package com.mrbysco.peanutcraft.init;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class ModTags {
	public static void initialize() {
	}

	public static final TagKey<Item> CROPS_PEANUT = ItemTags.create(new ResourceLocation("forge", "crops/peanut"));
}
