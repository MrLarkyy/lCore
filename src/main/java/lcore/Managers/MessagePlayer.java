package lcore.Managers;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class MessagePlayer {

    public static void sendMessage (Player p, String message) {
        p.sendMessage(ChatColor.translateAlternateColorCodes('&',message));
    }

}
