/*
 * Copyright (c) 2020 TheSledgeHammer.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser Public License v3
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/lgpl-3.0.txt
 */

package com.thesledgehammer.radiantspectraljoules;

import net.minecraft.util.IStringSerializable;

import java.util.Locale;

public enum EnumEnergyTierIO implements IStringSerializable {
	/**
	 * @param Tier Name, @param EU Energy, @param TechReborn Energy, @param RF Energy, @param (BC8)MJ Energy (Full Unit), @param Tesla Energy
	 * 
	 * Example:
	 * Your Energy Item or Tile Class Here
	 * this.tier.RFmaxIO(); 
	 * References the max RF energy Input & Output for that tier. 
	 */

	MICRO(0, 5, 8, 1024, 128000L, 1024L, 0),
	LOW(0, 32, 32, 4096, 524288L, 4096L, 1),
	MEDIUM(0, 128, 128, 8192, 1048576L, 8192L, 2),
	HIGH(10240, 512, 512, 16384, 2097152L, 16384L, 3),
	EXTREME(16384, 2048, 2048, 32768, 4194304L, 32768L, 4),
	INSANE(28672, 8192, 8192, 65536, 8388608L, 65536L, 5),
	INFINITE(Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE, Integer.MAX_VALUE, Long.MAX_VALUE, Long.MAX_VALUE, 6);
	
	public static final EnumEnergyTierIO[] VALUES = values();
	
	private final String name;
	private final double RJmaxIO;
	private final double EUmaxIO;
	private final int RFmaxIO;
	private final double TRmaxIO;
	private final long MJmaxIO;
	private final long TeslamaxIO;
	private final int IC2Tier;
	
	EnumEnergyTierIO(double RJmaxIO, double EUmaxIO, double TRmaxIO, int RFmaxIO, long MJmaxIO, long TeslamaxIO, int IC2Tier) {
		this.name = toString().toLowerCase(Locale.ENGLISH);
		this.RJmaxIO = RJmaxIO;
		this.EUmaxIO = EUmaxIO;
		this.TRmaxIO = TRmaxIO;
		this.RFmaxIO = RFmaxIO;
		this.MJmaxIO = MJmaxIO;
		this.TeslamaxIO = TeslamaxIO;
		this.IC2Tier = IC2Tier;
	}
	
	public String getName() {
		return name;
	}

	public double RJmaxIO() {
		return RJmaxIO;
	}

	public double EUmaxIO() {
		return EUmaxIO;
	}
	
	public double TRmaxIO() {
		return TRmaxIO;
	}
	
	public int RFmaxIO() {
		return RFmaxIO;
	}
	
	public long MJmaxIO() {
		return MJmaxIO;
	}
	
	public long TeslamaxIO() {
		return TeslamaxIO;
	}
	
	public int getIC2Tier() {
		return IC2Tier;
	}
}
