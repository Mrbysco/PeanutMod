package com.mrbysco.peanutcraft.init;

import com.google.common.base.Preconditions;
import com.mrbysco.peanutcraft.PeanutCraft;
import net.minecraft.item.BlockNamedItem;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.ArrayList;

@Mod.EventBusSubscriber(modid = PeanutCraft.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModItems {
    public static Item peanut_seeds;
    public static Item peanut;

    public static Item peanut_pie, peanut_butter, peanut_bread, peanut_butter_bread;

    public static ArrayList<Item> ITEMS = new ArrayList<>();

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        IForgeRegistry<Item> registry = event.getRegistry();

        peanut_seeds = registerItem(new BlockNamedItem(ModBlocks.peanut_crop, itemBuilder()), "peanut_seeds");
        peanut = registerItem(new Item(itemBuilder().food(ModFood.PEANUT)), "peanut");

        peanut_pie = registerItem(new Item(itemBuilder().food(ModFood.PEANUT_PIE)), "peanut_pie");
        peanut_butter = registerItem(new Item(itemBuilder().food(ModFood.PEANUT_BUTTER)), "peanut_butter");
        peanut_bread = registerItem(new Item(itemBuilder().food(ModFood.PEANUT_BREAD)), "peanut_bread");
        peanut_butter_bread = registerItem(new Item(itemBuilder().food(ModFood.PEANUT_BUTTER_BREAD)), "peanut_butter_bread");

        registry.registerAll(ITEMS.toArray(new Item[0]));
    }

    public static <T extends Item> T registerItem(T item, String name) {
        item.setRegistryName(new ResourceLocation(PeanutCraft.MOD_ID, name));
        Preconditions.checkNotNull(item, "registryName");
        ITEMS.add(item);
        return item;
    }

    private static Item.Properties itemBuilder() {
        return new Item.Properties().group(ModTabs.PEANUT_TAB);
    }
}
