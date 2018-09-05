package net.craftlin.bukkit

import net.craftlin.api.Variables
import net.craftlin.api.command.Command
import net.craftlin.api.command.CommandCustomException
import net.craftlin.api.command.CommandUsageException
import net.craftlin.api.misc.Timer
import net.craftlin.api.misc.emptyF
import net.craftlin.api.misc.thisF
import net.craftlin.api.util.Listener
import net.craftlin.api.util.chat
import net.craftlin.bukkit.impl.BukkitServer
import net.craftlin.bukkit.impl.command.BukkitCommandContext
import net.craftlin.bukkit.impl.misc.BukkitTask
import net.craftlin.bukkit.impl.misc.BukkitTimer
import org.bukkit.Bukkit
import org.bukkit.command.CommandMap
import org.bukkit.command.CommandSender
import org.bukkit.command.defaults.BukkitCommand
import org.bukkit.plugin.java.JavaPlugin

class BukkitVariables(private val plugin: JavaPlugin, listener: Listener): Variables(listener) {

    private val bukkitCommandMap: CommandMap by lazy {
        val field = Bukkit.getServer().javaClass.getDeclaredField("commandMap")
        if (!field.isAccessible) field.isAccessible = true
        field.get(Bukkit.getServer()) as CommandMap
    }

    override val command = fun (definition: String, callback: thisF<BukkitCommandContext>) {
        //TODO: Don't use crappy org.bukkit.command.CommandMap, listen for command preprocess instead and allow definition to start with any char
        if (!definition.startsWith("/")) throw IllegalArgumentException("Command definition must start with '/'")
        if (definition.drop(1).isBlank()) throw IllegalArgumentException("Command name must have at least one character")
        val _command = Command(definition.drop(1), callback)
        val bukkitCommand = object: BukkitCommand(_command.name) {
            private val craftlinCommand = _command
            //TODO: Move error handling to API
            override fun execute(sender: CommandSender, commandLabel: String, args: Array<String>): Boolean {
                try {
                    _command.executor(BukkitCommandContext(craftlinCommand, sender, args))
                } catch (e: CommandUsageException) {
                    sender.sendMessage("Usage: $definition")
                } catch (e: CommandCustomException) {
                    sender.sendMessage(e.message.chat)
                }
                return true
            }
        }
        bukkitCommandMap.register("clscript", bukkitCommand)
    }
    override val server = BukkitServer
    override val sync = fun(callback: emptyF) { BukkitTask(callback).runTask(plugin) }
    override val async = fun(callback: emptyF) { BukkitTask(callback).runTaskAsynchronously(plugin) }
    override val delay = fun(time: Long, callback: emptyF) { BukkitTask(callback).runTaskLater(plugin, time) }
    override val delayAsync = fun(time: Long, callback: emptyF) { BukkitTask(callback).runTaskLaterAsynchronously(plugin, time) }
    override val timer = fun(time: Long, callback: thisF<Timer>) { BukkitTimer(callback).runTaskTimer(plugin, 0, time) }
    override val timerAsync = fun(time: Long, callback: thisF<Timer>) { BukkitTimer(callback).runTaskTimerAsynchronously(plugin, 0, time) }

}