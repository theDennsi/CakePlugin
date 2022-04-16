package de.thedennsi.cakeplugin.events;

import de.thedennsi.cakeplugin.CakePlugin;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Timer;
import java.util.TimerTask;

public class EventHandler {

    private final CakePlugin plugin;

    public EventHandler(CakePlugin plugin) {
        this.plugin = plugin;
    }

    public void tntEvent(Player player) {

            new Timer().schedule(new TimerTask() {
                private int i = 0;

                @Override
                public void run() {
                    if (this.i == 11)
                        this.cancel();
                    Bukkit.getScheduler().runTask(EventHandler.this.plugin, () -> player.getWorld().spawnEntity(player.getLocation(), EntityType.PRIMED_TNT));
                    this.i++;
                }
            }, 0, 1000);
    }

    public void diamondSprinkler(Player player) {


            new Timer().schedule(new TimerTask() {
                private int i = 0;

                @Override
                public void run() {
                    if (this.i == 11)
                        this.cancel();
                    Bukkit.getScheduler().runTask(EventHandler.this.plugin, () ->player.getWorld().dropItem(player.getLocation(), new ItemStack(Material.DIAMOND)));
                    this.i++;
                }
            }, 0, 200);

    }

    public void waterMlg(Player player) {
        Location loc = player.getLocation();
        player.teleport(new Location(loc.getWorld(), loc.getX(), loc.getY() + 200, loc.getZ()));
        player.getInventory().setHeldItemSlot(8);
        player.getInventory().setItem(8, new ItemStack(Material.WATER_BUCKET));
    }


}
