package de.thedennsi.cakeplugin;

import de.thedennsi.cakeplugin.recipes.CakeRecipe;
import org.bukkit.Location;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public class CakePlugin extends JavaPlugin {

    public ItemMeta cakeMeta;
    public ArrayList<Location> cakeLocations = new ArrayList<>();

    @Override
    public void onEnable() {
        this.init();
    }

    private void init() {
        CakeRecipe cakeRecipe = new CakeRecipe(this);
        this.cakeMeta = cakeRecipe.getItemMeta();
        // you probably need a time machine to see this
    }
}
