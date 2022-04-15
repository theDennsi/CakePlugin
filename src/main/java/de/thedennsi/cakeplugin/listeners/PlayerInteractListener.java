package de.thedennsi.cakeplugin.listeners;

import de.thedennsi.cakeplugin.CakePlugin;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.ThreadLocalRandom;

public class PlayerInteractListener implements Listener {

    private final CakePlugin plugin;

    public PlayerInteractListener(CakePlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler(ignoreCancelled = true)
    public void onPlayerInteract(PlayerInteractEvent event) throws InvocationTargetException, IllegalAccessException {
        if (!event.getAction().equals(Action.RIGHT_CLICK_BLOCK))
            return;

        Block block = event.getClickedBlock();

        if (block == null || !block.getType().equals(Material.CAKE))
            return;

        Player player = event.getPlayer();

        if (player.getFoodLevel() == 20)
            return;

        Method[] methods = de.thedennsi.cakeplugin.events.EventHandler.class.getDeclaredMethods();
        Method method = methods[ThreadLocalRandom.current().nextInt(methods.length)];
        method.setAccessible(true);
        method.invoke(this.plugin.getEventHandler(), player);
    }
}
