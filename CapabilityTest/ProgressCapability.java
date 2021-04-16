package com.shiftman3.mineplspls.CapabilityTest;

import com.shiftman3.mineplspls.Mineplspls;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerEvent.PlayerLoggedInEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ProgressCapability {
	@CapabilityInject(IProgress.class)
	public static final Capability<IProgress> DEATHSTATUS = null;
	
	public static final ResourceLocation ID = new ResourceLocation(Mineplspls.MOD_ID, "MPP");

	public static void register() {
		CapabilityManager.INSTANCE.register(IProgress.class, new Capability.IStorage<IProgress>() {
			@Override
			public INBT writeNBT(final Capability<IProgress> capability, final IProgress instance, final Direction side) {
	            CompoundNBT tag = new CompoundNBT();
	            tag.putInt("deathStatus", instance.getStatus());
	            return tag;
			}
			@Override
			public void readNBT(final Capability<IProgress> capability, final IProgress instance, final Direction side, final INBT nbt) {
				instance.setStatus(((CompoundNBT) nbt).getInt("deathStatus"));
			}
		}, () -> new Progress());
	}

	@SuppressWarnings("unused")
	private static class EventHandler {

		@SubscribeEvent
		public static void attachCapabilities(final AttachCapabilitiesEvent<Entity> event) {
			if (event.getObject() instanceof PlayerEntity) {
			}
		}

		@SubscribeEvent
		public static void playerClone(final PlayerEvent.Clone event) {
		}
		@SubscribeEvent
		public static void playerChangeDimension(final PlayerEvent.PlayerChangedDimensionEvent event) {
		}
		@SubscribeEvent
		public static void onPlayerConnect(PlayerLoggedInEvent event) {
		}
	}
}
