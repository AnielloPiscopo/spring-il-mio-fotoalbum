package org.java.spring.helper;

import java.util.List;

import com.github.javafaker.Faker;
import com.github.slugify.Slugify;

public abstract class Helper {
	public static int createRndNumberInRangeWithFaker(int min , int max , Faker f) {
		int rndNum = f.number().numberBetween(min, max);
		return rndNum;
	}
	
	public static String getUniqueSlug(List<String> list , String str) {
		Slugify slg = Slugify.builder().build();
		
		int suffix=1;
		String baseSlug = slg.slugify(str);
		String uniqueSlug = baseSlug;
		
		for(String el : list) {
			String elSlug = slg.slugify(el);
			if(baseSlug.equals(elSlug)) uniqueSlug = baseSlug + (++suffix);
		}
		return uniqueSlug;
	}
	
	public static String getSlug(String str) {
		Slugify slg = Slugify.builder().build();
		
		String slug = slg.slugify(str);
		
		return slug;
	}
}
