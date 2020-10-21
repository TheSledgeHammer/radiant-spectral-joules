/*
 * Copyright (c) 2020 TheSledgeHammer.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser Public License v3
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/lgpl-3.0.txt
 */

package com.thesledgehammer.radiantspectraljoules.radiantjoules;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;

public class RjCapability {
	
	public static class RJStorageProvider<T extends IRjStorage> implements IStorage<IRjStorage> {

		@Override
		public NBTBase writeNBT(Capability<IRjStorage> capability, IRjStorage instance, EnumFacing side) {
			return null;
		}

		@Override
		public void readNBT(Capability<IRjStorage> capability, IRjStorage instance, EnumFacing side, NBTBase nbt) {
			
		}
	}
	
	public static class RJItemProvider<T extends IRjContainerItem> implements IStorage<IRjContainerItem> {

		@Override
		public NBTBase writeNBT(Capability<IRjContainerItem> capability, IRjContainerItem instance, EnumFacing side) {
			return null;
		}

		@Override
		public void readNBT(Capability<IRjContainerItem> capability, IRjContainerItem instance, EnumFacing side, NBTBase nbt) {
			
		}
	}
}
