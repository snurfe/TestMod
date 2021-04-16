package com.shiftman3.mineplspls.player;

import com.shiftman3.mineplspls.Mineplspls;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Mineplspls.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class Revival {

	  @SubscribeEvent
	  public void onLivingDeath(LivingDeathEvent event) {
		    if (canRevive(event.getEntityLiving(), event.getSource()) && event.getEntity() instanceof PlayerEntity) {
		    	event.setCanceled(true);
		    }
	  }

	  private boolean canRevive(LivingEntity livingEntity, DamageSource source) {
		    if (source.canHarmInCreative()) {
		      return false;
		    }
		    this.Revive(livingEntity);
		    return true;
	  }

	  private void Revive(LivingEntity livingEntity) {
	    livingEntity.setHealth(1.0F);
	    livingEntity.clearActivePotions();
	    livingEntity.addPotionEffect(new EffectInstance(Effects.REGENERATION, 900, 1));
	    livingEntity.addPotionEffect(new EffectInstance(Effects.ABSORPTION, 100, 1));
	  }
}
