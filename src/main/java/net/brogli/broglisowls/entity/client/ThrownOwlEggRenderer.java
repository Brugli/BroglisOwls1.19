package net.brogli.broglisowls.entity.client;


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Vector3f;
import net.brogli.broglisowls.BroglisOwls;
import net.brogli.broglisowls.entity.projectile.ThrownOwlEgg;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import org.jetbrains.annotations.NotNull;

public class ThrownOwlEggRenderer<T extends ThrownOwlEgg> extends EntityRenderer<T> {

    private static final float MIN_CAMERA_DISTANCE_SQUARED = 12.25F;
    private final ItemRenderer itemRenderer;
    private final float scale;
    private final boolean fullBright;

    public ThrownOwlEggRenderer(EntityRendererProvider.Context context, float f, boolean b) {
        super(context);
        this.itemRenderer = context.getItemRenderer();
        this.scale = f;
        this.fullBright = b;
    }

    public ThrownOwlEggRenderer(EntityRendererProvider.Context context) {
        this(context, 1.0F, false);
    }

    protected int getBlockLightLevel(T t, BlockPos pos) {
        return this.fullBright ? 15 : super.getBlockLightLevel(t, pos);
    }

    public void render(T t, float a, float b, PoseStack stack, MultiBufferSource bufferSource, int i) {
        if (t.tickCount >= 2 || !(this.entityRenderDispatcher.camera.getEntity().distanceToSqr(t) < 12.25D)) {
            stack.pushPose();
            stack.scale(this.scale, this.scale, this.scale);
            stack.mulPose(this.entityRenderDispatcher.cameraOrientation());
            stack.mulPose(Vector3f.YP.rotationDegrees(180.0F));
            this.itemRenderer.renderStatic(t.getItem(), ItemTransforms.TransformType.GROUND, i, OverlayTexture.NO_OVERLAY, stack, bufferSource, t.getId());
            stack.popPose();
            super.render(t, a, b, stack, bufferSource, i);
        }
    }

    @Override
    public ResourceLocation getTextureLocation(T t) {
        return new ResourceLocation(BroglisOwls.MOD_ID, "textures/item/item_owl_egg.png");
    }

}
