package com.Ibs.JavaLearning;

public class ArrayOperation {

	public static void main(String[] args) {
	int[] arr=  {10,20,50};
	System.out.println("First arr");
	
	for(int i=0;i<arr.length;i++)
	{
		System.out.println(arr[i]);
	}
	
	int[] arr1 = new int[10];
	System.out.println("Second Array");
	int num= 20;
	for(int arItem:arr1)
	{
		arItem=num;
		num=num+2;
		System.out.println(arItem);
	}

	}

}
