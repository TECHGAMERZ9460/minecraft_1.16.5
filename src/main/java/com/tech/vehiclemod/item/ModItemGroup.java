package com.tech.vehiclemod.item;

import com.tech.vehiclemod.block.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModItemGroup {

    public static final ItemGroup VEHICLE_GROUP = new ItemGroup("vehiclemodtab") {

        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModItems.RUBY.get());
        }
    };

    public static final ItemGroup VEHICLE_BLOCK = new ItemGroup("vehicleblock") {

        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModBlocks.RUBY_ORE.get());
        }
    };

    public static final ItemGroup VEHICLE_EGG = new ItemGroup("vehiclemodegg") {

        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModItems.BUFFZOMBIE_SPAWN_EGG.get());
        }
    };
}
