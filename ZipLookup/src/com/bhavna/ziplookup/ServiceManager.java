package com.bhavna.ziplookup;

public class ServiceManager {
	public static ZipServicev1 getZipServicev1() {
		return ZipServiceImpl2.getObject();
	}
	public static ZipServicev2 getZipServicev2() {
		return (ZipServicev2) ZipServiceImpl2.getObject();
	}
}
