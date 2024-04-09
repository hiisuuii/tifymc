package hisui.tifymc.mixin;

import hisui.tifymc.annotation.ConfigurableMixin;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(Items.class)
@ConfigurableMixin(configName="edibleBrownMushroom")
public abstract class EdibleBrownMushroomMixin {

    @ModifyArg(
            method = "register(Lnet/minecraft/block/Block;)Lnet/minecraft/item/Item;",
            at = @At(value="INVOKE",target = "Lnet/minecraft/item/BlockItem;<init>(Lnet/minecraft/block/Block;Lnet/minecraft/item/Item$Settings;)V")
    )
    private static Item.Settings tifymc$makeBrownMushroomEdible(Block block, Item.Settings original){
        if(block == Blocks.BROWN_MUSHROOM){
            return original.food(new FoodComponent.Builder().hunger(2).saturationModifier(0).statusEffect(
                    new StatusEffectInstance(StatusEffects.SLOWNESS, 120, 1), 1).statusEffect(
                    new StatusEffectInstance(StatusEffects.NAUSEA, 200), 1).build()
            );
        }
        return original;
    }

}
