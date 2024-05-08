package cn.dancingsnow.disable_tools;

import com.mojang.logging.LogUtils;
import dev.toma.configuration.Configuration;
import dev.toma.configuration.config.format.ConfigFormats;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import org.slf4j.Logger;

@Mod(DisableToolsMod.MODID)
public class DisableToolsMod {
    public static final String MODID = "disable_tools";
    public static final Logger LOGGER = LogUtils.getLogger();

    public static final DisableToolsConfig config = Configuration.registerConfig(DisableToolsConfig.class, ConfigFormats.yaml()).getConfigInstance();

    public DisableToolsMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
    }

    public static boolean isItemDisabled(Item item) {
        ResourceLocation key = ForgeRegistries.ITEMS.getKey(item);
        if (key == null) return false;
        for (String regex : config.tools) {
            if (key.toString().matches(regex)) {
                return true;
            }
        }
        return false;
    }
}
