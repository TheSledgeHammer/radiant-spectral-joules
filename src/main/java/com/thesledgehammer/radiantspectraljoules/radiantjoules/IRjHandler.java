/*
 * Copyright (c) 2020 TheSledgeHammer.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser Public License v3
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/lgpl-3.0.txt
 */

package com.thesledgehammer.radiantspectraljoules.radiantjoules;

import net.minecraft.util.EnumFacing;

public interface IRjHandler extends IRjConnection {
	
	double getPowerStored(EnumFacing from);
	
	double getMaxPowerStored(EnumFacing from);
}
