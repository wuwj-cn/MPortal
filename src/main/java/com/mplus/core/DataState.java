package com.mplus.core;

public enum DataState {

	DEFAULT(0), DELETED(1);
	
	private int nCode;
	
	private DataState(int nCode) {
		this.nCode = nCode;
	}
	
	@Override
	public String toString() {
		return String.valueOf(this.nCode);
	}
}
