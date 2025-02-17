package com.novvux.sarkicism.attribute

import com.novvux.sarkicism.Sarkicism
import net.minecraft.core.Holder
import net.minecraft.nbt.CompoundTag
import net.minecraft.resources.ResourceLocation
import net.minecraft.tags.ItemTags
import net.minecraft.world.InteractionHand
import net.minecraft.world.entity.ai.attributes.Attribute
import net.minecraft.world.entity.ai.attributes.AttributeInstance
import net.minecraft.world.entity.ai.attributes.AttributeModifier
import net.minecraft.world.entity.ai.attributes.Attributes
import net.minecraft.world.entity.player.Player

class AttributeManager {
    /*init {
        NeoForge.EVENT_BUS.register(this)
    }*/

    companion object {
        val modifier = ItemTags.create(ResourceLocation.fromNamespaceAndPath("minecraft","wool"))//ResourceLocation.fromNamespaceAndPath(Sarkicism.ID, "modifier"))
        private fun recalculateModifiers(player: Player) {
            val record = player.getItemInHand(InteractionHand.MAIN_HAND)
            if (record.`is`(modifier)) {
                applyModifier(player, ResourceLocation.fromNamespaceAndPath(Sarkicism.ID, "movement_speed"), Attributes.MOVEMENT_SPEED)
            }
            else {
                removeModifier(player, ResourceLocation.fromNamespaceAndPath(Sarkicism.ID, "movement_speed"), Attributes.MOVEMENT_SPEED)
            }
        }

        private fun applyModifier(player: Player, key: ResourceLocation, attribute: Holder<Attribute>) {
            val data: CompoundTag = player.persistentData

            if (!data.getBoolean(key.toString())) {
                val attr: AttributeInstance? = player.getAttribute(attribute)
                if (attr != null) {
                    data.putBoolean(key.toString(), true)
                    attr.addPermanentModifier(AttributeModifier(key, 0.5, AttributeModifier.Operation.ADD_MULTIPLIED_BASE))
                }
            }
        }

        private fun removeModifier(player: Player, key: ResourceLocation, attribute: Holder<Attribute>) {
            val data: CompoundTag = player.persistentData

            if (data.getBoolean(key.toString())) {
                val attr: AttributeInstance? = player.getAttribute(attribute)
                if (attr != null) {
                    data.putBoolean(key.toString(), false)
                    attr.removeModifier(key)
                }
            }
        }

        fun onPlayerLogin(entity: Player) {
            if (!entity.level().isClientSide()) { // Server-side only
                val player = entity
                recalculateModifiers(player)
            }
        }

        fun onModifiersReloaded(entity: Player) {
            if (!entity.level().isClientSide()) { // Server-side only
                val player = entity
                recalculateModifiers(player)
            }
        }
    }
}

/*@EventBusSubscriber(modid = Sarkicism.ID)
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
}
 */