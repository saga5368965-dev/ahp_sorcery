package net.saga.ahpsorceryedition;

import com.mojang.logging.LogUtils;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(AHPSorceryEdition.MODID)
public class AHPSorceryEdition {
    public static final String MODID = "ahp_sorcery";
    private static final Logger LOGGER = LogUtils.getLogger();

    public AHPSorceryEdition() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // 共通セットアップの登録
        modEventBus.addListener(this::commonSetup);

        // イベントバスの登録
        MinecraftForge.EVENT_BUS.register(this);

        LOGGER.info("Adorable Hamster Pets: Sorcery Edition - Initializing");
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        // 前提Modがちゃんと入っているか最終確認
        if (ModList.get().isLoaded("irons_spellbooks") && ModList.get().isLoaded("hamsters")) {
            LOGGER.info("Magic hamsters are ready to study!");
        } else {
            LOGGER.error("Required mods (Iron's Spells or Hamster Pets) are missing!");
        }
    }
}