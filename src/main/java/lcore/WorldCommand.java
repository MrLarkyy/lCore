package lcore;

import lcore.Managers.ConfigValues;
import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class WorldCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player p = (Player) sender;

        if (args.length == 0 && p.hasPermission(ConfigValues.worldPerm)) {

            p.sendMessage(ChatColor.translateAlternateColorCodes('&',ConfigValues.worldUsage));
            p.playSound(p.getLocation(), Sound.valueOf(ConfigValues.failSound),1,1);

            StringBuilder ws = new StringBuilder();
            for (World w : Bukkit.getWorlds()){
                if (ws.length() > 0) ws.append(", ");
                ws.append(w.getName());
            } p.sendMessage(ChatColor.translateAlternateColorCodes('&',ConfigValues.availableWorlds.replace("%worlds%",ws.toString())));

        } else if (args.length == 1 && Bukkit.getWorld(args[0])!=null && p.hasPermission(ConfigValues.worldPerm)) {

            Location loc = Bukkit.getWorld(args[0]).getSpawnLocation();
            p.teleport(loc);
            p.sendMessage(ChatColor.translateAlternateColorCodes('&',ConfigValues.worldCommand.replace("%world%",args[0])));
            p.playSound(p.getLocation(), Sound.valueOf(ConfigValues.successSound),1,1);

        } else if ((args.length == 1 || args.length == 2 )&& Bukkit.getWorld(args[0])==null && p.hasPermission(ConfigValues.worldPerm)) {

            p.sendMessage(ChatColor.translateAlternateColorCodes('&',ConfigValues.unknownworld.replace("%world%",args[0])));
            p.playSound(p.getLocation(), Sound.valueOf(ConfigValues.failSound),1,1);
            StringBuilder ws = new StringBuilder();
            for (World w : Bukkit.getWorlds()){
                if (ws.length() > 0) ws.append(", ");
                ws.append(w.getName());
            } p.sendMessage(ChatColor.translateAlternateColorCodes('&',ConfigValues.availableWorlds.replace("%worlds%",ws.toString())));


        } else if (args.length == 2 && Bukkit.getWorld(args[0])!=null && p.hasPermission(ConfigValues.worldPerm)) {

            if (Bukkit.getPlayer(args[1])!=null) {

                Player o = Bukkit.getPlayer(args[1]);
                Location loc = Bukkit.getWorld(args[0]).getSpawnLocation();

                p.sendMessage(ChatColor.translateAlternateColorCodes('&',ConfigValues.worldOtherCommand.replace("%player%",o.getName()).replace("%world%",args[0])));
                p.playSound(p.getLocation(), Sound.valueOf(ConfigValues.successSound),1,1);

                o.teleport(loc);
                o.sendMessage(ChatColor.translateAlternateColorCodes('&',ConfigValues.worldFromPlayer.replace("%player%",p.getName()).replace("%world%",args[0])));

            } else {

                p.sendMessage(ChatColor.translateAlternateColorCodes('&',ConfigValues.notonline.replace("%player%",args[1])));
                p.playSound(p.getLocation(), Sound.valueOf(ConfigValues.failSound),1,1);

            }

        }
        else {

            p.sendMessage(ChatColor.translateAlternateColorCodes('&',ConfigValues.noperm));
            p.playSound(p.getLocation(), Sound.valueOf(ConfigValues.failSound),1,1);

        }

        return false;
    }
}
