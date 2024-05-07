package com.tiptow;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPortalEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {
    private boolean portalUsageEnabled = false;

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (label.equalsIgnoreCase("enableportals")) {
            if (sender.hasPermission("portalcontrol.enable")) {
                enablePortals();
                sender.sendMessage(ChatColor.GREEN + "Portals have been enabled.");
            } else {
                sender.sendMessage(ChatColor.RED + "You don't have permission to enable portals.");
            }
            return true;
        } else if (label.equalsIgnoreCase("disableportals")) {
            if (sender.hasPermission("portalcontrol.disable")) {
                disablePortals();
                sender.sendMessage(ChatColor.RED + "Portals have been disabled.");
            } else {
                sender.sendMessage(ChatColor.RED + "You don't have permission to disable portals.");
            }
            return true;
        }
        return false;
    }

    @EventHandler
    public void onPlayerPortal(PlayerPortalEvent event) {
        if (!portalUsageEnabled) {
            if (!event.getFrom().getWorld().getName().equalsIgnoreCase("world_the_end")) {
                // Block portals other than end gateways
                event.setCancelled(true);
                event.getPlayer().sendMessage(ChatColor.RED + "Portal usage is currently disabled.");
            }
        }
    }

    private void enablePortals() {
        portalUsageEnabled = true;
        getLogger().info(ChatColor.GREEN + "Portals have been enabled.");
    }

    private void disablePortals() {
        portalUsageEnabled = false;
        getLogger().info(ChatColor.RED + "Portals have been disabled.");
    }
}
