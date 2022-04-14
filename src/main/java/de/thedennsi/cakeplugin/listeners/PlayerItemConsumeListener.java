package de.thedennsi.cakeplugin.listeners;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerItemConsumeListener implements Listener {

    @EventHandler(ignoreCancelled = true)
    public void onPlayerInteract(PlayerInteractEvent event) {

        Block block = event.getClickedBlock();

        if (block == null)
            return;

        if (!event.getAction().equals(Action.RIGHT_CLICK_BLOCK))
            return;

        if (event.getClickedBlock().getType().equals(Material.CAKE))
            return;

        
    }
}
