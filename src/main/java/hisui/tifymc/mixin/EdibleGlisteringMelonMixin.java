package hisui.tifymc.mixin;

import hisui.tifymc.annotation.ConfigurableMixin;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.FoodComponents;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.Slice;

@Mixin(Items.class)
@ConfigurableMixin(configOption = "edibleGlisteringMelon")
public class EdibleGlisteringMelonMixin {
	@ModifyArg(
		method = "<clinit>",
		slice = @Slice(
				from = @At(value="CONSTANT", args = "stringValue=glistering_melon_slice")
		),
		at = @At(value = "INVOKE", target = "net/minecraft/item/Item.<init>(Lnet/minecraft/item/Item$Settings;)V", ordinal = 0)
	)
	private static Item.Settings tifymc$makeGlisteringMelonEdible(Item.Settings vanilla) {
		return vanilla.food(new FoodComponent.Builder().hunger(6).saturationModifier(1.2F).statusEffect(
				new StatusEffectInstance(StatusEffects.INSTANT_HEALTH, 1), 1.0f).build());
	}
}