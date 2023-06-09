package org.java.spring.helper;

import com.github.javafaker.Faker;

public abstract class Helper {
	public static int createRndNumberInRangeWithFaker(int min , int max , Faker f) {
		int rndNum = f.number().numberBetween(min, max);
		return rndNum;
	}
}
