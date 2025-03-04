package com.novvux.sarkicism.block

import com.novvux.sarkicism.Sarkicism
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.state.BlockBehaviour
import net.neoforged.neoforge.registries.DeferredRegister

// THIS LINE IS REQUIRED FOR USING PROPERTY DELEGATES
import thedarkcolour.kotlinforforge.neoforge.forge.getValue

object ModBlocks {
    val BLOCK_REGISTRY = DeferredRegister.createBlocks(Sarkicism.ID)

    // If you get an "overload resolution ambiguity" error, include the arrow at the start of the closure.
    //val EXAMPLE_BLOCK by BLOCK_REGISTRY.register("example_block") { ->
    //    Block(BlockBehaviour.Properties.of().lightLevel { 15 }.strength(3.0f))
    //}
}
