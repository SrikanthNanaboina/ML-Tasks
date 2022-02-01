package com.bhavna.ziplookup;

public class ServiceManager {
	public static ZipServicev1 getZipService() {
		return ZipServicev2.getObject();
	}
}
