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
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

import java.util.ArrayList;

public class ItemRjContainer extends Item implements IRjContainerItem {
	
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

	public ItemRjContainer() {
		
	}
	
	public ItemRjContainer(double capacity) {
		this(capacity, capacity, capacity);
		
		EUPower(capacity, capacity, capacity);
		TRPower(capacity, capacity, capacity);
		RFPower((int) capacity, (int) capacity, (int) capacity);
		MJPower((long) capacity, (long) capacity, (long) capacity);
		TeslaPower((long) capacity, (long) capacity, (long) capacity);
	}
	
	public ItemRjContainer(double capacity, double maxTransfer) {
		this(capacity, maxTransfer, maxTransfer);
		
		EUPower(capacity, maxTransfer, maxTransfer);
		TRPower(capacity, maxTransfer, maxTransfer);
		RFPower((int) capacity, (int) maxTransfer, (int) maxTransfer);
		MJPower((long) capacity, (long) maxTransfer, (long) maxTransfer);
		TeslaPower((long) capacity, (long) maxTransfer, (long) maxTransfer);
	}
	
	public ItemRjContainer(double capacity, double receive, double extract) {
		this.capacity = capacity;
		this.receive = receive;
		this.extract = extract;
		
		EUPower(capacity, receive, extract);
		TRPower(capacity, receive, extract);
		RFPower((int) capacity, (int) receive, (int) extract);
		MJPower((long) capacity, (long) receive, (long) extract);
		TeslaPower((long) capacity, (long) receive, (long) extract);
	}
	
	public void setCapacity(double capacity) {
		this.capacity = capacity;
	}
	
	public void setMaxTransfer(double maxTransfer) {
		setMaxReceive(maxTransfer);
		setMaxExtract(maxTransfer);
	}
	
	public void setMaxReceive(double receive) {
		this.receive = receive;
	}

	public void setMaxExtract(double extract) {
		this.extract = extract;
	}

	@Override
	public double receivePower(ItemStack container, double receive, boolean simulate) {
		if (!container.hasTagCompound()) {
			container.setTagCompound(new NBTTagCompound());
		}
		
		double power = container.getTagCompound().getDouble("RJPower");
		double powerReceived = Math.min(capacity - power, Math.min(this.receive, receive));

		if (!simulate) {
			power += powerReceived;
			container.getTagCompound().setDouble("RJPower", power);
		}
		return powerReceived;
	}

	@Override
	public double extractPower(ItemStack container, double extract, boolean simulate) {
		if(container.getTagCompound() == null || container.getTagCompound().hasKey("RJPower")) {
			return 0;
		}
		
		double power = container.getTagCompound().getDouble("RJPower");
		double powerExtracted = Math.min(power, Math.min(this.extract, extract));
		
		if (!simulate) {
			power -= powerExtracted;
			container.getTagCompound().setDouble("RJPower", power);
		}
		return powerExtracted;
	}

	@Override
	public double getPowerStored(ItemStack container) {
		if(container.getTagCompound() == null || container.getTagCompound().hasKey("RJPower")) {
			return 0;
		}
		return container.getTagCompound().getDouble("RJPower");
	}

	@Override
	public double getMaxPowerStored(ItemStack container) {
		return capacity;
	}
	
	@Override
	public boolean canReceive(ItemStack container) {
		return true;
	}

	@Override
	public boolean canExtract(ItemStack container) {
		return true;
	}
	
	@Override
	public EnumEnergyTierIO getEnergyTier(int index, ItemStack container) {
		return EnumEnergyTierIO.VALUES[index];
	}
	
	@Override
	public int getIC2Tier(ItemStack container) {
		if(container == null || (!(container.getItem() instanceof IRjContainerItem))) {
			return 0;
		}
		for(int i = 0; i < EnumEnergyTierIO.VALUES.length; i++) {
			if(i == 0) {
				return ((IRjContainerItem)container.getItem()).getEnergyTier(0, container).getIC2Tier();
			}
			if(i == 1) {
				return ((IRjContainerItem)container.getItem()).getEnergyTier(1, container).getIC2Tier();
			}
			if(i == 2) {
				return ((IRjContainerItem)container.getItem()).getEnergyTier(2, container).getIC2Tier();
			}
			if(i == 3) {
				return ((IRjContainerItem)container.getItem()).getEnergyTier(3, container).getIC2Tier();
			}
			if(i == 4) {
				return ((IRjContainerItem)container.getItem()).getEnergyTier(4, container).getIC2Tier();
			}
			if(i == 5) {
				return ((IRjContainerItem)container.getItem()).getEnergyTier(5, container).getIC2Tier();
			}
			if(i == 6) {
				return ((IRjContainerItem)container.getItem()).getEnergyTier(6, container).getIC2Tier();
			}
		}
		return 0;
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

	public void deserializeNBT(NBTTagCompound nbt) {
		this.capacity = nbt.getDouble("RJPower");
	}

	public NBTTagCompound serializeNBT() {
		final NBTTagCompound nbtTag = new NBTTagCompound();
		nbtTag.setDouble("RJPower", this.capacity);
		return nbtTag;
	}
}
