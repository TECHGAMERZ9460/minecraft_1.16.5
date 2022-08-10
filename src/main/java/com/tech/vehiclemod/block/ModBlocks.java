package com.tech.vehiclemod.block;

import com.tech.vehiclemod.VehicleMod;
import com.tech.vehiclemod.item.ModItemGroup;
import com.tech.vehiclemod.item.ModItems;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, VehicleMod.MOD_ID);

    public static final RegistryObject<Block> RUBY_BLOCK = registerBlock("ruby_block",
            () -> new Block(AbstractBlock.Properties.create(Material.IRON).harvestLevel(2)
                    .setRequiresTool().harvestTool(ToolType.PICKAXE).hardnessAndResistance(8f))
            ,ModItemGroup.VEHICLE_BLOCK);

    public static final RegistryObject<Block> RUBY_ORE = registerBlock("ruby_ore",
            () -> new Block(AbstractBlock.Properties.create(Material.IRON).harvestLevel(2)
                    .setRequiresTool().harvestTool(ToolType.PICKAXE).hardnessAndResistance(6f))
            ,ModItemGroup.VEHICLE_BLOCK);

    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block, ItemGroup group) {
        RegistryObject<T> toReturn = BLOCKS.register(name,block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().group(ModItemGroup.VEHICLE_BLOCK)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
