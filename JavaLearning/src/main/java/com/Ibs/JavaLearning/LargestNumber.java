package com.Ibs.JavaLearning;

public class LargestNumber {

	public static void main(String[] args) {
		int a=90,b=30,c=20 ;
		
		//Method1
		/*
		 * if(a>b) { if(a>c) { System.out.println("Largest Number :"+a); } else {
		 * System.out.println("Largest Number :"+c); } } else if(b>c) {
		 * System.out.println("Largest Number :"+b); } else {
		 * System.out.println("Largest Number :"+c); }
		 */

	if(a>b && a>c)
	{
		System.out.println("Largest Number :"+a)	;
	}
	else if(b>c)
	{
		System.out.println("Largest Number :"+b);
	}
	else
	{
		System.out.println("Largest Number :"+c);
	}
	}

}
