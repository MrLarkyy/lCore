package lcore.PrivateMessageCommands;

import lcore.Managers.ConfigValues;
import lcore.Managers.MessagePlayer;
import lcore.Managers.PlaySound;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ReplyCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player p = (Player) sender;
        if (p.hasPermission(ConfigValues.replyPerm)) {

            if (args.length >= 1) {

                if (PMManager.reply.containsKey(p)) {

                    if (PMManager.reply.get(p)!=null) {

                        Player target = PMManager.reply.get(p);

                        StringBuilder message = new StringBuilder();
                        for (int i = 0;i < args.length;i++) {
                            message.append(args[i]).append(" ");
                        }

                        MessagePlayer.sendMessage(p,ConfigValues.messageTo.replace("%target%",target.getName()).replace("%message%",message.toString()));
                        MessagePlayer.sendMessage(p,ConfigValues.messageFrom.replace("%player%",p.getName()).replace("%message%",message.toString()));
                        PlaySound.playSound(p,ConfigValues.successSound);
                        PlaySound.playSound(target,ConfigValues.messageSound);

                        PMManager.reply.put(p,target);
                        PMManager.reply.put(target,p);

                    } else {

                        MessagePlayer.sendMessage(p,ConfigValues.replyNoReply);
                        PlaySound.playSound(p, ConfigValues.failSound);

                    }

                } else {

                    MessagePlayer.sendMessage(p,ConfigValues.replyNoReply);
                    PlaySound.playSound(p, ConfigValues.failSound);

                }

            } else {

                MessagePlayer.sendMessage(p,ConfigValues.replyUsage);
                PlaySound.playSound(p, ConfigValues.failSound);

            }

        } else {
            MessagePlayer.sendMessage(p,ConfigValues.noperm);
            PlaySound.playSound(p, ConfigValues.failSound);
        }

        return false;
    }
}
