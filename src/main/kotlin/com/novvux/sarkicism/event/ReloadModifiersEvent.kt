package com.novvux.sarkicism.event

import net.minecraft.world.entity.player.Inventory
import net.minecraft.world.entity.player.Player
import net.minecraft.world.level.Level
import net.neoforged.bus.api.ICancellableEvent
import net.neoforged.neoforge.event.entity.EntityEvent

class ReloadModifiersEvent(player: Player, val level: Level, inventory: Inventory): EntityEvent(player), ICancellableEvent