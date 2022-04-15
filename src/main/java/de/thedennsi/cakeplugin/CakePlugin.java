package de.thedennsi.cakeplugin;

import de.thedennsi.cakeplugin.commands.TriggerEventCommand;
import de.thedennsi.cakeplugin.events.EventHandler;
import de.thedennsi.cakeplugin.listeners.PlayerInteractListener;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public class CakePlugin extends JavaPlugin {

    public ItemMeta cakeMeta;
    public ArrayList<Location> cakeLocations = new ArrayList<>();
    @Getter
    private final EventHandler eventHandler = new EventHandler(this);

    @Override
    public void onEnable() {

        this.getCommand("triggerevent").setExecutor(new TriggerEventCommand(this));
        Bukkit.getPluginManager().registerEvents(new PlayerInteractListener(this), this);
    }

}
