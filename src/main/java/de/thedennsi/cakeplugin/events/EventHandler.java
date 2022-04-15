package de.thedennsi.cakeplugin.events;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Timer;
import java.util.TimerTask;

public class EventHandler {

    public void tntEvent(Player player) {

        new Timer().schedule(new TimerTask() {
            private int i = 0;

            @Override
            public void run() {
                if (this.i == 11)
                    this.cancel();
                player.getWorld().spawnEntity(player.getLocation(), EntityType.PRIMED_TNT);
                this.i++;
            }
        }, 0, 1000);


//        Bukkit.getScheduler().runTaskLater(CakePlugin.getPlugin(CakePlugin.class), () -> Bukkit.getScheduler()
//                .cancelTask(Bukkit.getScheduler().scheduleSyncRepeatingTask(CakePlugin.getPlugin(CakePlugin.class),
//                        () -> player.getWorld().spawnEntity(player.getLocation(), EntityType.PRIMED_TNT),
//                        0, 20)), 5 * 20);
    }

    public void diamondSprinkler(Player player) {

        new Timer().schedule(new TimerTask() {
            private int i = 0;

            @Override
            public void run() {
                if (this.i == 11)
                    this.cancel();
                player.getWorld().dropItem(player.getLocation(), new ItemStack(Material.DIAMOND));
                this.i++;
            }
        }, 0, 200);
    }

    public void waterMlg(Player player) {
        Location loc = player.getLocation();
        player.teleport(new Location(loc.getWorld(), loc.getX(), loc.getY() + 200, loc.getZ()));
        player.getInventory().setHeldItemSlot(8);
        player.getInventory().setItem(44, new ItemStack(Material.WATER_BUCKET));
    }
}
