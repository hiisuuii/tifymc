package hisui.tifymc.mixin;

import net.minecraft.block.FacingBlock;
import net.minecraft.block.PistonBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Slice;

@Mixin(PistonBlock.class)
public abstract class PistonClunkSoundMixin extends FacingBlock {
    protected PistonClunkSoundMixin(Settings settings) {
        super(settings);
    }

    // TODO Fix this
    @Inject(method = "onSyncedBlockEvent", slice =
    @Slice(from =
                @At(value = "INVOKE",
                        target = "Lnet/minecraft/block/PistonBlock;shouldExtend(Lnet/minecraft/world/RedstoneView;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/util/math/Direction;)Z"),
            to =
                @At(value = "INVOKE",
                        target = "Lnet/minecraft/block/PistonBlock;move(Lnet/minecraft/world/World;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/util/math/Direction;Z)Z")
        ), at = @At("RETURN")
    )

}
