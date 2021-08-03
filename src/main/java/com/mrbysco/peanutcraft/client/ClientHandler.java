package com.mrbysco.peanutcraft.client;

import com.mrbysco.peanutcraft.init.ModRegistry;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class ClientHandler {
    public static void doClientStuff(final FMLClientSetupEvent event) {
        RenderTypeLookup.setRenderLayer(ModRegistry.PEANUT_CROP.get(), RenderType.cutout());
    }
}
