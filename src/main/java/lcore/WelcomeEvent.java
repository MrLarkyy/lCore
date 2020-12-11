package lcore;

import lcore.Managers.ConfigValues;
import lcore.Managers.MessagePlayer;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class WelcomeEvent implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        if (ConfigValues.enablewelcomemessages) e.setJoinMessage(ChatColor.translateAlternateColorCodes('&',ConfigValues.joinmsg.replace("%player%",e.getPlayer().getName())));
        else e.setJoinMessage("");
        Player p = e.getPlayer();
        p.sendTitle(ChatColor.translateAlternateColorCodes('&',ConfigValues.welcomeTitle.replace("%player%",p.getName())),ChatColor.translateAlternateColorCodes('&',ConfigValues.welcomeSubtitle.replace("%player%",p.getName())),ConfigValues.welcomeFadein,ConfigValues.welcomeStay,ConfigValues.welcomeFadeout);

        for (Object msg : ConfigValues.welcomeMessage) {

            MessagePlayer.sendMessage(p,msg.toString().replace("%player%",e.getPlayer().getName()));

        }
    }
    @EventHandler
    public void onLeave(PlayerQuitEvent e) {
        if (ConfigValues.enablewelcomemessages) e.setQuitMessage(ChatColor.translateAlternateColorCodes('&',ConfigValues.leavemsg.replace("%player%",e.getPlayer().getName())));
        else e.setQuitMessage("");
    }
}
