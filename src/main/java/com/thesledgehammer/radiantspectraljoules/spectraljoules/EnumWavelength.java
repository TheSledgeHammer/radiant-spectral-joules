/*
 * Copyright (c) 2020 TheSledgeHammer.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser Public License v3
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/lgpl-3.0.txt
 */

package com.thesledgehammer.radiantspectraljoules.spectraljoules;

import java.util.Locale;

public enum EnumWavelength {
	LOW(16),
	MEDIUM(32),
	HIGH(64),
	SUPER(128),
	ULTRA(256),
	EXTREME(512);
	
	public static final EnumWavelength[] VALUES = values();
	
	private final String name;
	private final double maxWave;
	
	EnumWavelength(double maxWave) {
		this.name = toString().toLowerCase(Locale.ENGLISH);
		this.maxWave = maxWave;
	}
	
	public String getName() {
		return name;
	}
	
	public double getWavelength() {
		return maxWave;
	}
}
