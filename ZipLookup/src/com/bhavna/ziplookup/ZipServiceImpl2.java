package com.bhavna.ziplookup;

public class ZipServiceImpl2 extends ZipServiceImpl1 implements ZipServicev2{
	private static final ZipServiceImpl2 object = new ZipServiceImpl2();
	
	@Override
	public void printAll() {
		this.map.forEach((zipcode, area)->System.out.println(area));
	}
	
	public static ZipServiceImpl1 getObject() {
		return object;
	}

}
