package com.data.common.utils;

import java.util.Random;


public class RandomUtil {
	public static int getRandom(int min,int max) {
		Random random = new Random();
		int s = random.nextInt(max)%(max-min+1) + min;
		return s;
	}
	
	public static double getDecimal(int min,int max) {
		min = min*100;
		max = max*100;
		Random random = new Random();
		int s = random.nextInt(max)%(max-min+1) + min;
		double r = (double)s/100;
		return r;
	}
	
//	public static void main(String[] args) throws Exception {
//		for (int i = 0; i < 5; i++) {
//			System.out.println(getDecimal(1,10));
//		}
//		
//		
//	}

}
