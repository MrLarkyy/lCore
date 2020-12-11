package lcore.weather;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import lcore.Managers.ConfigValues;

public class RainCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;
        if (p.hasPermission(ConfigValues.rainPerm)) {
            if (args.length == 0) {
                if (!(p.getWorld().hasStorm())) {
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&',ConfigValues.rainCommand.replace("%world%", p.getWorld().getName())));
                    p.playSound(p.getLocation(), Sound.valueOf(ConfigValues.successSound), 1, 1);
                    p.getWorld().setStorm(true);
                } else {
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&',ConfigValues.rainCommandYet.replace("%world%",p.getWorld().getName())));
                    p.playSound(p.getLocation(), Sound.valueOf(ConfigValues.failSound), 1, 1);
                }
            } else if (Bukkit.getWorld(args[0]) != null) {
                if (!(Bukkit.getWorld(args[0]).hasStorm())) {
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&',ConfigValues.rainCommand.replace("%world%",args[0])));
                    p.playSound(p.getLocation(), Sound.valueOf(ConfigValues.successSound), 1, 1);
                    Bukkit.getWorld(args[0]).setStorm(true);
                } else {
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&',ConfigValues.rainCommandYet.replace("%world%",args[0])));
                    p.playSound(p.getLocation(), Sound.valueOf(ConfigValues.failSound), 1, 1);
                }

            } else {
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', ConfigValues.unknownworld.replace("%world%", args[0])));
                p.playSound(p.getLocation(), Sound.valueOf(ConfigValues.failSound), 1, 1);
                StringBuilder ws = new StringBuilder();
                for (World wss : Bukkit.getWorlds()){
                    if (ws.length() > 0) ws.append(", ");
                    ws.append(wss.getName());
                } p.sendMessage(ChatColor.translateAlternateColorCodes('&',ConfigValues.availableWorlds.replace("%worlds%",ws.toString())));
            }
        } else {
            p.sendMessage(ChatColor.translateAlternateColorCodes('&',ConfigValues.noperm));
            p.playSound(p.getLocation(), Sound.valueOf(ConfigValues.failSound), 1, 1);
        }

        return false;
    }
}
