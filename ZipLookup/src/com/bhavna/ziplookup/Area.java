package com.bhavna.ziplookup;

public class Area extends State{
	private String zipcode;
	private String area;
	public Area(String country, String state, String area, String zipcode) {
		super(country, state);
		this.area = area;
		this.zipcode = zipcode;
	}
	
	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	@Override
	public String toString() {
		return "Zipcode: "+this.getZipcode()+" Address: "+this.getArea()+","+this.getState()+","+this.getCountry();
	}
	
	
}
