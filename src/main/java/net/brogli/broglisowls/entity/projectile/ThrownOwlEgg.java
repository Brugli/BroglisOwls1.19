package net.brogli.broglisowls.entity.projectile;

import net.brogli.broglisowls.entity.BroglisOwlsEntityTypes;
import net.brogli.broglisowls.entity.custom.Owl;
import net.brogli.broglisowls.item.BroglisOwlsItems;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;

public class ThrownOwlEgg extends ThrowableItemProjectile {

    public ThrownOwlEgg(EntityType<ThrownOwlEgg> entityType, Level level) {
        super(entityType, level);
    }

    public ThrownOwlEgg(Level level, LivingEntity livingEntity) {
        super(BroglisOwlsEntityTypes.THROWN_OWL_EGG.get(), livingEntity, level);
    }

    @Override
    public void handleEntityEvent(byte eventIdentifier) {
        if (eventIdentifier == 3)
            for (int i = 0; i < 8; ++i)
                this.level.addParticle(new ItemParticleOption(ParticleTypes.ITEM, this.getItem()), this.getX(), this.getY(), this.getZ(), randomXYZPos(), randomXYZPos(), randomXYZPos());
    }

    private double randomXYZPos() {
        return (this.random.nextDouble() - 0.5D) * 0.08D;
    }

    @Override
    protected void onHitEntity(EntityHitResult hitResult) {
        super.onHitEntity(hitResult);
        hitResult.getEntity().hurt(DamageSource.thrown(this, this.getOwner()), 0.0F);
    }

    @Override
    protected void onHit(HitResult hitResult) {
        super.onHit(hitResult);
        if (!this.level.isClientSide && this.random.nextInt(8) == 0) {
            int owlsToSpawn = this.random.nextInt(32) == 0 ? 4 : 1;

            for (int j = 0; j < owlsToSpawn; ++j) {
                Owl owl = BroglisOwlsEntityTypes.OWL_ENTITY_TYPE.get().create(this.level);
                owl.setBaby(true);
                owl.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), 0.0F);
                this.level.addFreshEntity(owl);
            }
        }

        this.level.broadcastEntityEvent(this, (byte) 3);
        this.discard();

    }

    @Override
    protected Item getDefaultItem() {
        return BroglisOwlsItems.ITEM_OWL_EGG.get();
    }
}
