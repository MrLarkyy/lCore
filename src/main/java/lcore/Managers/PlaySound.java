package lcore.Managers;

import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class PlaySound {

    public static void playSound (Player p, String s) {
        p.playSound(p.getLocation(),Sound.valueOf(s),1,1);
    }

}
