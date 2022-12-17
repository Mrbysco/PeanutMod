package com.mrbysco.peanutcraft.init;

import com.mojang.serialization.Codec;
import com.mrbysco.peanutcraft.PeanutCraft;
import com.mrbysco.peanutcraft.blocks.PeanutCropBlock;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ForgeRegistries.Keys;
import net.minecraftforge.registries.RegistryObject;

public class ModRegistry {
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, PeanutCraft.MOD_ID);
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, PeanutCraft.MOD_ID);
	public static final DeferredRegister<Codec<? extends IGlobalLootModifier>> GLM = DeferredRegister.create(Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, PeanutCraft.MOD_ID);

	public static final RegistryObject<Codec<? extends IGlobalLootModifier>> PEANUT_SEEDS_DROPS = GLM.register("peanut_seeds_drops", GrassDrops.CODEC);
	public static final RegistryObject<Block> PEANUT_CROP = BLOCKS.register("peanut_crop", () -> new PeanutCropBlock(Block.Properties.of(Material.PLANT).noCollission().randomTicks().strength(0.0F).sound(SoundType.CROP)));

	public static final RegistryObject<Item> PEANUT_SEEDS = ITEMS.register("peanut_seeds", () -> new ItemNameBlockItem(PEANUT_CROP.get(), (new Item.Properties())));
	public static final RegistryObject<Item> PEANUT = ITEMS.register("peanut", () -> new Item((new Item.Properties()).food(ModFood.PEANUT)));
	public static final RegistryObject<Item> PEANUT_PIE = ITEMS.register("peanut_pie", () -> new Item((new Item.Properties()).food(ModFood.PEANUT_PIE)));
	public static final RegistryObject<Item> PEANUT_BUTTER = ITEMS.register("peanut_butter", () -> new Item((new Item.Properties()).food(ModFood.PEANUT_BUTTER)));
	public static final RegistryObject<Item> PEANUT_BREAD = ITEMS.register("peanut_bread", () -> new Item((new Item.Properties()).food(ModFood.PEANUT_BREAD)));
	public static final RegistryObject<Item> PEANUT_BUTTER_BREAD = ITEMS.register("peanut_butter_bread", () -> new Item((new Item.Properties()).food(ModFood.PEANUT_BUTTER_BREAD)));

}