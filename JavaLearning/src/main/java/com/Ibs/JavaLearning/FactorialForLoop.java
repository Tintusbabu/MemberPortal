package com.Ibs.JavaLearning;

public class FactorialForLoop {
	public static void main(String args[])
	{
	
	int num = 7 ;
	int fat = 1 ;
	
	for(int i = 1 ;i <=num ; i ++ )
	{
		fat = fat*i;
	}
	System.err.println("Fact of 7:"+fat);

	}

}
