package com.mrbysco.peanutcraft.datagen.server;

import com.mrbysco.peanutcraft.PeanutCraft;
import com.mrbysco.peanutcraft.init.ModRegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;

import java.util.concurrent.CompletableFuture;

public class PeanutBlockTagsProvider extends BlockTagsProvider {
	public PeanutBlockTagsProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
		super(packOutput, lookupProvider, PeanutCraft.MOD_ID);
	}

	@Override
	protected void addTags(Provider provider) {
		this.tag(BlockTags.CROPS).add(ModRegistry.PEANUT_CROP.getKey());
	}
}
