package com.github.stalpo;

import com.github.stalpo.command.AssSpammer9001Command;
import com.github.stalpo.module.AssSpammer9001Module;
import com.zenith.plugin.api.Plugin;
import com.zenith.plugin.api.PluginAPI;
import com.zenith.plugin.api.ZenithProxyPlugin;
import net.kyori.adventure.text.logger.slf4j.ComponentLogger;

@Plugin(
    id = "example-plugin",
    version = com.github.stalpo.BuildConstants.VERSION,
    description = "Ass Spammer 9001 Plugin",
    url = "https://github.com/Stalpo/AssSpammer9001",
    authors = {"stalpo"},
    mcVersions = {"1.21.4"}
)
public class AssSpammer9001Plugin implements ZenithProxyPlugin {
    public static AssSpammer9001Config PLUGIN_CONFIG;
    public static ComponentLogger LOG;

    @Override
    public void onLoad(PluginAPI pluginAPI) {
        LOG = pluginAPI.getLogger();
        PLUGIN_CONFIG = pluginAPI.registerConfig("ass-spammer-9001", AssSpammer9001Config.class);
        pluginAPI.registerModule(new AssSpammer9001Module());
        pluginAPI.registerCommand(new AssSpammer9001Command());
    }
}
