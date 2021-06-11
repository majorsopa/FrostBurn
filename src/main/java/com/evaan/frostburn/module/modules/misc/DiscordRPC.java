package com.evaan.frostburn.module.modules.misc;

import com.evaan.frostburn.FrostBurn;
import com.evaan.frostburn.module.Module;
import net.arikia.dev.drpc.DiscordEventHandlers;
import net.arikia.dev.drpc.DiscordRichPresence;

/**
 * @Author evaan
 * https://github.com/evaan
 */
public class DiscordRPC extends Module {
    public DiscordRPC() {
        super("DiscordRPC", Category.MISC);
    }

    @Override
    public void onEnable() {
        String clientVersion = FrostBurn.clientVersionString;
        net.arikia.dev.drpc.DiscordRPC.discordInitialize("820481496962826291", new DiscordEventHandlers.Builder().setReadyEventHandler(user -> {
        }).build(), true);
        net.arikia.dev.drpc.DiscordRPC.discordUpdatePresence(new DiscordRichPresence.Builder(getIP()).setBigImage("logo", clientVersion).build());
    }

    @Override
    public void onDisable() {
        net.arikia.dev.drpc.DiscordRPC.discordShutdown();
    }

    @Override
    public void onUpdate() {
        String clientVersion = FrostBurn.clientVersionString;
        net.arikia.dev.drpc.DiscordRPC.discordUpdatePresence(new DiscordRichPresence.Builder(getIP()).setBigImage("logo", clientVersion).build());
    }

    public String getIP() {
        if (mc.isInSingleplayer()) return "Singleplayer";
        try {
            return mc.getCurrentServerEntry().address;
        } catch (Exception e) {
            return "Main Menu";
        }
    }

}
