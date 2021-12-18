package dev.cbyrne.zombify.mixin;

import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.Difficulty;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ZombieEntity.class)
public class ZombieEntityMixin {
    /**
     * Ensures that a villager does not get killed when converting into a zombie villager
     */
    @Redirect(
        method = "onKilledOther",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/server/world/ServerWorld;getDifficulty()Lnet/minecraft/world/Difficulty;"
        )
    )
    public Difficulty zombify$overwriteDifficulty(ServerWorld world) {
        return Difficulty.HARD;
    }
}
