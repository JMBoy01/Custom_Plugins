package me.jmboy.custom_plugins.commands;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

import static java.lang.Math.round;

public class SetHome implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players can run this command.");
            return true;
        }
        Player player = (Player) sender;
        Location homeLocation = player.getLocation();

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("x", player.getLocation().getX());
        jsonObject.put("y", player.getLocation().getY());
        jsonObject.put("z", player.getLocation().getZ());

        FileWriter file = null;
        try {
            file = new FileWriter("E:/Minecraft Servers/Spigot Server 1.19/plugins/" + player.getName() + "_" + player.getWorld().getEnvironment() + ".json");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            file.write(jsonObject.toJSONString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            file.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        player.sendMessage("Home location set at [x, y, z] = [" + round(homeLocation.getX()) + ", " + round(homeLocation.getY()) + ", " + round(homeLocation.getZ()) + "]");

        return true;
    }
}
