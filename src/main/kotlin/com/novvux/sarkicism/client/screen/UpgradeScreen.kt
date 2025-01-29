package com.novvux.sarkicism.client.screen

import com.novvux.sarkicism.Sarkicism
import io.wispforest.owo.ui.base.BaseUIModelScreen
import io.wispforest.owo.ui.component.ButtonComponent
import io.wispforest.owo.ui.container.FlowLayout
import net.minecraft.resources.ResourceLocation

class UpgradeScreen: BaseUIModelScreen<FlowLayout>(FlowLayout::class.java, DataSource.asset(ResourceLocation.fromNamespaceAndPath(Sarkicism.ID, "upgrade_screen_model"))) {

    override fun build(rootComponent: FlowLayout) {
        rootComponent.childById(ButtonComponent::class.java, "the-button").onPress { button ->
            println("click")
        }
    }
}