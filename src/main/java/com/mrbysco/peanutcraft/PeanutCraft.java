package com.mrbysco.peanutcraft;

import com.mrbysco.peanutcraft.client.ClientHandler;
import com.mrbysco.peanutcraft.init.ModRegistry;
import net.minecraft.block.Blocks;
import net.minecraft.block.TallGrassBlock;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShearsItem;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.world.BlockEvent.BreakEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;

@Mod(PeanutCraft.MOD_ID)
public class PeanutCraft {
    public static final String MOD_ID = "peanutcraft";

    public static final Logger LOGGER = LogManager.getLogger();

    public PeanutCraft() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModRegistry.BLOCKS.register(eventBus);
        ModRegistry.ITEMS.register(eventBus);

        MinecraftForge.EVENT_BUS.register(this);

        DistExecutor.runWhenOn(Dist.CLIENT, () -> () -> {
            FMLJavaModLoadingContext.get().getModEventBus().addListener(ClientHandler::doClientStuff);
        });
    }

    @SubscribeEvent
    public void onGrassBroken(BreakEvent event) {
        if (!event.getWorld().isRemote()) {
            if (!(event.getPlayer().getHeldItemMainhand().getItem() instanceof ShearsItem) || (!event.getPlayer().isCreative())) {
                if (event.getState().getBlock() instanceof TallGrassBlock) {
                    Random rand = new Random();
                    if(rand.nextInt(100) < 5) {
                        event.getWorld().setBlockState(event.getPos(), Blocks.AIR.getDefaultState(), 2);
                        event.getWorld().addEntity(new ItemEntity((World) event.getWorld(), event.getPos().getX(),
                                event.getPos().getY(), event.getPos().getZ(), new ItemStack(ModRegistry.PEANUT_SEEDS.get(), 1)));
                    }
                }
            }
        }
    }
}
