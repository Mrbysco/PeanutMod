package com.mrbysco.peanutcraft.datagen.server;

import com.mrbysco.peanutcraft.PeanutCraft;
import com.mrbysco.peanutcraft.init.ModRegistry;
import com.mrbysco.peanutcraft.init.ModTags;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.common.Tags.Items;
import net.neoforged.neoforge.common.data.ItemTagsProvider;

import java.util.concurrent.CompletableFuture;

public class PeanutItemTagsProvider extends ItemTagsProvider {
	public PeanutItemTagsProvider(PackOutput packOutput, CompletableFuture<Provider> lookupProvider) {
		super(packOutput, lookupProvider, PeanutCraft.MOD_ID);
	}

	@Override
	protected void addTags(Provider provider) {
		this.tag(ModTags.CROPS_PEANUT).add(ModRegistry.PEANUT.getKey());
		this.tag(Items.CROPS).addTag(ModTags.CROPS_PEANUT);
		this.tag(ItemTags.VILLAGER_PLANTABLE_SEEDS).add(ModRegistry.PEANUT_SEEDS.getKey());
	}

	private static TagKey<Item> commonTag(String name) {
		return ItemTags.create(Identifier.fromNamespaceAndPath("c", name));
	}
}
