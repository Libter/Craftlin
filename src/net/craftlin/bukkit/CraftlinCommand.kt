package net.craftlin.bukkit

import net.craftlin.api.misc.Stoppable
import net.craftlin.api.util.Logger
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender

class CraftlinCommand: CommandExecutor {

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<String>): Boolean {
        execute(sender, if (args.isEmpty()) null else args[0])
        return true
    }

    private fun execute(sender: CommandSender, action: String?) {
        when {
            action == "reload" && sender.hasPermission("craftlin") -> {
                Logger.reset()
                Stoppable.reset()
                BukkitCraftlin.listener.handlers.clear()
                BukkitCraftlin.commands.clear()
                BukkitCraftlin.loadScripts()
                sender.sendMessage("§6Craftlin» §aScripts have been reloaded!")
            }
            else -> sender.sendMessage("§6Craftlin» §aⓒ Libter Company 2018")
        }
    }

}