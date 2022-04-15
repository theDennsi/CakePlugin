package de.thedennsi.cakeplugin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class TriggerEventCommand implements CommandExecutor, TabCompleter {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        List<String> list = new ArrayList<>();
        Method[] methods = de.thedennsi.cakeplugin.events.EventHandler.class.getDeclaredMethods();
        for (Method method : methods) {
            list.add(method.getName());
        }
        return list;
    }
}
