package net.brogli.broglisowls.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.brogli.broglisowls.BroglisOwls;
import net.brogli.broglisowls.entity.custom.Owl;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;
import software.bernie.geckolib3.renderers.geo.GeoLayerRenderer;
import software.bernie.geckolib3.renderers.geo.IGeoRenderer;

public class OwlRenderer extends GeoEntityRenderer<Owl> {

    public OwlRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new OwlModel());
        this.addLayer(new GlowingOwlEyesLayer(this));
        this.shadowRadius = 0.5f;
    }

    @Override
    public ResourceLocation getTextureLocation(Owl owl) {
        return owl.isBaby() ? new ResourceLocation(BroglisOwls.MOD_ID, "textures/baby_owl.png") : new ResourceLocation(BroglisOwls.MOD_ID, "textures/angry_owl.png");
    }

    @Override
    public RenderType getRenderType(Owl animatable, float partialTicks, PoseStack stack,
                                    MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
        stack.scale(0.8F, 0.8F, 0.8F);
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }

    public static class GlowingOwlEyesLayer extends GeoLayerRenderer<Owl> {

        public GlowingOwlEyesLayer(IGeoRenderer<Owl> entityRendererIn) {
            super(entityRendererIn);
        }

        @Override
        public void render(PoseStack matrixStack, MultiBufferSource buffer, int packedLightIn, Owl owl, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {

            this.getRenderer().render(
                    getEntityModel().getModel(owl.isBaby() ? OwlModel.BABY_OWL_GEO : OwlModel.OWL_GEO),
                    owl,
                    partialTicks,
                    RenderType.entityTranslucentEmissive(owl.isBaby() ? OwlModel.BABY_OWL_EYES : OwlModel.OWL_EYES),
                    matrixStack,
                    buffer,
                    buffer.getBuffer(RenderType.entityTranslucentEmissive(owl.isBaby() ? OwlModel.BABY_OWL_EYES : OwlModel.OWL_EYES)),
                    packedLightIn,
                    OverlayTexture.pack(0, OverlayTexture.v(owl.level.isNight())),
                    1f, 1f, 1f, 1f);
        }
    }
}
