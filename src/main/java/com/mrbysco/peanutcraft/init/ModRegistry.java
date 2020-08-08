package com.mrbysco.peanutcraft.init;

import com.mrbysco.peanutcraft.PeanutCraft;
import com.mrbysco.peanutcraft.blocks.PeanutCropBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.BlockNamedItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModRegistry {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, PeanutCraft.MOD_ID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, PeanutCraft.MOD_ID);

    public static final RegistryObject<Block> PEANUT_CROP = BLOCKS.register("peanut_crop", () -> new PeanutCropBlock(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().hardnessAndResistance(0.0F).sound(SoundType.CROP)));
    public static final RegistryObject<Item> PEANUT_CROP_ITEM = ITEMS.register("peanut_crop", () -> new BlockItem(PEANUT_CROP.get(), new Item.Properties().group(ModTabs.PEANUT_TAB)));

    public static final RegistryObject<Item> PEANUT_SEEDS = ITEMS.register("peanut_seeds", () -> new BlockNamedItem(PEANUT_CROP.get(), itemBuilder()));
    public static final RegistryObject<Item> PEANUT = ITEMS.register("peanut", () -> new Item(itemBuilder().food(ModFood.PEANUT)));
    public static final RegistryObject<Item> PEANUT_PIE = ITEMS.register("peanut_pie", () -> new Item(itemBuilder().food(ModFood.PEANUT_PIE)));
    public static final RegistryObject<Item> PEANUT_BUTTER = ITEMS.register("peanut_butter", () -> new Item(itemBuilder().food(ModFood.PEANUT_BUTTER)));
    public static final RegistryObject<Item> PEANUT_BREAD = ITEMS.register("peanut_bread", () -> new Item(itemBuilder().food(ModFood.PEANUT_BREAD)));
    public static final RegistryObject<Item> PEANUT_BUTTER_BREAD = ITEMS.register("peanut_butter_bread", () -> new Item(itemBuilder().food(ModFood.PEANUT_BUTTER_BREAD)));

    private static Item.Properties itemBuilder() {
        return new Item.Properties().group(ModTabs.PEANUT_TAB);
    }
}