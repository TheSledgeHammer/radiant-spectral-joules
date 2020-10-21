/*
 * Copyright (c) 2020 TheSledgeHammer.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser Public License v3
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/lgpl-3.0.txt
 */

package com.thesledgehammer.radiantspectraljoules.spectraljoules;

import com.thesledgehammer.radiantspectraljoules.capabilities.CapabilityRegister;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.INBTSerializable;

public class SjCapabilityProvider implements INBTSerializable<NBTTagCompound>, ICapabilityProvider {
	
	private final SjStorage container;
	
	public SjCapabilityProvider(SjStorage container) {
		this.container = container;
	}
	
	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		return capability == CapabilityRegister.SPECTRAL_JOULES_STORAGE;
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
		if(capability == CapabilityRegister.SPECTRAL_JOULES_STORAGE) {
			return CapabilityRegister.SPECTRAL_JOULES_STORAGE.cast(container);
		}
		return null;
	}

	@Override
	public NBTTagCompound serializeNBT() {
		if(container != null) {
			return this.container.serializeNBT();
		}
		return null;
	}

	@Override
	public void deserializeNBT(NBTTagCompound nbt) {
		this.container.deserializeNBT(nbt);
	}
}
