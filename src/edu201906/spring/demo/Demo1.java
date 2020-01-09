package edu201906.spring.demo;

public class Demo1 {

	public static void main(String[] args) {
		String q = new String("aaa");
		String s = new String(q);

		System.out.println(q);
		System.out.println(s);

		System.out.println(q == s);

		String qq = new String("bbb");
		String ss = qq;
		System.out.println(qq);
		System.out.println(ss);

		System.out.println(qq == ss);

	}
	
	public static int ten2Two(int n) {
		StringBuilder sb = new StringBuilder();
		while (n != 0) {
			sb.append(n % 2);
			n = n / 2;
		}
		sb.reverse();
		return Integer.valueOf(sb.toString());
	}
}
