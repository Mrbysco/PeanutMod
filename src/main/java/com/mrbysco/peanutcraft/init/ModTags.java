package com.mrbysco.peanutcraft.init;

import net.minecraft.item.Item;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.Tag;
import net.minecraft.util.ResourceLocation;

public class ModTags {
    public static final Tag<Item> CROPS_PEANUT = itemTag("crop_peanut");

    private static Tag<Item> itemTag(String name)
    {
        return new ItemTags.Wrapper(new ResourceLocation("forge", name));
    }
}
