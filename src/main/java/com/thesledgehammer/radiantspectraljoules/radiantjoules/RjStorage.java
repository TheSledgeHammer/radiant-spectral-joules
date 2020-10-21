/*
 * Copyright (c) 2020 TheSledgeHammer.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser Public License v3
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/lgpl-3.0.txt
 */

package com.thesledgehammer.radiantspectraljoules.radiantjoules;

import buildcraft.api.mj.MjAPI;
import com.thesledgehammer.radiantspectraljoules.EnumEnergyTierIO;
import com.thesledgehammer.radiantspectraljoules.EnumTransferMode;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.util.INBTSerializable;

import java.util.ArrayList;

public class RjStorage implements IRjStorage, INBTSerializable<NBTTagCompound> {

    protected double power;
    protected double capacity;
    protected double extract;
    protected double receive;

    private ArrayList<Double> EU;
    private ArrayList<Double> TR;
    public ArrayList<Integer> RF;
    private ArrayList<Long> MJ;
    private ArrayList<Long> TESLA;

    {
        EU = new ArrayList<>();
        TR = new ArrayList<>();
        RF = new ArrayList<>();
        MJ = new ArrayList<>();
        TESLA = new ArrayList<>();
    }

    //protected EnergyManager energyManager;
    protected EnumTransferMode externalMode;
    protected EnumEnergyTierIO energyTier;

    public RjStorage(double capacity) {
        this(capacity, capacity, capacity);

        EUPower(capacity, capacity, capacity);
        TRPower(capacity, capacity, capacity);
        RFPower((int) capacity, (int) capacity, (int) capacity);
        MJPower((long) capacity, (long) capacity, (long) capacity);
        TeslaPower((long) capacity, (long) capacity, (long) capacity);
    }

    public RjStorage(double capacity, double maxTransfer) {
        this(capacity, maxTransfer, maxTransfer);

        EUPower(capacity, maxTransfer, maxTransfer);
        TRPower(capacity, maxTransfer, maxTransfer);
        RFPower((int) capacity, (int) maxTransfer, (int) maxTransfer);
        MJPower((long) capacity, (long) maxTransfer, (long) maxTransfer);
        TeslaPower((long) capacity, (long) maxTransfer, (long) maxTransfer);
    }

    public RjStorage(double capacity, double receive, double extract) {
        this.capacity = capacity;
        this.receive = receive;
        this.extract = extract;

        EUPower(capacity, receive, extract);
        TRPower(capacity, receive, extract);
        RFPower((int) capacity, (int) receive, (int) extract);
        MJPower((long) capacity, (long) receive, (long) extract);
        TeslaPower((long) capacity, (long) receive, (long) extract);
    }

    public void setMaxTransfer(double maxTransfer) {
        setMaxExtract(maxTransfer);
        setMaxReceive(maxTransfer);
    }

    public void setMaxExtract(double extract) {
        this.extract = extract;
    }

    public void setMaxReceive(double receive) {
        this.receive = receive;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;

        if (power > capacity) {
            power = capacity;
        }
    }

    public double getMaxExtract() {
        return extract;
    }

    public double getMaxReceive() {
        return receive;
    }

    public void setPowerStored(double power) {
        this.power = power;
        if (this.power > capacity) {
            this.power = capacity;
        } else if (this.power < 0) {
            this.power = 0;
        }
    }

    public void modifyPowerStored(double power) {
        this.power += power;
        if (this.power > capacity) {
            this.power = capacity;
        } else if (this.power < 0) {
            this.power = 0;
        }
    }

    /**
     * EUPower:
     *
     * @param capacity = EU.get(0)
     * @param receive  = EU.get(1)
     * @param extract  = EU.get(2)
     */
    private final void EUPower(double capacity, double receive, double extract) {
        this.capacity = capacity;
        this.receive = receive;
        this.extract = extract;
        EU.add(capacity);
        EU.add(receive);
        EU.add(extract);
    }

    /**
     * TRPower:
     *
     * @param capacity = TR.get(0)
     * @param receive  = TR.get(1)
     * @param extract  = TR.get(2)
     */
    private final void TRPower(double capacity, double receive, double extract) {
        this.capacity = capacity;
        this.receive = receive;
        this.extract = extract;
        TR.add(capacity);
        TR.add(receive);
        TR.add(extract);
    }

    /**
     * RFPower:
     *
     * @param capacity = RF.get(0)
     * @param receive  = RF.get(1)
     * @param extract  = RF.get(2)
     */
    private final void RFPower(int capacity, int receive, int extract) {
        int rf = 128;
        this.capacity = capacity * rf;
        this.receive = receive * rf;
        this.extract = extract * rf;
        RF.add(capacity);
        RF.add(receive);
        RF.add(extract);
    }

    /**
     * MJPower:
     *
     * @param capacity = MJ.get(0)
     * @param receive  = MJ.get(1)
     * @param extract  = MJ.get(2)
     */
    private final void MJPower(long capacity, long receive, long extract) {
        long mj = (MjAPI.MJ * 128) / 1000;
        this.capacity = capacity * mj;
        this.receive = receive * mj;
        this.extract = extract * mj;
        MJ.add(capacity);
        MJ.add(receive);
        MJ.add(extract);
    }

    /**
     * TeslaPower:
     *
     * @param capacity = TESLA.get(0)
     * @param receive  = TESLA.get(1)
     * @param extract  = TESLA.get(2)
     */
    private final void TeslaPower(long capacity, long receive, long extract) {
       long tesla = 128;
       this.capacity = capacity * tesla;
       this.receive = receive * tesla;
       this.extract = extract * tesla;
       TESLA.add(capacity);
       TESLA.add(receive);
       TESLA.add(extract);
    }

    @Override
    public NBTTagCompound serializeNBT() {
        final NBTTagCompound nbt = new NBTTagCompound();
        nbt.setDouble("power", this.power);
        if (power > capacity) {
            power = capacity;
        }
        return nbt;
    }

    @Override
    public void deserializeNBT(NBTTagCompound nbt) {
        if (power < 0) {
            power = 0;
        }
        this.power = nbt.getDouble("power");
    }

    //IRjStorage
    @Override
    public double receivePower(double maxReceive, boolean simulate) {
        if (!canReceive()) {
            return 0;
        }
        double powerReceived = Math.min(capacity - power, Math.min(this.receive, maxReceive));
        if (!simulate) {
            power += powerReceived;
        }
        return powerReceived;
    }

    @Override
    public double extractPower(double maxExtract, boolean simulate) {
        if (!canExtract()) {
            return 0;
        }
        double powerExtracted = Math.min(power, Math.min(this.extract, maxExtract));
        if (!simulate) {
            power -= powerExtracted;
        }
        return powerExtracted;
    }

    @Override
    public double getMaxPowerStored() {
        return capacity;
    }

    @Override
    public double getPowerStored() {
        return power;
    }

    @Override
    public boolean canExtract() {
        return this.extract > 0;
    }

    @Override
    public boolean canReceive() {
        return this.receive > 0;
    }

    /**
     * EU Power
     *
     * @param index (capacity, receive, extract) 0 - 2 Respectively
     * @return Output of the given index
     */
    @Override
    public double getEUPower(int index) {
        return EU.get(index);
    }

    /**
     * TR (Tech Reborn) Power
     *
     * @param index (capacity, receive, extract) 0 - 2 Respectively
     * @return Output of the given index
     */
    @Override
    public double getTRPower(int index) {
        return TR.get(index);
    }

    /**
     * RF Power
     *
     * @param index (capacity, receive, extract) 0 - 2 Respectively
     * @return Output of the given index
     */
    @Override
    public int getRFPower(int index) {
        return RF.get(index);
    }

    /**
     * MJ Power (BuildCraft8)
     *
     * @param index (capacity, receive, extract) 0 - 2 Respectively
     * @return Output of the given index
     */
    @Override
    public long getMJPower(int index) {
        return MJ.get(index);
    }

    /**
     * TESLA Power
     *
     * @param index (capacity, receive, extract) 0 - 2 Respectively
     * @return Output of the given index
     */
    @Override
    public long getTESLAPower(int index) {
        return TESLA.get(index);
    }
}
