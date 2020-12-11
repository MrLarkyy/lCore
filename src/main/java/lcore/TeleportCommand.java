package lcore;

import lcore.Managers.ConfigValues;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TeleportCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player p = (Player) sender;

        if (p.hasPermission(ConfigValues.teleportPerm)) {

            if (args.length == 0) {

                p.sendMessage(ChatColor.translateAlternateColorCodes('&',ConfigValues.teleportUsageCommand));
                p.playSound(p.getLocation(),Sound.valueOf(ConfigValues.failSound),1,1);

            } else if (Bukkit.getPlayer(args[0])!=null && args.length == 1) {

                p.teleport(Bukkit.getPlayer(args[0]).getLocation());
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', ConfigValues.teleportPlayerCommand.replace("%player%", Bukkit.getPlayer(args[0]).getName())));
                p.playSound(p.getLocation(), Sound.valueOf(ConfigValues.successSound), 1, 1);
            } else if (Bukkit.getPlayer(args[0])!=null && Bukkit.getPlayer(args[1])!=null && args.length == 2 && p.hasPermission(ConfigValues.teleportOtherPerm)) {

                Player other1 = Bukkit.getPlayer(args[0]);
                Player other2 = Bukkit.getPlayer(args[1]);
                Bukkit.getPlayer(args[0]).teleport(Bukkit.getPlayer(args[1]).getLocation());
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', ConfigValues.teleportOtherCommand.replace("%player%",other1.getName()).replace("%other%",other2.getName())));
                other1.sendMessage(ChatColor.translateAlternateColorCodes('&',ConfigValues.teleportFromPlayer.replace("%player%",p.getName()).replace("%other%",other2.getName())));
            } else if (!(p.hasPermission(ConfigValues.teleportOtherPerm))) {

                p.sendMessage(ChatColor.translateAlternateColorCodes('&',ConfigValues.noperm));
                p.playSound(p.getLocation(), Sound.valueOf(ConfigValues.failSound),1,1);

            } else {

                if (Bukkit.getPlayer(args[0])==null) {
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', ConfigValues.notonline.replace("%player%", args[0])));
                    p.playSound(p.getLocation(), Sound.valueOf(ConfigValues.failSound), 1, 1);
                } else if (args.length == 2 && Bukkit.getPlayer(args[1])==null) {
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', ConfigValues.notonline.replace("%player%", args[1])));
                    p.playSound(p.getLocation(), Sound.valueOf(ConfigValues.failSound), 1, 1);
                }

            }
        } else {
            p.sendMessage(ChatColor.translateAlternateColorCodes('&',ConfigValues.noperm));
            p.playSound(p.getLocation(), Sound.valueOf(ConfigValues.failSound),1,1);
        }

        return false;
    }
}
