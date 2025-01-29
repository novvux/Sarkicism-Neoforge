package com.novvux.sarkicism.client

import com.novvux.sarkicism.Sarkicism
import net.minecraft.client.KeyMapping
import net.neoforged.api.distmarker.Dist
import net.neoforged.bus.api.SubscribeEvent
import net.neoforged.fml.common.EventBusSubscriber
import net.neoforged.fml.common.Mod
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent

@Mod(value = Sarkicism.ID, dist = [Dist.CLIENT])
@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
object SarkicismClient {
    // In some physical client only class
    /*
    // Key mapping is lazily initialized so it doesn't exist until it is registered
    val MAPPING: Lazy<KeyMapping> = Lazy.of(() -> )


    // Event is on the mod event bus only on the physical client
    @SubscribeEvent
    fun registerBindings(event: RegisterKeyMappingsEvent) {
        event.register(MAPPING.get())
    }
    */
}