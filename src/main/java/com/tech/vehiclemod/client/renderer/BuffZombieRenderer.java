package com.tech.vehiclemod.client.renderer;

import com.tech.vehiclemod.VehicleMod;
import com.tech.vehiclemod.client.model.BuffZombieModel;
import com.tech.vehiclemod.entity.custom.BuffZombieEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class BuffZombieRenderer extends MobRenderer<BuffZombieEntity, BuffZombieModel<BuffZombieEntity>>
{
    protected static final ResourceLocation TEXTURE =
            new ResourceLocation(VehicleMod.MOD_ID, "textures/entity/buffzombie.png");

    public BuffZombieRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new BuffZombieModel<>(), 0.7F);
    }

    @Override
    public ResourceLocation getEntityTexture(BuffZombieEntity entity) {
        return TEXTURE;
    }
}
