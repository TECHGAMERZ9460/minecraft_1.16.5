package com.tech.vehiclemod.entity.custom;

import com.google.common.collect.ImmutableList;
import net.minecraft.block.BlockState;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.merchant.villager.AbstractVillagerEntity;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.passive.GolemEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.passive.TurtleEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.spawner.WorldEntitySpawner;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

public class BuffZombieEntity extends MonsterEntity{
        public BuffZombieEntity(EntityType<? extends MonsterEntity> type, World worldIn) {
            super(type, worldIn);
        }

        public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
            return MobEntity.func_233666_p_()
                    .createMutableAttribute(Attributes.MAX_HEALTH, 150.0D)
                    .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.43D)
                    .createMutableAttribute(Attributes.ATTACK_DAMAGE, 13.0D)
                    .createMutableAttribute(Attributes.FOLLOW_RANGE, 50.0D);
        }

        @Override
        protected void registerGoals() {
            super.registerGoals();
            this.goalSelector.addGoal( 1, new NearestAttackableTargetGoal<>( this, PlayerEntity.class, true ) );
            this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.0D, true));
            this.goalSelector.addGoal(2, new MoveTowardsTargetGoal(this, 0.9D, 32.0F));
            this.goalSelector.addGoal(2, new ReturnToVillageGoal(this, 0.6D, false));
            this.goalSelector.addGoal(4, new PatrolVillageGoal(this, 0.6D));
            this.goalSelector.addGoal(7, new LookAtGoal(this, PlayerEntity.class, 6.0F));
            this.goalSelector.addGoal(8, new LookRandomlyGoal(this));
            this.targetSelector.addGoal(2, new HurtByTargetGoal(this));;
        }

        @Override
        protected int getExperiencePoints(PlayerEntity player)
        {
            return 3 + this.world.rand.nextInt(5);
        }

        @Override
        protected SoundEvent getAmbientSound()
        {
            return SoundEvents.ENTITY_WITHER_AMBIENT;
        }


        @Override
        protected SoundEvent getDeathSound()
        {
        return SoundEvents.ENTITY_IRON_GOLEM_DEATH ;
        }

        @Override
        protected SoundEvent getHurtSound(DamageSource damageSourceIn)
        {
            return SoundEvents.ENTITY_WITHER_DEATH;
        }

        @Override
        protected void playStepSound(BlockPos pos, BlockState blockIn)
        {
            this.playSound(SoundEvents.ENTITY_IRON_GOLEM_STEP, 0.20F, 0.5F);
        }

        @Override
        public boolean attackEntityAsMob(Entity entityIn) {
            if (!super.attackEntityAsMob(entityIn)) {
                return false;
            } else {
                if (entityIn instanceof LivingEntity) {
                    ((LivingEntity)entityIn).addPotionEffect(new EffectInstance(Effects.WITHER, 100));
                }
                return true;
            }
        }

        public int getAttackTimer() {
            return 0;
        }
    }

