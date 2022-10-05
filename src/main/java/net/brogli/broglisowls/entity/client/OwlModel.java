package net.brogli.broglisowls.entity.client;

import net.brogli.broglisowls.BroglisOwls;
import net.brogli.broglisowls.entity.custom.Owl;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

public class OwlModel extends AnimatedGeoModel<Owl> {
    public static final ResourceLocation OWL_GEO = new ResourceLocation(BroglisOwls.MOD_ID, "geo/entity_owl.geo.json");
    public static final ResourceLocation BABY_OWL_GEO = new ResourceLocation(BroglisOwls.MOD_ID, "geo/entity_baby_owl.geo.json");
    public static final ResourceLocation OWL_TEX = new ResourceLocation(BroglisOwls.MOD_ID, "textures/angry_owl.png");
    public static final ResourceLocation BABY_OWL_TEX = new ResourceLocation(BroglisOwls.MOD_ID, "textures/baby_owl.png");
    public static final ResourceLocation OWL_ANIM = new ResourceLocation(BroglisOwls.MOD_ID, "animations/entity_owl.animation.json");
    public static final ResourceLocation OWL_EYES = new ResourceLocation(BroglisOwls.MOD_ID, "textures/angry_owl_glow.png");
    public static final ResourceLocation BABY_OWL_EYES = new ResourceLocation(BroglisOwls.MOD_ID, "textures/baby_owl_glow.png");

    @Override
    public ResourceLocation getModelResource(Owl owl) {
        return owl.isBaby() ? BABY_OWL_GEO : OWL_GEO;
    }

    @Override
    public ResourceLocation getTextureResource(Owl owl) {
        return owl.isBaby() ? BABY_OWL_TEX : OWL_TEX;
    }

    @Override
    public ResourceLocation getAnimationResource(Owl owl) {
        return OWL_ANIM;
    }

    @Override
    public void setLivingAnimations(Owl entity, Integer uniqueID, AnimationEvent customPredicate) {
        super.setLivingAnimations(entity, uniqueID, customPredicate);
        IBone head = this.getAnimationProcessor().getBone("Head");

        if (customPredicate.getExtraDataOfType(EntityModelData.class).get(0) instanceof EntityModelData extraData && head != null) {
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
