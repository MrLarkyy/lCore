package lcore;

import lcore.Managers.ConfigValues;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HealCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;

        if (args.length == 0) {
            if (p.hasPermission(LCore.config().getString("permissions.heal.player"))) {

                p.setHealth(20.0);
                p.setFoodLevel(20);
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', LCore.config().getString("commands.heal.player")));
                p.playSound(p.getLocation(), Sound.valueOf(LCore.config().getString("sounds.success")), 1, 1);

            } else {
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', LCore.config().getString("nopermission")));
                p.playSound(p.getLocation(), Sound.valueOf(LCore.config().getString("sounds.failed")), 1, 1);
            }
        } else {
            if (p.hasPermission(LCore.config().getString("permissions.heal.other"))) {
                if (Bukkit.getPlayer(args[0]) != null) {

                    Player o = Bukkit.getPlayer(args[0]);

                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', LCore.config().getString("commands.heal.other").replace("%player%",o.getName())));
                    p.playSound(p.getLocation(), Sound.valueOf(LCore.config().getString("sounds.success")), 1, 1);

                    o.setHealth(20.0);
                    o.setFoodLevel(20);
                    o.sendMessage(ChatColor.translateAlternateColorCodes('&', ConfigValues.healFromPlayer.replace("%player%",p.getName())));


                } else {
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', LCore.config().getString("notonline").replace("%player%", args[0])));
                    p.playSound(p.getLocation(), Sound.valueOf(LCore.config().getString("sounds.failed")), 1, 1);
                }
            } else {
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', LCore.config().getString("nopermission")));
                p.playSound(p.getLocation(), Sound.valueOf(LCore.config().getString("sounds.failed")), 1, 1);

            }
        }

        return false;
    }
}
