package net.saga.ahpsorceryedition.event;

import net.saga.ahpsorceryedition.AHPSorceryEdition;
import net.saga.ahpsorceryedition.client.renderer.HamsterSpellBookLayer;
import net.dawson.adorablehamsterpets.common.registry.ModEntities;
import net.dawson.adorablehamsterpets.client.render.HamsterRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = AHPSorceryEdition.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEvents {

    @SubscribeEvent
    public static void onAddLayers(EntityRenderersEvent.AddLayers event) {
        // ModEntities.HAMSTERS.get() で EntityType を取得
        HamsterRenderer renderer = event.getRenderer(ModEntities.HAMSTERS.get());
        if (renderer != null) {
            renderer.addRenderLayer(new HamsterSpellBookLayer(renderer));
        }
    }
}
