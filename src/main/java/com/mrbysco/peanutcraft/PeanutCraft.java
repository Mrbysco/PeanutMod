package com.mrbysco.peanutcraft;

import com.mrbysco.peanutcraft.client.ClientHandler;
import com.mrbysco.peanutcraft.init.ModRegistry;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(PeanutCraft.MOD_ID)
public class PeanutCraft {
    public static final String MOD_ID = "peanutcraft";

    public static final Logger LOGGER = LogManager.getLogger();

    public PeanutCraft() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModRegistry.BLOCKS.register(eventBus);
        ModRegistry.ITEMS.register(eventBus);

        MinecraftForge.EVENT_BUS.register(this);

        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> {
            FMLJavaModLoadingContext.get().getModEventBus().addListener(ClientHandler::doClientStuff);
        });
    }
}
