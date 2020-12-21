package dev.sapphic.streamermode;

import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(SoundInstance.class)
interface SoundBlockingMixin {
  @Shadow
  ResourceLocation getLocation();

  /**
   * Currently just mutes Pigstep by Lena Raine, a record known to result in DMCA strikes,
   * but will be expanded upon in the future if more problematic sounds arise.
   *
   * @reason Mixin prohibits Injectors in interfaces, so we overwrite the method instead
   * @author Chloe Dawn
   */
  @Overwrite
  default boolean canPlaySound() {
    return !SoundEvents.MUSIC_DISC_PIGSTEP.getLocation().equals(this.getLocation());
  }
}
