package lcore.PrivateMessageCommands;

import lcore.Managers.ConfigValues;
import lcore.Managers.MessagePlayer;
import lcore.Managers.PlaySound;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MessageCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;
        if (p.hasPermission(ConfigValues.messagePerm)) {

            if (args.length >= 2) {

                if (Bukkit.getPlayerExact(args[0])!=null) {

                    Player target = Bukkit.getPlayerExact(args[0]);

                    StringBuilder message = new StringBuilder();
                    for (int i = 1;i < args.length;i++) {
                        message.append(args[i]).append(" ");
                    }
                    MessagePlayer.sendMessage(p,ConfigValues.messageTo.replace("%target%",target.getName()).replace("%message%",message.toString()));
                    MessagePlayer.sendMessage(target,ConfigValues.messageFrom.replace("%player%",p.getName()).replace("%message%",message.toString()));
                    PlaySound.playSound(p,ConfigValues.successSound);
                    PlaySound.playSound(target,ConfigValues.messageSound);

                    PMManager.reply.put(p,target);
                    PMManager.reply.put(target,p);

                } else {

                    MessagePlayer.sendMessage(p,ConfigValues.notonline.replace("%player%",args[0]));
                    PlaySound.playSound(p, ConfigValues.failSound);

                }

            } else {
                MessagePlayer.sendMessage(p,ConfigValues.messageUsage);
                PlaySound.playSound(p, ConfigValues.failSound);
            }

        } else {
            MessagePlayer.sendMessage(p,ConfigValues.noperm);
            PlaySound.playSound(p, ConfigValues.failSound);
        }


        return false;
    }
}
