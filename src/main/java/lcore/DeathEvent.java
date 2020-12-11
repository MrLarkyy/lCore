package lcore;

import lcore.Managers.ConfigValues;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class DeathEvent implements Listener {
    @EventHandler
    public void onDeath(PlayerDeathEvent e){
        if (ConfigValues.enabledeathmessage) {
            e.setDeathMessage(ChatColor.translateAlternateColorCodes('&',ConfigValues.deathmsg.replace("%player%",e.getEntity().getPlayer().getName())));
        }

    }
}
