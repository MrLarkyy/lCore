package lcore;

import lcore.Managers.ConfigValues;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class FlyCommand implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {


        Player p = (Player) sender;

        if (p.hasPermission(ConfigValues.flyPerm) && args.length == 0) {
            if (p.getAllowFlight()) {

                p.sendMessage(ChatColor.translateAlternateColorCodes('&', ConfigValues.flyCommand.replace("%state%", ConfigValues.flyDisabled)));
                p.playSound(p.getLocation(), Sound.valueOf(ConfigValues.successSound), 1, 1);
                p.setAllowFlight(false);
                p.setFlying(false);

            } else {

                p.sendMessage(ChatColor.translateAlternateColorCodes('&', ConfigValues.flyCommand.replace("%state%", ConfigValues.flyEnabled)));
                p.playSound(p.getLocation(), Sound.valueOf(ConfigValues.successSound), 1, 1);
                p.setAllowFlight(true);
                p.setFlying(true);
            }
        } else if (p.hasPermission(ConfigValues.flyOtherPerm)) {
            if (Bukkit.getPlayer(args[0])!=null) {

                Player o = Bukkit.getPlayer(args[0]);
                if (o.getAllowFlight()) {

                    p.sendMessage(ChatColor.translateAlternateColorCodes('&',ConfigValues.flyOtherCommand.replace("%state%",ConfigValues.flyDisabled).replace("%player%",o.getName())));
                    p.playSound(p.getLocation(), Sound.valueOf(ConfigValues.successSound), 1, 1);
                    o.sendMessage(ChatColor.translateAlternateColorCodes('&',ConfigValues.flyFromPlayer.replace("%state%",ConfigValues.flyDisabled).replace("%player%",p.getName())));
                    o.setAllowFlight(false);
                    o.setFlying(false);

                } else {

                    p.sendMessage(ChatColor.translateAlternateColorCodes('&',ConfigValues.flyOtherCommand.replace("%state%",ConfigValues.flyEnabled).replace("%player%",o.getName())));
                    p.playSound(p.getLocation(), Sound.valueOf(ConfigValues.successSound), 1, 1);
                    o.sendMessage(ChatColor.translateAlternateColorCodes('&',ConfigValues.flyFromPlayer.replace("%state%",ConfigValues.flyEnabled).replace("%player%",p.getName())));
                    o.setAllowFlight(true);
                    o.setFlying(true);

                }

            } else {
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', ConfigValues.notonline.replace("%player%", args[0])));
                p.playSound(p.getLocation(), Sound.valueOf(ConfigValues.failSound), 1, 1);
            }
        } else {
            p.sendMessage(ChatColor.translateAlternateColorCodes('&',ConfigValues.noperm));
            p.playSound(p.getLocation(), Sound.valueOf(ConfigValues.failSound),1,1);
        }

        return false;
    }
}
