package me.jmboy.custom_plugins.handlers;

import com.destroystokyo.paper.MaterialSetTag;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.Arrays;

public class OnePlayerSleepListener implements Listener {
    @EventHandler
    public void OnOnePlayerSleep(PlayerInteractEvent event){
        Player player = event.getPlayer();
        World world = player.getWorld();
        Material[] bed = new Material[16];
        bed[0] = Material.YELLOW_BED;
        bed[1] = Material.BLACK_BED;
        bed[2] = Material.BROWN_BED;
        bed[3] = Material.BLUE_BED;
        bed[4] = Material.CYAN_BED;
        bed[5] = Material.GRAY_BED;
        bed[6] = Material.GREEN_BED;
        bed[7] = Material.LIGHT_BLUE_BED;
        bed[8] = Material.LIGHT_GRAY_BED;
        bed[9] = Material.LIME_BED;
        bed[10] = Material.MAGENTA_BED;
        bed[11] = Material.ORANGE_BED;
        bed[12] = Material.PINK_BED;
        bed[13] = Material.PURPLE_BED;
        bed[14] = Material.RED_BED;
        bed[15] = Material.WHITE_BED;

        boolean contains = Arrays.stream(bed).anyMatch(event.getClickedBlock().getType()::equals);

        if (event.getAction() == Action.RIGHT_CLICK_BLOCK && contains == true && world.getTime() > 13000){
            world.setTime(1000);
            player.sendMessage("The night has been skipped.");
        }
    }
}
