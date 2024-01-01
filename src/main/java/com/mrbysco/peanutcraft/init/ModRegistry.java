package com.mrbysco.peanutcraft.init;

import com.mojang.serialization.Codec;
import com.mrbysco.peanutcraft.PeanutCraft;
import com.mrbysco.peanutcraft.blocks.PeanutCropBlock;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.List;
import java.util.function.Supplier;

public class ModRegistry {
	public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(PeanutCraft.MOD_ID);
	public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(PeanutCraft.MOD_ID);
	public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, PeanutCraft.MOD_ID);
	public static final DeferredRegister<Codec<? extends IGlobalLootModifier>> GLM = DeferredRegister.create(NeoForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, PeanutCraft.MOD_ID);

	public static final Supplier<Codec<? extends IGlobalLootModifier>> PEANUT_SEEDS_DROPS = GLM.register("peanut_seeds_drops", GrassDrops.CODEC);
	public static final DeferredBlock<PeanutCropBlock> PEANUT_CROP = BLOCKS.register("peanut_crop", () -> new PeanutCropBlock(Block.Properties.ofFullCopy(Blocks.WHEAT).noCollission().randomTicks().strength(0.0F).sound(SoundType.CROP)));

	public static final DeferredItem<Item> PEANUT_SEEDS = ITEMS.register("peanut_seeds", () -> new ItemNameBlockItem(PEANUT_CROP.get(), (new Item.Properties())));
	public static final DeferredItem<Item> PEANUT = ITEMS.register("peanut", () -> new Item((new Item.Properties()).food(ModFood.PEANUT)));
	public static final DeferredItem<Item> PEANUT_PIE = ITEMS.register("peanut_pie", () -> new Item((new Item.Properties()).food(ModFood.PEANUT_PIE)));
	public static final DeferredItem<Item> PEANUT_BUTTER = ITEMS.register("peanut_butter", () -> new Item((new Item.Properties()).food(ModFood.PEANUT_BUTTER)));
	public static final DeferredItem<Item> PEANUT_BREAD = ITEMS.register("peanut_bread", () -> new Item((new Item.Properties()).food(ModFood.PEANUT_BREAD)));
	public static final DeferredItem<Item> PEANUT_BUTTER_BREAD = ITEMS.register("peanut_butter_bread", () -> new Item((new Item.Properties()).food(ModFood.PEANUT_BUTTER_BREAD)));

	public static final Supplier<CreativeModeTab> PEANUT_TAB = CREATIVE_MODE_TABS.register("tab", () -> CreativeModeTab.builder()
			.icon(() -> new ItemStack(ModRegistry.PEANUT.get()))
			.withTabsBefore(CreativeModeTabs.SPAWN_EGGS)
			.title(Component.translatable("itemGroup.peanutTab"))
			.displayItems((displayParameters, output) -> {
				List<ItemStack> stacks = ModRegistry.ITEMS.getEntries().stream().map(reg -> new ItemStack(reg.get())).toList();
				output.acceptAll(stacks);
			}).build());
}