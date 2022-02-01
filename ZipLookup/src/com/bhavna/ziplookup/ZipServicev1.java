package com.bhavna.ziplookup;

public interface ZipServicev1 {
	public void printAll();
	public void getZipcodeDetails(String zipcode);
	public void addZipcodeDetails(String zipcode, String area, String state, String country);
	public boolean hasZipcode(String zipcode);
}
