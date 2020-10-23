package com.mrbysco.peanutcraft.init;

import com.google.gson.JsonObject;
import com.mrbysco.peanutcraft.PeanutCraft;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootContext;
import net.minecraft.loot.conditions.ILootCondition;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

import javax.annotation.Nonnull;
import java.util.List;

@EventBusSubscriber(modid = PeanutCraft.MOD_ID, bus = Bus.MOD)
public class GrassDrops {
    @SubscribeEvent
    public static void registerModifiers(RegistryEvent.Register<GlobalLootModifierSerializer<?>> event) {
        event.getRegistry().register(
                new GrassDropSerializer().setRegistryName(PeanutCraft.MOD_ID, "peanut_seeds_drops")
        );
    }

    public static class GrassDropSerializer extends GlobalLootModifierSerializer<GrassDropModifier> {
        @Override
        public GrassDropModifier read(ResourceLocation location, JsonObject object, ILootCondition[] ailootcondition) {
            return new GrassDropModifier(ailootcondition);
        }

        @Override
        public JsonObject write(GrassDropModifier instance) {
            return new JsonObject();
        }
    }

    private static class GrassDropModifier extends LootModifier {
        protected GrassDropModifier(ILootCondition[] conditionsIn) {
            super(conditionsIn);
        }

        @Nonnull
        @Override
        protected List<ItemStack> doApply(List<ItemStack> generatedLoot, LootContext context) {
            generatedLoot.add(new ItemStack(ModRegistry.PEANUT_SEEDS.get()));
            return generatedLoot;
        }
    }
}
