package com.novvux.sarkicism.api.item

import net.minecraft.world.entity.LivingEntity
import net.minecraft.world.item.ItemStack

interface IModifier {
    //fun getSlot(stack: ItemStack): EnumSlot
    fun installedStackSize(stack: ItemStack): Int
    //fun required(stack: ItemStack): Array<Array<ItemStack?>>
    //fun isIncompatible(stack: ItemStack, comparison: ItemStack): Boolean
    //fun isEssential(stack: ItemStack): Boolean
    //fun getInfo(stack: ItemStack): List<String>
    //fun getCapacity(wareStack: ItemStack): Int

    enum class EnumSlot(val slotNumber: Byte, val id: String) {
        EYES(12, "eyes"),
        CRANIUM(11, "cranium"),
        HEART(14, "heart"),
        LUNGS(15, "lungs"),
        LOWER_ORGANS(17, "lowerOrgans"),
        SKIN(18, "skin"),
        MUSCLE(19, "muscle"),
        BONE(20, "bone"),
        ARM(21, "arm"),
        HAND(22, "hand"),
        LEG(23, "leg"),
        FOOT(24, "foot");
    }

    fun onAdded(entity: LivingEntity, stack: ItemStack)
    fun onRemoved(entity: LivingEntity, stack: ItemStack)
}