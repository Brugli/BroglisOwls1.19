package net.brogli.broglisowls.entity.client;

import net.brogli.broglisowls.BroglisOwls;
import net.brogli.broglisowls.entity.custom.EntityBabyOwl;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

public class EntityBabyOwlModel extends AnimatedGeoModel<EntityBabyOwl> {

    @Override
    public ResourceLocation getModelResource(EntityBabyOwl object) {
        return new ResourceLocation(BroglisOwls.MOD_ID, "geo/entity_baby_owl.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EntityBabyOwl object) {
        return new ResourceLocation(BroglisOwls.MOD_ID, "textures/baby_owl.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EntityBabyOwl animatable) {
        return new ResourceLocation(BroglisOwls.MOD_ID, "animations/entity_baby_owl.animation.json");
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public void setLivingAnimations(EntityBabyOwl entity, Integer uniqueID, AnimationEvent customPredicate) {
        super.setLivingAnimations(entity, uniqueID, customPredicate);
        IBone head = this.getAnimationProcessor().getBone("Head");

        EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
        if (head != null) {
            if (entity.isFlying()) {
                head.setRotationX(extraData.headPitch * ((float) Math.PI / 270F));
                head.setRotationY(extraData.netHeadYaw * ((float) Math.PI / 300F));
            } else {
                head.setRotationX(extraData.headPitch * ((float) Math.PI / 270F));
                head.setRotationY(extraData.netHeadYaw * ((float) Math.PI / 100F));
            }
        }
    }
}
