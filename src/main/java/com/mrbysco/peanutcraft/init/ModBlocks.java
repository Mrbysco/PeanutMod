package com.mrbysco.peanutcraft.init;

import com.mrbysco.peanutcraft.PeanutCraft;
import com.mrbysco.peanutcraft.blocks.PeanutCropBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.ArrayList;

@Mod.EventBusSubscriber(modid = PeanutCraft.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModBlocks {

    public static Block peanut_crop;

    public static ArrayList<Block> BLOCKS = new ArrayList<>();

    @SubscribeEvent
    public static void registerBlocks(final RegistryEvent.Register<Block> event) {
        IForgeRegistry<Block> registry = event.getRegistry();

        peanut_crop = registerBlock(new PeanutCropBlock(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().hardnessAndResistance(0.0F).sound(SoundType.CROP)), "peanut_crop", new Item.Properties());

        registry.registerAll(BLOCKS.toArray(new Block[0]));
    }

    public static <T extends Block> Block registerBlock(T block, String registry, Item.Properties itemProps) {
        block.setRegistryName(new ResourceLocation(PeanutCraft.MOD_ID, registry));
        return registerBlock(block, new BlockItem(block, itemProps));
    }

    public static <T extends Block> T registerBlock(T block, BlockItem item) {
        item.setRegistryName(((BlockItem) item).getBlock().getRegistryName());
        ModItems.ITEMS.add(item);
        BLOCKS.add(block);
        return block;
    }

    private static Item.Properties itemBuilder() {
        return new Item.Properties().group(ModTabs.PEANUT_TAB);
    }
}
