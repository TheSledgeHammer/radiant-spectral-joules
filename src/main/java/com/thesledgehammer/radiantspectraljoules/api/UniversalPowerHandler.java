/*
 * Copyright (c) 2020 TheSledgeHammer.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser Public License v3
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/lgpl-3.0.txt
 */

package com.thesledgehammer.radiantspectraljoules.api;

import net.minecraft.util.EnumFacing;

/**
 * An Internal abstract implementation of IUniversalPowerProvider, IUniversalPowerReceiver, IUniversalPowerConnect.
 * Implemented within all non item energy wrappers. A single access point to be within any TileEntity wishing to use
 * the provided energy compatibility or implement their own.
 * @author TheSledgeHammer
 */
public abstract class UniversalPowerHandler implements IUniversalPowerProvider, IUniversalPowerReceiver, IUniversalPowerConnect {

	@Override
	public abstract boolean canConnectUniversalPower(EnumFacing from);

	@Override
	public abstract double receiveUniversalPower(EnumFacing from, double maxReceive, boolean simulate);
	
	@Override
	public abstract boolean canReceiveUniversalPower();
	
	@Override
	public abstract double extractUniversalPower(EnumFacing from, double maxExtract, boolean simulate);
	
	@Override
	public abstract boolean canExtractUniversalPower();	
}
