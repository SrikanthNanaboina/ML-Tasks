package com.bhavna.ziplookup;

public class State extends Country {
	private String state;

	public State(String country, String state) {
		super(country);
		this.state = state;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
}
