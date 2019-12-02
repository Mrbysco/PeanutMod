package com.mrbysco.peanutcraft;

import com.mrbysco.peanutcraft.init.ModItems;
import net.minecraft.block.Blocks;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShearsItem;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.world.BlockEvent.BreakEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;

@Mod(PeanutCraft.MOD_ID)
public class PeanutCraft {
    public static final String MOD_ID = "peanutcraft";

    public static final Logger LOGGER = LogManager.getLogger();

    public PeanutCraft() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {

    }

    @SubscribeEvent
    public void onGrassBroken(BreakEvent event) {
        if (!event.getWorld().isRemote()) {
            if (!(event.getPlayer().getHeldItemMainhand().getItem() instanceof ShearsItem) || (!event.getPlayer().isCreative())) {
                if (event.getState().getBlock() == Blocks.GRASS || event.getState().getBlock() == Blocks.TALL_GRASS || event.getState().getBlock() == Blocks.FERN) {
                    Random rand = new Random();
                    if(rand.nextInt(100) < 5) {
                        event.getWorld().setBlockState(event.getPos(), Blocks.AIR.getDefaultState(), 2);
                        event.getWorld().addEntity(new ItemEntity((World) event.getWorld(), event.getPos().getX(),
                                event.getPos().getY(), event.getPos().getZ(), new ItemStack(ModItems.peanut_seeds, 1)));
                    }
                }
            }
        }
    }
}
