package lcore;

import lcore.Managers.ConfigValues;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SuicideCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player p = (Player) sender;
        if (p.hasPermission(ConfigValues.suicidePerm)) {

            p.setHealth(0.0);
            p.sendMessage(ChatColor.translateAlternateColorCodes('&',ConfigValues.suicideCommand));
            p.playSound(p.getLocation(),Sound.valueOf(ConfigValues.successSound),1,1);


        } else {
            p.sendMessage(ChatColor.translateAlternateColorCodes('&',ConfigValues.noperm));
            p.playSound(p.getLocation(), Sound.valueOf(ConfigValues.failSound),1,1);
        }

        return false;
    }
}
