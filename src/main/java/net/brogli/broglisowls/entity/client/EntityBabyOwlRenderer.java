package net.brogli.broglisowls.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.brogli.broglisowls.BroglisOwls;
import net.brogli.broglisowls.entity.custom.EntityBabyOwl;
import net.brogli.broglisowls.entity.custom.EntityOwl;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;
import software.bernie.geckolib3.renderers.geo.GeoLayerRenderer;
import software.bernie.geckolib3.renderers.geo.IGeoRenderer;

public class EntityBabyOwlRenderer extends GeoEntityRenderer<EntityBabyOwl> {

    public EntityBabyOwlRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new EntityBabyOwlModel());
        this.addLayer(new GlowingBabyOwlEyesLayer(this));
        this.shadowRadius = 0.4f;
    }

    @Override
    public ResourceLocation getTextureLocation(EntityBabyOwl object) {
        return new ResourceLocation(BroglisOwls.MOD_ID, "textures/baby_owl.png");
    }

    @Override
    public RenderType getRenderType(EntityBabyOwl animatable, float partialTicks, PoseStack stack,
                                    MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
        stack.scale(0.8F, 0.8F, 0.8F);
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }

    public static class GlowingBabyOwlEyesLayer<T extends EntityBabyOwl> extends GeoLayerRenderer<T> {

        private final ResourceLocation GLOWING_EYES;

        private final ResourceLocation OWL_MODEL;

        public GlowingBabyOwlEyesLayer(IGeoRenderer<T> entityRendererIn) {
            super(entityRendererIn);
            GLOWING_EYES = new ResourceLocation(BroglisOwls.MOD_ID,"textures/baby_owl_glow.png");
            OWL_MODEL = new ResourceLocation(BroglisOwls.MOD_ID, "geo/entity_baby_owl.geo.json");
        }

        @Override
        public void render(PoseStack matrixStack, MultiBufferSource buffer, int packedLightIn, T entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {

            this.getRenderer().render(getEntityModel().getModel(OWL_MODEL), entity, partialTicks, RenderType.entityTranslucentEmissive(GLOWING_EYES), matrixStack, buffer,
                    buffer.getBuffer(RenderType.entityTranslucentEmissive(GLOWING_EYES)), packedLightIn, OverlayTexture.pack(0, OverlayTexture.v(entity.level.isNight())), 1f, 1f, 1f, 1f);
        }
    }
}
