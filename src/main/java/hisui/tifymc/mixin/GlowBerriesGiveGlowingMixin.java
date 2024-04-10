package hisui.tifymc.mixin;

import hisui.tifymc.annotation.ConfigurableMixin;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.FoodComponents;
import net.minecraft.item.Item;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;

@Mixin(FoodComponents.class)
@ConfigurableMixin(configName = "glowingGlowBerries")
public class GlowBerriesGiveGlowingMixin {

    // TODO
}
