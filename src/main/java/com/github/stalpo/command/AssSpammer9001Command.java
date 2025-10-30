package com.github.stalpo.command;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.zenith.command.api.Command;
import com.zenith.command.api.CommandCategory;
import com.zenith.command.api.CommandContext;
import com.zenith.command.api.CommandUsage;
import com.zenith.discord.Embed;
import com.github.stalpo.module.AssSpammer9001Module;

import static com.mojang.brigadier.arguments.IntegerArgumentType.getInteger;
import static com.mojang.brigadier.arguments.IntegerArgumentType.integer;
import static com.zenith.Globals.MODULE;
import static com.zenith.command.brigadier.ToggleArgumentType.getToggle;
import static com.zenith.command.brigadier.ToggleArgumentType.toggle;
import static com.github.stalpo.AssSpammer9001Plugin.PLUGIN_CONFIG;

public class AssSpammer9001Command extends Command {
    @Override
    public CommandUsage commandUsage() {
        return CommandUsage.builder()
            .name("assSpammer9001Plugin")
            .category(CommandCategory.MODULE)
            .description("""
                Ass Spammer 9001 plugin command
                """)
            .usageLines(
                "on/off"
            )
            .build();
    }

    @Override
    public LiteralArgumentBuilder<CommandContext> register() {
        return command("assSpammer9001Plugin")
            .then(argument("toggle", toggle()).executes(c -> {
                PLUGIN_CONFIG.enabled = getToggle(c, "toggle");
                MODULE.get(AssSpammer9001Module.class).syncEnabledFromConfig();
                c.getSource().getEmbed()
                    .title("Ass Spammer 9001 Plugin " + toggleStrCaps(PLUGIN_CONFIG.enabled));
            }));
    }

    @Override
    public void defaultEmbed(Embed embed) {
        embed
            .primaryColor()
            .addField("Enabled", toggleStr(PLUGIN_CONFIG.enabled));
    }
}
