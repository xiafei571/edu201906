package edu201906.spring.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class UtilDemo {

	public static void main(String[] args) {
//		int[] a1 = new int[] { 1, 4, 2, 9, 3, 9 };
//		int[] a2 = new int[] { 1, 4, 2, 9, 10 };
//		System.out.println(Arrays.equals(a1, a2));
//		System.out.println(compare(a1, a2));
//		Arrays.sort(a1);
//		System.out.println(a1.toString());
//		System.out.println(a2.toString());
//		System.out.println(Arrays.toString(a1));
//
//		System.out.println(Arrays.binarySearch(a1, 10));
//		
//		System.out.println(Math.sin(Math.PI/3));
//		System.out.println(Math.log10(100));
//		
//		Random random = new Random();
//		System.out.println(random.nextInt(10));
//		System.out.println(random.nextInt(10));
//		System.out.println(random.nextInt(10));
//		System.out.println(random.nextInt(10));
//		System.out.println(random.nextInt(10));
//		System.out.println(random.nextInt(10));
		
	}

	private static boolean compare(int[] a1, int[] a2) {
		if (a1 == a2)
			return true;

		if (a1.length != a2.length)
			return false;

		for (int i = 0; i < a1.length; i++) {
			if (a1[i] != a2[i])
				return false;
		}

		return true;
	}
}
