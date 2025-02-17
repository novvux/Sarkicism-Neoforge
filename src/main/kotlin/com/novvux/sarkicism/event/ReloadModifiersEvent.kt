package com.novvux.sarkicism.event

import net.minecraft.world.entity.player.Player
import net.neoforged.bus.api.ICancellableEvent
import net.neoforged.neoforge.event.entity.EntityEvent

class ReloadModifiersEvent(player: Player): EntityEvent(player), ICancellableEvent