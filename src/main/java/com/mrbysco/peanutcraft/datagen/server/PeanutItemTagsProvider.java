package com.mrbysco.peanutcraft.datagen.server;

import com.mrbysco.peanutcraft.PeanutCraft;
import com.mrbysco.peanutcraft.init.ModRegistry;
import com.mrbysco.peanutcraft.init.ModTags;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.Tags.Items;

import java.util.concurrent.CompletableFuture;

public class PeanutItemTagsProvider extends ItemTagsProvider {
	public PeanutItemTagsProvider(PackOutput packOutput, CompletableFuture<Provider> lookupProvider,
	                         TagsProvider<Block> blockTagProvider) {
		super(packOutput, lookupProvider, blockTagProvider.contentsGetter(), PeanutCraft.MOD_ID);
	}

	@Override
	protected void addTags(Provider provider) {
		this.tag(ModTags.CROPS_PEANUT).add(ModRegistry.PEANUT.get());
		this.tag(Items.CROPS).addTag(ModTags.CROPS_PEANUT);
		this.tag(ItemTags.VILLAGER_PLANTABLE_SEEDS).add(ModRegistry.PEANUT_SEEDS.get());
	}

	private static TagKey<Item> commonTag(String name) {
		return ItemTags.create(ResourceLocation.fromNamespaceAndPath("c", name));
	}
}
