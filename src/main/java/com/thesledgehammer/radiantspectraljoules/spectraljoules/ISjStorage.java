/*
 * Copyright (c) 2020 TheSledgeHammer.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser Public License v3
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/lgpl-3.0.txt
 */

package com.thesledgehammer.radiantspectraljoules.spectraljoules;

import com.thesledgehammer.radiantspectraljoules.radiantjoules.IRjStorage;

public interface ISjStorage extends IRjStorage {
	
	double Wavelength();
	
	double Frequency();
	
	double Distance();
	
	double Cost();
	
	double TransferRate();

	boolean canTravelCrossDimensions();

	double Interference();
	
	boolean InSolidState();
	
	boolean InLiquidState();
	
	boolean InGasState();
	
	boolean InPlasmaState();
}
