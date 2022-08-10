package com.tech.vehiclemod.item;

import com.tech.vehiclemod.VehicleMod;
import com.tech.vehiclemod.entity.ModEntityTypes;
import com.tech.vehiclemod.item.custom.ModSpawnEggItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {

    public static  final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, VehicleMod.MOD_ID);

    public static final RegistryObject<Item> RUBY = ITEMS.register("ruby",
            () -> new Item(new Item.Properties().group(ModItemGroup.VEHICLE_GROUP)));

    public static final RegistryObject<ModSpawnEggItem> BUFFZOMBIE_SPAWN_EGG = ITEMS.register("buffzombie_spawn_egg",
            () -> new ModSpawnEggItem(ModEntityTypes.BUFFZOMBIE, 0x879995, 0x576ABC,
                    new Item.Properties().group(ModItemGroup.VEHICLE_EGG)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
