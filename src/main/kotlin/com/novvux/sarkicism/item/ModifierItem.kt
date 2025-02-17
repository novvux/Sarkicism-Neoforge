package com.novvux.sarkicism.item

import com.novvux.sarkicism.api.item.IModifier
import com.novvux.sarkicism.api.item.IModifier.EnumSlot
import net.minecraft.world.entity.LivingEntity
import net.minecraft.world.item.Item
import net.minecraft.world.item.ItemStack

class ModifierItem(name: String, private val slots: Array<EnumSlot>, subnames: Array<String>, properties: Properties): Item(properties), IModifier { //, IDeconstructable {
    // TODO REIMPLEMENT SLOTS, COMPATIBILITY

    override fun installedStackSize(stack: ItemStack): Int {
        return 1
    }

    // TODO REIMLEMENT DESCRIPTION

    override fun onAdded(entity: LivingEntity, stack: ItemStack) {}

    override fun onRemoved(entity: LivingEntity, stack: ItemStack) {}
}