/*
 * Copyright (c) 2020 TheSledgeHammer.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser Public License v3
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/lgpl-3.0.txt
 */

package com.thesledgehammer.radiantspectraljoules.spectraljoules;

import com.thesledgehammer.radiantspectraljoules.EnumEnergyTierIO;

import java.awt.*;
import java.util.Locale;

public enum EnumRadiationType {
	GAMMA(EnumFrequency.EXTREME,  EnumWavelength.LOW, 112, EnumEnergyTierIO.INFINITE, 256, 2.00, false, new Color(0x7B00FF)),
	XRAY(EnumFrequency.ULTRA,  EnumWavelength.MEDIUM, 192, EnumEnergyTierIO.INSANE, 85.1, 1.75, false, new Color(0x007DD1)),
	ULTRVIOLET(EnumFrequency.SUPER,  EnumWavelength.HIGH, 320, EnumEnergyTierIO.EXTREME, 32, 1.60, false, new Color(0x00D129)),
	INFRARED(EnumFrequency.HIGH,  EnumWavelength.SUPER, 512, EnumEnergyTierIO.HIGH, 12.8, 1.45, true, new Color(0xFFCC00)),
	MICROWAVE(EnumFrequency.MEDIUM,  EnumWavelength.ULTRA, 768, EnumEnergyTierIO.MEDIUM, 5.3, 1.30, true, new Color(0xFF8300)),
	RADIO(EnumFrequency.LOW, EnumWavelength.EXTREME, 1024, EnumEnergyTierIO.LOW, 2.3, 1.15, true, new Color(0xF90000));
	
	public static final EnumRadiationType[] VALUES = values();
	
	private final String name;
	private final EnumFrequency frequency;
	private final EnumWavelength wavelength;
	private final EnumEnergyTierIO energyTier;
	private final double distance;
	private final double cost;
	private final double interference;
	private final boolean crossDimensional;
	private final int radiationColor;
	
	EnumRadiationType(EnumFrequency frequency, EnumWavelength wavelength, double distance, EnumEnergyTierIO energyTier, double cost, double interference, boolean crossDimensional, Color radiationColor) {
		this.name = toString().toLowerCase(Locale.ENGLISH);
		this.frequency = frequency;
		this.wavelength = wavelength;
		this.distance = distance;
		this.energyTier = energyTier;
		this.cost = cost;
		this.crossDimensional = crossDimensional;
		this.interference = interference;
		this.radiationColor = radiationColor.getRGB();
	}
	
	public String getName() {
		return name;
	}
	
	public EnumFrequency getFrequency() {
		return frequency;
	}
	
	public EnumWavelength getWavelength() {
		return wavelength;
	}
	
	public double getDistance() {
		return distance;
	}
	
	public EnumEnergyTierIO getEnergyTier() {
		return energyTier;
	}
	
	public double getCostPerTick() {
		return cost;
	}
	
	public double getInterferenceFactor() {
		return interference;
	}
	
	public boolean isInterDimensionalCapable() {
		return crossDimensional;
	}
	
	public int getRadiationColor() {
		return radiationColor;
	}
}
