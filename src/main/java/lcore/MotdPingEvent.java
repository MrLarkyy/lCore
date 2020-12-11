package lcore;

import lcore.Managers.ConfigValues;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

public class MotdPingEvent implements Listener {
    @EventHandler
    public void onPing(ServerListPingEvent e){
        e.setMotd(ChatColor.translateAlternateColorCodes('&', ConfigValues.serverMotd));
    }
}
