package com.bhavna.ziplookup;

import java.util.HashMap;
import java.util.Map;

public abstract class ZipServiceImpl1 implements ZipServicev1 {
	

	protected Map<String, Area> map = new HashMap<>();
	
	{
		this.map.put("506132", new Area("India", "Telangana", "Narsampet", "506132"));
	}



	@Override
	public void getZipcodeDetails(String zipcode) {
		if(this.hasZipcode(zipcode)) {
			System.out.println(this.map.get(zipcode));
			return;
		}
		System.out.println("Zipcode not found");
	}

	@Override
	public void addZipcodeDetails(String zipcode, String area, String state, String country) {
		this.map.put(zipcode, new Area(country, state, area, zipcode));
	}

	@Override
	public boolean hasZipcode(String zipcode) {
		return this.map.containsKey(zipcode);
	}
	
	
	
	
}
