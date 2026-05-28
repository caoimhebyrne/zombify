package dev.cbyrne.zombify.mixin;

import net.minecraft.world.entity.monster.zombie.Zombie;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.Difficulty;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(Zombie.class)
public class ZombieEntityMixin {
    /**
     * Ensures that a villager does not get killed when converting into a zombie villager
     */
    @Redirect(
        method = "killedEntity",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/server/level/ServerLevel;getDifficulty()Lnet/minecraft/world/Difficulty;"
        )
    )
    public Difficulty zombify$overwriteDifficulty(ServerLevel world) {
        return Difficulty.HARD;
    }
}
