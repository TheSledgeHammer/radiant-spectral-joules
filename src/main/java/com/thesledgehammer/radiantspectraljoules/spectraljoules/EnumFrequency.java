/*
 * Copyright (c) 2020 TheSledgeHammer.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser Public License v3
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/lgpl-3.0.txt
 */

package com.thesledgehammer.radiantspectraljoules.spectraljoules;

import java.util.Locale;

public enum EnumFrequency {
	LOW(2),
	MEDIUM(3),
	HIGH(4),
	SUPER(5),
	ULTRA(6),
	EXTREME(7);
	
	public static final EnumFrequency[] VALUES = values();
	
	private final String name;
	private final double maxFreq;
	
	EnumFrequency(double maxFreq) {
		this.name = toString().toLowerCase(Locale.ENGLISH);
		this.maxFreq = maxFreq;
	}
	
	public String getName() {
		return name;
	}
	
	public double getFrequency() {
		return maxFreq;
	}
}
