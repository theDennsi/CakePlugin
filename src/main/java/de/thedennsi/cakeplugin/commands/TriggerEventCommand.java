package de.thedennsi.cakeplugin.commands;

import de.thedennsi.cakeplugin.CakePlugin;
import de.thedennsi.cakeplugin.events.EventHandler;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TriggerEventCommand implements CommandExecutor, TabCompleter {

    private final CakePlugin plugin;

    public TriggerEventCommand(CakePlugin plugin) {
        this.plugin = plugin;
    }

    private final Method[] methods = EventHandler.class.getDeclaredMethods();
    private final List<String> methodNames = Arrays.stream(this.methods).map(Method::getName).collect(Collectors.toList());

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player player)) {
            sender.sendMessage("Du musst ein Spieler sein um diesen Befehl benutzen zu können");
            return true;
        }

        Optional<Method> optionalMethod = Arrays.stream(this.methods).filter(method -> method.getName().equalsIgnoreCase(args[0])).findFirst();

        if (optionalMethod.isEmpty()) {
            player.sendMessage("Dieses Event gibt es nicht.");
            return true;
        }

        try {
            optionalMethod.get().invoke(this.plugin.getEventHandler(), player);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {

        return this.methodNames;
    }
}
