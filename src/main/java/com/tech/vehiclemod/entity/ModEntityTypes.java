package com.tech.vehiclemod.entity;

import com.tech.vehiclemod.VehicleMod;
import com.tech.vehiclemod.entity.custom.BuffZombieEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEntityTypes {
    public static DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITIES, VehicleMod.MOD_ID);

    public static final RegistryObject<EntityType<BuffZombieEntity>> BUFFZOMBIE =
            ENTITY_TYPES.register("buffzombie",
                    () -> EntityType.Builder.create(BuffZombieEntity::new,
                                    EntityClassification.MONSTER)
                            .size(1f, 3f)
                            .build(new ResourceLocation(VehicleMod.MOD_ID, "buffzombie").toString()));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
