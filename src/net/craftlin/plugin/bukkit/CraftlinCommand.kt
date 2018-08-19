package net.craftlin.plugin.bukkit

import net.craftlin.plugin.api.misc.Stoppable
import net.craftlin.plugin.api.util.Logger
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender

class CraftlinCommand: CommandExecutor {

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<String>): Boolean {
        if (!sender.hasPermission("craftlin")) return false
        execute(sender, if (args.isEmpty()) null else args[0])
        return true
    }

    fun execute(sender: CommandSender, action: String?) {
        if (action == null) {
            sender.sendMessage("§6Craftlin» §aⓒ Libter Company 2018")
        } else when (action) {
            "reload" -> {
                Logger.reset()
                Stoppable.reset()
                BukkitCraftlin.listener.handlers.clear()
                BukkitCraftlin.loadScripts()
                sender.sendMessage("§6Craftlin» §aScripts have been reloaded!")
            }
        }
    }

}