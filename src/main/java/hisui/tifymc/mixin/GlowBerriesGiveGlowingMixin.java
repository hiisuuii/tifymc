package hisui.tifymc.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import hisui.tifymc.annotation.ConfigurableMixin;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.FoodComponents;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Debug;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Slice;

@Mixin(FoodComponents.class)
@ConfigurableMixin(configName = "glowingGlowBerries")
public class GlowBerriesGiveGlowingMixin {

    // TODO
    @ModifyExpressionValue(method = "<clinit>",
            slice = @Slice(
                    from = @At(value = "FIELD",
                    target = "Lnet/minecraft/item/FoodComponents;SWEET_BERRIES:Lnet/minecraft/item/FoodComponent;",
                            opcode = Opcodes.PUTSTATIC, ordinal = 0)),
            at = @At(value = "INVOKE",
                    target = "Lnet/minecraft/item/FoodComponent$Builder;saturationModifier(F)Lnet/minecraft/item/FoodComponent$Builder;",
                    ordinal = 0))
    private static FoodComponent.Builder tifymc$glowBerriesGiveGlowing(FoodComponent.Builder original){
        return original.alwaysEdible().statusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 100), 1);
    }
}
