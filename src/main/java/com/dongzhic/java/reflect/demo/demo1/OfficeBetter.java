package com.dongzhic.java.reflect.demo.demo1;

class OfficeBetter {
	public static void main(String[] args) {
		try {
			Class c = Class.forName(args[0]);
			OfficeAble oa = (OfficeAble)c.newInstance();
			oa.start();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
}
