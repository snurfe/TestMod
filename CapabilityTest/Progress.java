package com.shiftman3.mineplspls.CapabilityTest;

public class Progress implements IProgress {

	private int deathStatus = 0;

	@Override
	public final int getStatus() {
		return deathStatus;
	}

	@Override
	public final void setStatus(final int died) {
		this.deathStatus = died;
	}
}