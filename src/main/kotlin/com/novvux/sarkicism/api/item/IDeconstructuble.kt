package com.novvux.sarkicism.api.item

import net.minecraft.world.item.ItemStack


interface IDeconstructuble {
    fun canDestroy(stack: ItemStack): Boolean
    fun getComponents(stack: ItemStack): Array<ItemStack>
}