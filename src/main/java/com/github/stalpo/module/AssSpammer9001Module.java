package com.github.stalpo.module;

import com.github.rfresh2.EventConsumer;
import com.zenith.Proxy;
import com.zenith.event.chat.PublicChatEvent;
import com.zenith.module.api.Module;
import org.geysermc.mcprotocollib.protocol.packet.ingame.serverbound.ServerboundChatPacket;

import java.util.List;

import static com.github.rfresh2.EventConsumer.of;
import static com.github.stalpo.AssSpammer9001Plugin.PLUGIN_CONFIG;

public class AssSpammer9001Module extends Module {

    private long lastSentTime = 0; // store timestamp of last message

    @Override
    public boolean enabledSetting() {
        return PLUGIN_CONFIG.enabled;
    }

    @Override
    public List<EventConsumer<?>> registerEvents() {
        return List.of(
                of(PublicChatEvent.class, this::onPublicChat)
        );
    }

    private void onPublicChat(PublicChatEvent event) {
        String messageContents = event.message().trim();
        long now = System.currentTimeMillis();

        if (messageContents.contains("bep") && now - lastSentTime >= 5000) {
            Proxy.getInstance().getClient().sendAsync(new ServerboundChatPacket("ass"));
            lastSentTime = now;
        }
    }
}