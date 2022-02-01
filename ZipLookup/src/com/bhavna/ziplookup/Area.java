package com.bhavna.ziplookup;

public class Area extends State{
	private int zipcode;
	public Area(String country, String state, int zipcode) {
		super(country, state);
		this.zipcode = zipcode;
	}

	public int getZipcode() {
		return zipcode;
	}

	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}

}
