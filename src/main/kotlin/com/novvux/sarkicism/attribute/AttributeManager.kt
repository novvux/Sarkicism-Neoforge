package com.novvux.sarkicism.attribute

import com.novvux.sarkicism.Sarkicism
import com.novvux.sarkicism.event.ReloadModifiersEvent
import net.minecraft.world.InteractionHand
import net.minecraft.world.entity.player.Player
import net.neoforged.bus.api.SubscribeEvent
import net.neoforged.fml.common.EventBusSubscriber
import net.neoforged.neoforge.event.entity.player.PlayerEvent

@EventBusSubscriber(modid = Sarkicism.ID)
class AttributeManager {
    @SubscribeEvent
    fun onPlayerLogin(event: PlayerEvent.PlayerLoggedInEvent) {
        if (!event.entity.level().isClientSide()) {
            val player = event.entity
            val record = player.getItemInHand(InteractionHand.MAIN_HAND)
            player.addItem(record)
        }
    }

    @SubscribeEvent
    fun onModifiersReloaded(event: ReloadModifiersEvent) {
        println(event)
        if (!event.entity.level().isClientSide()) {
            val player = event.entity as Player
            val record = player.getItemInHand(InteractionHand.MAIN_HAND)
            player.addItem(record)
        }
    }

    /*@SubscribeEvent
    fun onEntityJoin(event: ModifiersChangedEvent) {
        if (event.entity is Player && !event.level.isClientSide()) {
            val player: Player = event.entity as Player
            val data: CompoundTag = player.persistentData
            val key = ResourceLocation.fromNamespaceAndPath(ID, "movement_speed")

            if (!data.getBoolean(key.toString())) {
                val speedAttr: AttributeInstance? = player.getAttribute(Attributes.MOVEMENT_SPEED)
                if (speedAttr != null) {
                    data.putBoolean(key.toString(), true)
                    speedAttr.addPermanentModifier(AttributeModifier(key, 0.5, AttributeModifier.Operation.ADD_MULTIPLIED_BASE))
                }
            }
        }
    }*/
}