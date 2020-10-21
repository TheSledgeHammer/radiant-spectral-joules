/*
 * Copyright (c) 2020 TheSledgeHammer.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser Public License v3
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/lgpl-3.0.txt
 */

package com.thesledgehammer.radiantspectraljoules.spectraljoules;

import com.thesledgehammer.radiantspectraljoules.radiantjoules.RjStorage;
import net.minecraft.nbt.NBTTagCompound;

public class SjStorage extends RjStorage implements ISjStorage {
	
	private EnumRadiationType radiationType;
	protected double frequency;
	protected double wavelength;
	protected double distance;
	protected double transfer;
	protected double cost;
	protected boolean crossDimensions;
	protected double interference;

	
	public SjStorage(double capacity) {
		super(capacity, capacity, capacity);
	}

	public SjStorage(double capacity, double maxTransfer) {
		super(capacity, maxTransfer, maxTransfer);
	}

	public SjStorage(double capacity, double receive, double extract) {
		super(capacity, receive, extract);
	}
	
	public void setRadiationType(EnumRadiationType radiationType) {
		this.radiationType = radiationType;
		setFrequency(radiationType.getFrequency());
		setWavelength(radiationType.getWavelength());
		setTransferRate(radiationType.getEnergyTier().RFmaxIO());
		setDistance(radiationType.getDistance());
		setCost(radiationType.getCostPerTick());
		setInterDimensionalCapable(radiationType.isInterDimensionalCapable());
		setInterference(radiationType.getInterferenceFactor());
	}
	
	public void setFrequency(EnumFrequency frequency) {
		this.frequency = frequency.getFrequency();
	}
	
	public void setWavelength(EnumWavelength wavelength) {
		this.wavelength = wavelength.getWavelength();
	}

	private void setTransferRate(double transfer) {
		this.transfer = transfer;
	}
	
	private void setDistance(double distance) {
		this.distance = distance;
	}
	
	private void setCost(double cost) {
		this.cost = cost;
	}

	private void setInterDimensionalCapable(boolean crossDimensions) {
		this.crossDimensions = crossDimensions;
	}

	private void setInterference(double interference) {
		this.interference = interference;
	}
	
	public EnumRadiationType Radiation() {
		return radiationType;
	}
	
	public EnumFrequency EnumFrequency() {
		return radiationType.getFrequency();
	}
	
	public EnumWavelength EnumWavelength() {
		return radiationType.getWavelength();
	}

	@Override
	public NBTTagCompound serializeNBT() {
		final NBTTagCompound nbt = new NBTTagCompound();
		nbt.setDouble("power", this.power);
		
		nbt.setDouble("frequency", this.frequency);
		nbt.setDouble("wavelength", this.wavelength);
		nbt.setDouble("distance", this.distance);
		nbt.setDouble("transfer", this.transfer);
		nbt.setDouble("cost", this.cost);
		nbt.setBoolean("crossDimensions", this.crossDimensions);
		nbt.setDouble("interference", this.interference);
		if(power > capacity) {
			power = capacity;
		}
		return nbt;
	}
	
	@Override
	public void deserializeNBT(NBTTagCompound nbt) {
		if(power < 0) {
			power = 0;
		}
		
		this.power = nbt.getDouble("power");
		
		this.frequency = nbt.getDouble("frequency");
		this.wavelength = nbt.getDouble("wavelength");
		this.distance = nbt.getDouble("distance");
		this.transfer = nbt.getDouble("transfer");
		this.cost = nbt.getDouble("cost");
		this.crossDimensions = nbt.getBoolean("crossDimensions");
		this.interference = nbt.getDouble("interference");
	}
	
	//ISjStorage
	@Override
	public double Frequency() {
		return frequency;
	}
	
	@Override
	public double Wavelength() {
		return wavelength;
	}
	
	@Override
	public double Distance() {
		return distance;
	}
	
	@Override
	public double Cost() {
		return cost;
	}
	
	@Override
	public double TransferRate() {
		return transfer;
	}
	
	@Override
	public boolean canTravelCrossDimensions() {
		return crossDimensions;
	}
	
	@Override
	public double Interference() {
		return interference;
	}

	/**
	 * The phase transistion of matter;
	 * @return If Sj is a Solid
	 */
	@Override
	public boolean InSolidState() {
		return false;
	}
	
	/**
	 * The phase transistion of matter;
	 * @return If Sj is a Liquid
	 */
	@Override
	public boolean InLiquidState() {
		return false;
	}
	
	/**
	 * The phase transistion of matter;
	 * @return If Sj is a Gas
	 */
	@Override
	public boolean InGasState() {
		return false;
	}
	
	/**
	 * The phase transistion of matter;
	 * @return If Sj is a Plasma (Default State)
	 */
	@Override
	public boolean InPlasmaState() {
		return true;
	}
}
