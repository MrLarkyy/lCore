package lcore;

import lcore.Managers.ConfigValues;
import lcore.Managers.MessagePlayer;
import lcore.Managers.PlaySound;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Arrays;

public class GamemodeCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;
        if (args.length == 0 && p.hasPermission(ConfigValues.gamemodePerm)) {

            MessagePlayer.sendMessage(p,ConfigValues.gamemodeUsageCommand);
            PlaySound.playSound(p,ConfigValues.failSound);

        } else if (args.length == 1 && p.hasPermission(ConfigValues.gamemodePerm)) {

            args[0] = args[0].toLowerCase().replace("1","creative").replace("0","survival").replace("2","adventure").replace("3","spectator");

            ArrayList<String> gmTypes = new ArrayList(Arrays.asList("survival", "creative", "adventure", "spectator"));
            if (gmTypes.contains(args[0].toLowerCase())) {

                if (p.hasPermission(ConfigValues.gamemodePerm + args[0])) {

                p.setGameMode(GameMode.valueOf(args[0].toUpperCase()));
                MessagePlayer.sendMessage(p,ConfigValues.gamemodeCommand.replace("%gamemode%",args[0]));
                PlaySound.playSound(p,ConfigValues.successSound);

                } else {

                    MessagePlayer.sendMessage(p,ConfigValues.noperm);
                    PlaySound.playSound(p,ConfigValues.failSound);

                }
            } else {

                p.sendMessage(ChatColor.translateAlternateColorCodes('&',ConfigValues.gamemodeAvailableCommand));
                p.playSound(p.getLocation(), Sound.valueOf(ConfigValues.failSound), 1, 1);

            }
        } else if (args.length == 2 && p.hasPermission(ConfigValues.gamemodeOtherPerm)) {

            args[0] = args[0].toLowerCase().replace("1","creative").replace("0","survival").replace("2","adventure").replace("3","spectator");
            ArrayList<String> gmTypes = new ArrayList(Arrays.asList("survival", "creative", "adventure", "spectator"));
            if (gmTypes.contains(args[0].toLowerCase())) {

                if (p.hasPermission(ConfigValues.gamemodeOtherPerm + args[0])) {

                    if (Bukkit.getPlayer(args[1]) != null) {
                        Player o = Bukkit.getPlayer(args[1]);

                        o.setGameMode(GameMode.valueOf(args[0].toUpperCase()));
                        MessagePlayer.sendMessage(o,ConfigValues.gamemodeFromPlayer.replace("%gamemode%",args[0]).replace("%player%",p.getName()));
                        MessagePlayer.sendMessage(p,ConfigValues.gamemodeOtherCommand.replace("%player%",o.getName()).replace("%gamemode%",args[0]));
                        PlaySound.playSound(p,ConfigValues.successSound);

                    } else {
                        MessagePlayer.sendMessage(p,ConfigValues.notonline.replace("%player%",args[1]));
                        PlaySound.playSound(p,ConfigValues.failSound);
                    }
                } else {

                    MessagePlayer.sendMessage(p,ConfigValues.noperm);
                    PlaySound.playSound(p,ConfigValues.failSound);

                }
            } else {

                MessagePlayer.sendMessage(p,ConfigValues.gamemodeAvailableCommand);
                PlaySound.playSound(p,ConfigValues.failSound);

            }

        } else {

            MessagePlayer.sendMessage(p,ConfigValues.noperm);
            PlaySound.playSound(p,ConfigValues.failSound);


        }
        return false;
    }
}
