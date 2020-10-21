/*
 * Copyright (c) 2020 TheSledgeHammer.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser Public License v3
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/lgpl-3.0.txt
 */

package com.thesledgehammer.radiantspectraljoules.spectraljoules;

import com.thesledgehammer.radiantspectraljoules.radiantjoules.IRjContainerItem;
import net.minecraft.item.ItemStack;

public interface ISjContainerItem extends IRjContainerItem {
	
	EnumRadiationType getRadiationType(ItemStack container, EnumRadiationType radiation);
	
	EnumFrequency getFrequency(ItemStack container, int index);
	
	EnumWavelength getWavelength(ItemStack container, int index);
	
	double Frequency(ItemStack container);
	
	double Wavelength(ItemStack container);
	
	double Distance(ItemStack container);
	
	double Cost(ItemStack container);
	
	double TransferRate(ItemStack container);
	
	boolean canTravelCrossDimensions();
	
	double Interference();
}
