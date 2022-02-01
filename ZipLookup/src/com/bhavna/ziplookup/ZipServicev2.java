package com.bhavna.ziplookup;

import java.util.HashMap;
import java.util.Map;

public class ZipServicev2 implements ZipServicev1 {
	
	private static ZipServicev2 object;
	private Map<String, Area> map = new HashMap<>();
	
	{
		this.map.put("506132", new Area("India", "Telangana", "Narsampet", "506132"));
	}

	private ZipServicev2() {
		
	}
	
	@Override
	public void printAll() {
		this.map.forEach((zipcode, area)->System.out.println(area));
	}
	
	public static ZipServicev2 getObject() {
		if(object==null)
			return object = new ZipServicev2();
		return object;
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
