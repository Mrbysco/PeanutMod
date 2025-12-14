package com.mrbysco.peanutcraft.init;

import net.minecraft.resources.Identifier;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class ModTags {
	public static final TagKey<Item> CROPS_PEANUT = ItemTags.create(Identifier.fromNamespaceAndPath("c", "crops/peanut"));
}
