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
}
