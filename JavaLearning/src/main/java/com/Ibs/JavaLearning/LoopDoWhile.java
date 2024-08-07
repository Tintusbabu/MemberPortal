package com.Ibs.JavaLearning;

public class LoopDoWhile {

	public static void main(String[] args) {

		int number=7,fact=1;
		do
		{
			
			fact=fact*number;
			number--;
		}
		while(number>0);
		System.out.println(fact);
	}

}
