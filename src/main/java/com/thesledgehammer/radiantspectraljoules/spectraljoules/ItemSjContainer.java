/*
 * Copyright (c) 2020 TheSledgeHammer.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser Public License v3
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/lgpl-3.0.txt
 */

package com.thesledgehammer.radiantspectraljoules.spectraljoules;

import com.thesledgehammer.radiantspectraljoules.radiantjoules.ItemRjContainer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class ItemSjContainer extends ItemRjContainer implements ISjContainerItem {

    private EnumRadiationType radiationType;
    private double frequency;
    private double wavelength;
    private double distance;
    private double transfer;
    private boolean crossDimensions;
    private double interference;
    private double cost;

    public ItemSjContainer() {

    }

    public ItemSjContainer(double capacity) {
        super(capacity, capacity, capacity);
    }

    public ItemSjContainer(double capacity, double maxTransfer) {
        super(capacity, maxTransfer, maxTransfer);
    }

    public ItemSjContainer(double capacity, double receive, double extract) {
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


    @Override
    public EnumRadiationType getRadiationType(ItemStack container, EnumRadiationType radiation) {
        return radiationType;
    }

    @Override
    public EnumFrequency getFrequency(ItemStack container, int index) {
        return radiationType.getFrequency();
    }

    @Override
    public EnumWavelength getWavelength(ItemStack container, int index) {
        return radiationType.getWavelength();
    }

    @Override
    public double Frequency(ItemStack container) {
        return frequency;
    }

    @Override
    public double Wavelength(ItemStack container) {
        return wavelength;
    }

    @Override
    public double Distance(ItemStack container) {
        return distance;
    }

    @Override
    public double Cost(ItemStack container) {
        return cost;
    }

    @Override
    public double TransferRate(ItemStack container) {
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

    @Override
    public NBTTagCompound serializeNBT() {
        final NBTTagCompound nbt = new NBTTagCompound();

        nbt.setDouble("frequency", this.frequency);
        nbt.setDouble("wavelength", this.wavelength);
        nbt.setDouble("distance", this.distance);
        nbt.setDouble("transfer", this.transfer);
        nbt.setDouble("cost", this.cost);
        nbt.setBoolean("crossDimensions", this.crossDimensions);
        nbt.setDouble("interference", this.interference);
        return nbt;
    }

    @Override
    public void deserializeNBT(NBTTagCompound nbt) {

        this.frequency = nbt.getDouble("frequency");
        this.wavelength = nbt.getDouble("wavelength");
        this.distance = nbt.getDouble("distance");
        this.transfer = nbt.getDouble("transfer");
        this.cost = nbt.getDouble("cost");
        this.crossDimensions = nbt.getBoolean("crossDimensions");
        this.interference = nbt.getDouble("interference");
    }
}
