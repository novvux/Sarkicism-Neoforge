package com.novvux.sarkicism.command

import com.mojang.brigadier.CommandDispatcher
import com.mojang.brigadier.context.CommandContext
import com.mojang.brigadier.exceptions.CommandSyntaxException
import com.novvux.sarkicism.Sarkicism
import com.novvux.sarkicism.event.ReloadModifiersEvent
import net.minecraft.network.chat.Component
import net.minecraft.commands.CommandSourceStack
import net.minecraft.commands.Commands.literal
import net.neoforged.neoforge.common.NeoForge
import thedarkcolour.kotlinforforge.neoforge.forge.MOD_BUS

class ModCommands {
    companion object {
        fun register(dispatcher: CommandDispatcher<CommandSourceStack>): Int {
            dispatcher.register(
                literal("sarkicism")
                    .requires { source: CommandSourceStack -> source.hasPermission(3) }
                        .then(literal("reload").executes { context: CommandContext<CommandSourceStack> -> reload(context.source) })
            )

            return 1
        }

        @Throws(CommandSyntaxException::class)
        private fun reload(src: CommandSourceStack): Int {
            try {
                val player = src.playerOrException
                NeoForge.EVENT_BUS.post(ReloadModifiersEvent(player, src.level, player.inventory))
                src.source.sendSystemMessage(Component.translatable("command.sarkicism.reload.success"))
            } catch (e: Exception) {
                src.source.sendSystemMessage(Component.translatable("command.sarkicism.reload.failure"))
                src.source.sendSystemMessage(Component.literal(e.toString()))
            }

            return 1
        }
    }
}