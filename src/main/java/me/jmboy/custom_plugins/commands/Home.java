package me.jmboy.custom_plugins.commands;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class Home implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player)){
            sender.sendMessage("Only players can run this command.");
            return true;
        }

        Player player = (Player) sender;

        JSONParser jsonParser = new JSONParser();
        Object obj = null;
        try {
            obj = jsonParser.parse(new FileReader("E:/Minecraft Servers/Spigot Server 1.19/plugins/" + player.getName() + "_" + player.getWorld().getEnvironment() + ".json"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        JSONObject jsonObject = (JSONObject) obj;
        double x = (double) jsonObject.get("x");
        double y = (double) jsonObject.get("y");
        double z = (double) jsonObject.get("z");

        Location homeLocation = new Location(player.getWorld(), x,y,z);
        player.teleport(homeLocation);
        player.sendMessage("Teleported to home location.");

        return true;
    }
}
