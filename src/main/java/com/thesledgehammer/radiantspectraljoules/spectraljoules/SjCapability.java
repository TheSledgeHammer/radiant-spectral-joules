/*
 * Copyright (c) 2020 TheSledgeHammer.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser Public License v3
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/lgpl-3.0.txt
 */

package com.thesledgehammer.radiantspectraljoules.spectraljoules;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;

public class SjCapability {
	
	public static class SJStorageProvider<T extends ISjStorage> implements IStorage<ISjStorage> {

		@Override
		public NBTBase writeNBT(Capability<ISjStorage> capability, ISjStorage instance, EnumFacing side) {
			return null;
		}

		@Override
		public void readNBT(Capability<ISjStorage> capability, ISjStorage instance, EnumFacing side, NBTBase nbt) {
			
		}
	}
}
