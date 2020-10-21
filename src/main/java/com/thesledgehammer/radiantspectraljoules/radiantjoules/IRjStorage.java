/*
 * Copyright (c) 2020 TheSledgeHammer.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser Public License v3
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/lgpl-3.0.txt
 */

package com.thesledgehammer.radiantspectraljoules.radiantjoules;

public interface IRjStorage {
	
	double receivePower(double maxReceive, boolean simulate);
	
	double extractPower(double maxExtract, boolean simulate);
	
	double getMaxPowerStored();
	
	double getPowerStored();
	
	boolean canExtract();
	
	boolean canReceive();
	
	public double getEUPower(int index);
	
	public double getTRPower(int index);
	
	public int getRFPower(int index);
	
	public long getMJPower(int index);
	
	public long getTESLAPower(int index);
}
