package lcore;

import lcore.Managers.ConfigValues;
import lcore.Managers.MessagePlayer;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class BroadcastCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;
        if (p.hasPermission(ConfigValues.broadcastPerm)){

            if (args.length > 0) {


                StringBuilder broadcast = new StringBuilder();
                for (String arg : args) {
                    broadcast.append(arg).append(" ");
                }
                Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&',broadcast.toString()));

                for (Player players : Bukkit.getOnlinePlayers()) {
                    players.playSound(p.getLocation(), Sound.valueOf(ConfigValues.broadcastSound),1,1);
                }

            } else {

                p.sendMessage(ChatColor.translateAlternateColorCodes('&',ConfigValues.broadcastUsage));
                p.playSound(p.getLocation(), Sound.valueOf(ConfigValues.failSound),1,1);

            }

        } else {

            MessagePlayer.sendMessage(p,ConfigValues.noperm);
            p.playSound(p.getLocation(), Sound.valueOf(ConfigValues.failSound),1,1);

        }
        return false;
    }
}
