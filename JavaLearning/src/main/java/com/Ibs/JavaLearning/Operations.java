package com.Ibs.JavaLearning;

public class Operations {
	
	public int addition(int num1 , int num2)
	{
		System.out.println("Addition Operation ");
		System.out.println("Num1: "+num1);
		System.out.println("Num2: "+num2);
		int sum = num1+num2;
		return sum;
	}

	public int subtraction(int num1 , int num2)
	{
		System.out.println("Subtraction Operation ");
		System.out.println("Num1: "+num1);
		System.out.println("Num2: "+num2);
		int sub = num1-num2;
		return sub;
	}
	public int multiplication(int num1 , int num2)
	{
		System.out.println("Multiplication Operation ");
		System.out.println("Num1: "+num1);
		System.out.println("Num2: "+num2);
		int mul = num1*num2;
		return mul;
	}
	public int division(int num1 , int num2)
	{
		System.out.println("Division Operation ");
		System.out.println("Num1: "+num1);
		System.out.println("Num2: "+num2);
		int quat = num1/num2;
		return quat;
	}
}

