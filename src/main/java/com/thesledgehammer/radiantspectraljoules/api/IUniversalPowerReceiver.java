/*
 * Copyright (c) 2020 TheSledgeHammer.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser Public License v3
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/lgpl-3.0.txt
 */

package com.thesledgehammer.radiantspectraljoules.api;

import net.minecraft.util.EnumFacing;

public interface IUniversalPowerReceiver {
	
	double receiveUniversalPower(EnumFacing from, double maxReceive, boolean simulate);
	
	boolean canReceiveUniversalPower();
}
