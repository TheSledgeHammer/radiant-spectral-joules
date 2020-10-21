/*
 * Copyright (c) 2020 TheSledgeHammer.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser Public License v3
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/lgpl-3.0.txt
 */

package com.thesledgehammer.radiantspectraljoules;

import com.thesledgehammer.radiantspectraljoules.api.IEnergyEnabler;

public class EnergyCompatEnabler implements IEnergyEnabler {
	
	private boolean EU;
	private boolean TR;
	private boolean RF;
	private boolean MJ;
	private boolean TESLA;
	
	public EnergyCompatEnabler(boolean EU, boolean TR, boolean RF, boolean MJ, boolean TESLA) {
		setIsIC2EUEnabled(EU);
		setIsTREnabled(TR);
		setIsRFEnabled(RF);
		setIsBC8MJEnabled(MJ);
		setIsTeslaEnabled(TESLA);
	}
	
	private void setIsIC2EUEnabled(boolean EU) {
		this.EU = EU;
	}
	
	private void setIsTREnabled(boolean TR) {
		this.TR = TR;
	}
	
	private void setIsRFEnabled(boolean RF) {
		this.RF = RF;
	}
	
	private void setIsBC8MJEnabled(boolean MJ) {
		this.MJ = MJ;
	}
	
	private void setIsTeslaEnabled(boolean TESLA) {
		this.TESLA = TESLA;
	}
	
	//IEnergyEnabler
	@Override
	public boolean isIC2EUEnabled() {
		return EU;
	}

	@Override
	public boolean isTREnabled() {
		return TR;
	}

	@Override
	public boolean isRFEnabled() {
		return RF;
	}

	@Override
	public boolean isBC8MJEnabled() {
		return MJ;
	}

	@Override
	public boolean isTeslaEnabled() {
		return TESLA;
	}
}
