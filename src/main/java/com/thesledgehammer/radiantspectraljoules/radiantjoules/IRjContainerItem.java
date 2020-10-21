/*
 * Copyright (c) 2020 TheSledgeHammer.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser Public License v3
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/lgpl-3.0.txt
 */

package com.thesledgehammer.radiantspectraljoules.radiantjoules;

import com.thesledgehammer.radiantspectraljoules.EnumEnergyTierIO;
import net.minecraft.item.ItemStack;

public interface IRjContainerItem {
	
	double receivePower(ItemStack container, double maxReceive, boolean simulate);
	
	double extractPower(ItemStack container, double maxExtract, boolean simulate);
	
	double getPowerStored(ItemStack container);
	
	double getMaxPowerStored(ItemStack container);
	
	boolean canReceive(ItemStack container);
	
	boolean canExtract(ItemStack container);
	
	EnumEnergyTierIO getEnergyTier(int index, ItemStack container);
	
	int getIC2Tier(ItemStack container);
	
	public double getEUPower(int index);
	
	public double getTRPower(int index);
	
	public int getRFPower(int index);
	
	public long getMJPower(int index);
	
	public long getTESLAPower(int index);
}
