package lcore.Managers;

import lcore.LCore;

import java.util.List;

public class ConfigValues {


    public static String noperm;
    public static String serverMotd;
    public static String notonline;
    public static String unknownworld;
    public static String joinmsg;
    public static String leavemsg;
    public static Boolean enablewelcomemessages;
    public static Boolean enabledeathmessage;
    public static String deathmsg;
    public static String availableWorlds;

    public static String welcomeTitle;
    public static String welcomeSubtitle;
    public static int welcomeFadein;
    public static int welcomeStay;
    public static int welcomeFadeout;
    public static List welcomeMessage;

    public static String gamemodePerm;
    public static String gamemodeOtherPerm;
    public static String healPerm;
    public static String healOtherPerm;
    public static String sunPerm;
    public static String rainPerm;
    public static String dayPerm;
    public static String nightPerm;
    public static String teleportPerm;
    public static String teleportOtherPerm;
    public static String suicidePerm;
    public static String flyPerm;
    public static String flyOtherPerm;
    public static String worldPerm;
    public static String worldOtherPerm;
    public static String broadcastPerm;
    public static String messagePerm;
    public static String replyPerm;

    public static String successSound;
    public static String failSound;
    public static String broadcastSound;
    public static String messageSound;

    public static String healPlayerCommand;
    public static String healOtherCommand;
    public static String healFromPlayer;
    public static String teleportPlayerCommand;
    public static String teleportUsageCommand;
    public static String teleportFromPlayer;
    public static String sunCommand;
    public static String sunCommandNotRaining;
    public static String rainCommand;
    public static String rainCommandYet;
    public static String dayCommand;
    public static String nightCommand;
    public static String gamemodeCommand;
    public static String gamemodeOtherCommand;
    public static String gamemodeUsageCommand;
    public static String gamemodeAvailableCommand;
    public static String gamemodeFromPlayer;
    public static String teleportOtherCommand;
    public static String suicideCommand;
    public static String flyCommand;
    public static String flyOtherCommand;
    public static String flyEnabled;
    public static String flyDisabled;
    public static String flyFromPlayer;
    public static String worldCommand;
    public static String worldOtherCommand;
    public static String worldFromPlayer;
    public static String worldUsage;
    public static String broadcastUsage;
    public static String messageTo;
    public static String messageFrom;
    public static String messageUsage;
    public static String replyNoReply;
    public static String replyUsage;
    public ConfigValues() {

        serverMotd = LCore.plugin.getConfig().getString("servermotd");
        enablewelcomemessages = LCore.plugin.getConfig().getBoolean("enablewelcomemessages");
        enabledeathmessage = LCore.plugin.getConfig().getBoolean("enabledeathmessage");
        noperm = LCore.plugin.getConfig().getString("nopermission");
        notonline = LCore.plugin.getConfig().getString("notonline");
        unknownworld = LCore.plugin.getConfig().getString("unknownworld");
        joinmsg = LCore.plugin.getConfig().getString("joinmsg");
        leavemsg = LCore.plugin.getConfig().getString("leavemsg");
        deathmsg = LCore.plugin.getConfig().getString("deathmsg");
        availableWorlds = LCore.plugin.getConfig().getString("availableworlds");

        welcomeTitle = LCore.plugin.getConfig().getString("welcome.title");
        welcomeSubtitle = LCore.plugin.getConfig().getString("welcome.subtitle");
        welcomeFadein = LCore.plugin.getConfig().getInt("welcome.fadein");
        welcomeStay = LCore.plugin.getConfig().getInt("welcome.stay");
        welcomeFadeout = LCore.plugin.getConfig().getInt("welcome.fadeout");
        welcomeMessage = LCore.plugin.getConfig().getList("welcome.message");

        healPerm = LCore.plugin.getConfig().getString("permissions.heal.player");
        healOtherPerm = LCore.plugin.getConfig().getString("permissions.heal.other");
        sunPerm = LCore.plugin.getConfig().getString("permissions.sun.player");
        rainPerm = LCore.plugin.getConfig().getString("permissions.rain.player");
        dayPerm = LCore.plugin.getConfig().getString("permissions.time.day");
        nightPerm = LCore.plugin.getConfig().getString("permissions.time.night");
        gamemodePerm = LCore.plugin.getConfig().getString("permissions.gamemode");
        gamemodeOtherPerm = LCore.plugin.getConfig().getString("permissions.gamemode.other");
        teleportPerm = LCore.plugin.getConfig().getString("permissions.teleport.player");
        teleportOtherPerm = LCore.plugin.getConfig().getString("permissions.teleport.other");
        suicidePerm = LCore.plugin.getConfig().getString("permissions.suicide.player");
        flyPerm = LCore.plugin.getConfig().getString("permissions.fly.player");
        flyOtherPerm = LCore.plugin.getConfig().getString("permissions.fly.other");
        worldPerm = LCore.plugin.getConfig().getString("permissions.world.player");
        worldOtherPerm = LCore.plugin.getConfig().getString("permissions.world.other");
        broadcastPerm = LCore.plugin.getConfig().getString("permissions.broadcast.player");
        messagePerm = LCore.plugin.getConfig().getString("permissions.message.player");
        replyPerm = LCore.plugin.getConfig().getString("permissions.reply.player");

        successSound = LCore.plugin.getConfig().getString("sounds.success");
        failSound = LCore.plugin.getConfig().getString("sounds.failed");
        broadcastSound = LCore.plugin.getConfig().getString("sounds.broadcast");
        messageSound = LCore.plugin.getConfig().getString("sounds.message");

        healPlayerCommand = LCore.plugin.getConfig().getString("commands.heal.player");
        healOtherCommand = LCore.plugin.getConfig().getString("commands.heal.other");
        healFromPlayer = LCore.plugin.getConfig().getString("commands.heal.fromplayer");
        teleportPlayerCommand = LCore.plugin.getConfig().getString("commands.teleport.player");
        teleportOtherCommand = LCore.plugin.getConfig().getString("commands.teleport.other");
        teleportUsageCommand = LCore.plugin.getConfig().getString("commands.teleport.usage");
        teleportFromPlayer = LCore.plugin.getConfig().getString("commands.teleport.fromplayer");
        sunCommand = LCore.plugin.getConfig().getString("commands.sun.player");
        sunCommandNotRaining = LCore.plugin.getConfig().getString("commands.sun.notraining");
        rainCommand = LCore.plugin.getConfig().getString("commands.rain.player");
        rainCommandYet = LCore.plugin.getConfig().getString("commands.rain.raining");
        dayCommand = LCore.plugin.getConfig().getString("commands.day.player");
        nightCommand = LCore.plugin.getConfig().getString("commands.night.player");
        gamemodeCommand = LCore.plugin.getConfig().getString("commands.gamemode.player");
        gamemodeOtherCommand = LCore.plugin.getConfig().getString("commands.gamemode.other");
        gamemodeUsageCommand = LCore.plugin.getConfig().getString("commands.gamemode.usage");
        gamemodeAvailableCommand = LCore.plugin.getConfig().getString("commands.gamemode.modes");
        gamemodeFromPlayer = LCore.plugin.getConfig().getString("commands.gamemode.fromplayer");
        suicideCommand = LCore.plugin.getConfig().getString("commands.suicide.player");
        flyCommand = LCore.plugin.getConfig().getString("commands.fly.player");
        flyOtherCommand = LCore.plugin.getConfig().getString("commands.fly.other");
        flyEnabled = LCore.plugin.getConfig().getString("commands.fly.enabled");
        flyDisabled = LCore.plugin.getConfig().getString("commands.fly.disabled");
        flyFromPlayer = LCore.plugin.getConfig().getString("commands.fly.fromplayer");
        worldCommand = LCore.plugin.getConfig().getString("commands.world.player");
        worldOtherCommand = LCore.plugin.getConfig().getString("commands.world.other");
        worldFromPlayer = LCore.plugin.getConfig().getString("commands.world.fromplayer");
        worldUsage = LCore.plugin.getConfig().getString("commands.world.usage");
        broadcastUsage = LCore.plugin.getConfig().getString("commands.broadcast.usage");
        messageTo = LCore.plugin.getConfig().getString("commands.message.to");
        messageFrom = LCore.plugin.getConfig().getString("commands.message.from");
        messageUsage = LCore.plugin.getConfig().getString("commands.message.usage");
        replyNoReply = LCore.plugin.getConfig().getString("commands.reply.noreply");
        replyUsage = LCore.plugin.getConfig().getString("commands.reply.usage");

    }



}
