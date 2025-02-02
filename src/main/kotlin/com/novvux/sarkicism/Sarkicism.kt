package com.novvux.sarkicism

import com.novvux.sarkicism.attribute.AttributeManager
import com.novvux.sarkicism.block.ModBlocks
import com.novvux.sarkicism.command.ModCommands
import com.novvux.sarkicism.event.ReloadModifiersEvent
import net.minecraft.world.entity.player.Player
import net.neoforged.bus.EventBus
import net.neoforged.bus.api.Event
import net.neoforged.bus.api.SubscribeEvent
import net.neoforged.fml.common.EventBusSubscriber
import net.neoforged.fml.common.Mod
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent
import net.neoforged.fml.event.lifecycle.FMLDedicatedServerSetupEvent
import net.neoforged.neoforge.common.NeoForge
import net.neoforged.neoforge.event.RegisterCommandsEvent
import net.neoforged.neoforge.event.entity.player.PlayerEvent
import org.apache.logging.log4j.Level
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import thedarkcolour.kotlinforforge.neoforge.forge.MOD_BUS


/**
 * Main mod class.
 */
@Mod(Sarkicism.ID)
@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
object Sarkicism {
    const val ID = "sarkicism"

    // the logger for our mod
    val LOGGER: Logger = LogManager.getLogger(ID)
    // the event bus
    //val MOD_EVENT_BUS: EventBus = EventBus.builder().build()


    init {
        LOGGER.log(Level.INFO, "Какими судьбами ты тут? Ошибку ищешь?")

        // Register the KDeferredRegister to the mod-specific event bus
        ModBlocks.BLOCK_REGISTRY.register(MOD_BUS)
        //MOD_EVENT_BUS.register(YourEventHandler())

        // Generic bus listeners
        NeoForge.EVENT_BUS.addListener(::registerCommands)
        NeoForge.EVENT_BUS.addListener(::addAttributesOnJoin)
        NeoForge.EVENT_BUS.addListener(::reloadModifiers)

        // Mod-specific bus listeners
        //MOD_BUS.addListener(::reloadModifiers)
    }

    private fun registerCommands(event: RegisterCommandsEvent) { ModCommands.register(event.dispatcher) }
    // Attribute-related listeners
    private fun addAttributesOnJoin(event: PlayerEvent.PlayerLoggedInEvent) { AttributeManager.onPlayerLogin(event.entity)}
    private fun reloadModifiers(event: ReloadModifiersEvent) { AttributeManager.onModifiersReloaded(event.entity as Player) }

    /*    init {
        ModBlocks.BLOCK_REGISTRY.register(MOD_BUS)
        //MOD_EVENT_BUS.register(YourEventHandler())

        // Generic bus listeners
        NeoForge.EVENT_BUS.addListener(::registerCommands)
    }

    private fun registerCommands(event: RegisterCommandsEvent) { ModCommands.register(event.dispatcher) }
     */

    /**
     * This is used for initializing client specific
     * things such as renderers and keymaps
     * Fired on the mod specific event bus.
     */
    private fun onClientSetup(event: FMLClientSetupEvent) {

    }

    /**
     * Fired on the global Forge bus.
     */
    private fun onServerSetup(event: FMLDedicatedServerSetupEvent) {
    }

    @SubscribeEvent
    fun onCommonSetup(event: FMLCommonSetupEvent) {
    }
}
