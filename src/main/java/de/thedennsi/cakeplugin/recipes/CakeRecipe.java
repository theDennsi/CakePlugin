package de.thedennsi.cakeplugin.recipes;

import de.thedennsi.cakeplugin.CakePlugin;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

public class CakeRecipe {

    private final CakePlugin plugin;
    @Getter
    private final ItemMeta itemMeta;

    public CakeRecipe(CakePlugin plugin) {
        this.plugin = plugin;

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);

        ItemMeta meta = item.getItemMeta();

        assert meta != null;
        meta.setDisplayName(ChatColor.GREEN + "Emerald Sword");
        meta.addEnchant(Enchantment.ARROW_DAMAGE, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        item.setItemMeta(meta);

        item.addEnchantment(Enchantment.DAMAGE_ALL, 5);


        /*
        diamondBlock  witherRose   diamondBlock
        goldBlock  cake          goldBlock
        goldBlock  goldBlock     goldBlock
        */
        NamespacedKey key = new NamespacedKey(this.plugin, "emerald_sword");

        ShapedRecipe recipe = new ShapedRecipe(key, item);

        recipe.shape("ABA ", "CDC", "CCC");

        recipe.setIngredient('A', Material.DIAMOND_BLOCK);
        recipe.setIngredient('B', Material.WITHER_ROSE);
        recipe.setIngredient('C', Material.CAKE);
        recipe.setIngredient('D', Material.GOLD_BLOCK);
        this.itemMeta = meta;
        Bukkit.addRecipe(recipe);
    }
}
