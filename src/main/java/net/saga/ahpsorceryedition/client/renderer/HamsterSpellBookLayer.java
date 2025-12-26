package net.saga.ahpsorceryedition.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import io.redspace.ironsspellbooks.item.SpellBookItem;
import io.redspace.ironsspellbooks.entity.spells.portal.SpellBookModel;
import net.dawson.adorablehamsterpets.common.entity.HamsterEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.world.item.ItemStack;
import software.bernie.geckolib.renderer.GeoRenderer;
import software.bernie.geckolib.renderer.layer.GeoRenderLayer;
import software.bernie.geckolib.util.RenderUtils;

public class HamsterSpellBookLayer extends GeoRenderLayer<HamsterEntity> {
    private final SpellBookModel BOOK_MODEL = new SpellBookModel();

    public HamsterSpellBookLayer(GeoRenderer<HamsterEntity> entityRenderer) {
        super(entityRenderer);
    }

    @Override
    public void render(PoseStack poseStack, MultiBufferSource bufferSource, int packedLight,
                       HamsterEntity entity, float limbSwing, float limbSwingAmount,
                       float partialTick, float ageInTicks, float netHeadYaw, float headPitch) {

        ItemStack itemStack = entity.getMainHandItem();
        if (!(itemStack.getItem() instanceof SpellBookItem spellBook)) return;

        // bodyボーンの取得
        this.getRenderer().getGeoModel().getBone("body").ifPresent(body -> {
            poseStack.pushPose();

            // 位置と回転の同期
            RenderUtils.translateMatrixToBone(poseStack, body);
            RenderUtils.rotateMatrixByBone(poseStack, body);

            // 背中への調整
            poseStack.translate(0, 0.4, 0);
            poseStack.scale(0.35f, 0.35f, 0.35f);

            // レンダリング実行（テクスチャ取得などは以前のコードと同様）
            // ... (省略)

            poseStack.popPose();
        });
    }
}
