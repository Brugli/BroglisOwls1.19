package net.brogli.broglisowls.entity.client;

import net.brogli.broglisowls.BroglisOwls;
import net.brogli.broglisowls.entity.custom.EntityOwl;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

public class EntityOwlModel extends AnimatedGeoModel<EntityOwl> {

    @Override
    public ResourceLocation getModelResource(EntityOwl object) {
        return new ResourceLocation(BroglisOwls.MOD_ID, "geo/entity_owl.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EntityOwl object) {
        return new ResourceLocation(BroglisOwls.MOD_ID, "textures/angry_owl.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EntityOwl animatable) {
        return new ResourceLocation(BroglisOwls.MOD_ID, "animations/entity_owl.animation.json");
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public void setLivingAnimations(EntityOwl entity, Integer uniqueID, AnimationEvent customPredicate) {
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
