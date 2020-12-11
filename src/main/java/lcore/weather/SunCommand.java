package lcore.weather;

import lcore.Managers.ConfigValues;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import lcore.LCore;

public class SunCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;
        if (p.hasPermission(LCore.config().getString("permissions.sun.player"))) {
            if (args.length == 0) {
                if (p.getWorld().hasStorm()) {
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', LCore.config().getString("commands.sun.player").replace("%world%", p.getWorld().getName())));
                    p.playSound(p.getLocation(), Sound.valueOf(LCore.config().getString("sounds.success")), 1, 1);
                    p.getWorld().setStorm(false);
                } else {
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', LCore.config().getString("commands.sun.notraining").replace("%world%",p.getWorld().getName())));
                    p.playSound(p.getLocation(), Sound.valueOf(LCore.config().getString("sounds.failed")), 1, 1);
                }
            } else if (Bukkit.getWorld(args[0]) != null) {
                if (Bukkit.getWorld(args[0]).hasStorm()) {
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', LCore.config().getString("commands.sun.player").replace("%world%",args[0])));
                    p.playSound(p.getLocation(), Sound.valueOf(LCore.config().getString("sounds.success")), 1, 1);
                    Bukkit.getWorld(args[0]).setStorm(false);
                } else {
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', LCore.config().getString("commands.sun.notraining").replace("%world%",args[0])));
                    p.playSound(p.getLocation(), Sound.valueOf(LCore.config().getString("sounds.failed")), 1, 1);
                }

            } else {
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', LCore.config().getString("unkownworld").replace("%world%", args[0])));
                p.playSound(p.getLocation(), Sound.valueOf(LCore.config().getString("sounds.failed")), 1, 1);
                StringBuilder ws = new StringBuilder();
                for (World wss : Bukkit.getWorlds()){
                    if (ws.length() > 0) ws.append(", ");
                    ws.append(wss.getName());
                } p.sendMessage(ChatColor.translateAlternateColorCodes('&', ConfigValues.availableWorlds.replace("%worlds%",ws.toString())));
            }
        } else {
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', LCore.config().getString("nopermission")));
            p.playSound(p.getLocation(), Sound.valueOf(LCore.config().getString("sounds.failed")), 1, 1);
        }

        return false;
    }
}
