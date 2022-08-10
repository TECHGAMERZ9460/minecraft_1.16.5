package com.tech.vehiclemod.client.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.tech.vehiclemod.entity.custom.BuffZombieEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class BuffZombieModel <T extends BuffZombieEntity> extends EntityModel<T> {
    private final ModelRenderer body;

    private final ModelRenderer head;

    private final ModelRenderer right_arm;

    private final ModelRenderer left_arm;

    private final ModelRenderer right_leg;

    private final ModelRenderer left_leg;

    public BuffZombieModel() {
        textureWidth = 128;
        textureHeight = 128;

        body = new ModelRenderer(this);
        body.setRotationPoint(0.0F, -7.0F, 0.0F);
        body.setTextureOffset(0, 0).addBox(-9.0F, -2.0F, -6.0F, 18.0F, 12.0F, 11.0F, 0.0F, false);
        body.setTextureOffset(47, 0).addBox(-4.5F, 10.0F, -3.0F, 9.0F, 5.0F, 6.0F, 0.5F, false);

        head = new ModelRenderer(this);
        head.setRotationPoint(0.0F, -7.0F, -2.0F);
        head.setTextureOffset(40, 23).addBox(-4.0F, -12.0F, -5.5F, 8.0F, 10.0F, 8.0F, 0.0F, false);
        head.setTextureOffset(0, 0).addBox(-1.0F, -5.0F, -7.5F, 2.0F, 4.0F, 2.0F, 0.0F, false);

        right_arm = new ModelRenderer(this);
        right_arm.setRotationPoint(0.0F, -7.0F, 0.0F);
        right_arm.setTextureOffset(20, 23).addBox(-13.0F, -2.5F, -3.0F, 4.0F, 30.0F, 6.0F, 0.0F, false);

        left_arm = new ModelRenderer(this);
        left_arm.setRotationPoint(0.0F, -7.0F, 0.0F);
        left_arm.setTextureOffset(0, 23).addBox(9.0F, -2.5F, -3.0F, 4.0F, 30.0F, 6.0F, 0.0F, false);

        right_leg = new ModelRenderer(this);
        right_leg.setRotationPoint(-4.0F, 11.0F, 0.0F);
        right_leg.setTextureOffset(57, 57).addBox(-3.5F, -3.0F, -3.0F, 6.0F, 16.0F, 5.0F, 0.0F, false);

        left_leg = new ModelRenderer(this);
        left_leg.setRotationPoint(5.0F, 11.0F, 0.0F);
        left_leg.setTextureOffset(40, 41).addBox(-3.5F, -3.0F, -3.0F, 6.0F, 16.0F, 5.0F, 0.0F, false);
    }

    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount,
                                  float ageInTicks, float netHeadYaw, float headPitch) {
        this.head.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
        this.head.rotateAngleX = headPitch * ((float)Math.PI / 180F);
        this.left_leg.rotateAngleX = -1.5F * MathHelper.func_233021_e_(limbSwing, 13.0F) * limbSwingAmount;
        this.right_leg.rotateAngleX = 1.5F * MathHelper.func_233021_e_(limbSwing, 13.0F) * limbSwingAmount;
        this.left_leg.rotateAngleY = 0.0F;
        this.right_leg.rotateAngleY = 0.0F;
    }

    @Override
    public void setLivingAnimations(T entityIn, float limbSwing, float limbSwingAmount, float partialTick) {
        int i = entityIn.getAttackTimer();
        if (i > 0) {
            this.right_arm.rotateAngleX = -2.0F + 1.5F * MathHelper.func_233021_e_((float)i - partialTick, 10.0F);
            this.left_arm.rotateAngleX = -2.0F + 1.5F * MathHelper.func_233021_e_((float)i - partialTick, 10.0F);
        } else {
            this.right_arm.rotateAngleX = (-0.2F + 1.5F * MathHelper.func_233021_e_(limbSwing, 13.0F)) * limbSwingAmount;
            this.left_arm.rotateAngleX = (-0.2F - 1.5F * MathHelper.func_233021_e_(limbSwing, 13.0F)) * limbSwingAmount;
        }
    }

    @Override
    public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        body.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
        head.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
        right_arm.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
        left_arm.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
        right_leg.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
        left_leg.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
