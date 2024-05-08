package cn.dancingsnow.disable_tools;


import dev.toma.configuration.config.Config;
import dev.toma.configuration.config.Configurable;

@Config(id = DisableToolsMod.MODID)
public class DisableToolsConfig {
    @Configurable
    @Configurable.Comment({"A tool list to disabled tools.", "Support regex. example: minecraft:.*_axe, it match all minecraft axe.", "Default: All Vanilla Tools"})
    public String[] tools = new String[]{
        "minecraft:.*_axe", "minecraft:.*_hoe", "minecraft:.*_pickaxe", "minecraft:.*_shovel"
    };

    @Configurable
    @Configurable.Comment({"The text will show on disabled tool's Tooltip", "Support Translation Text"})
    public String tooltip = "tooltip.disable_tools";
}
