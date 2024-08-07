package com.Ibs.JavaLearning;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CollectionLearning {

	public static void main(String[] args) {
		
		//ArrayList
		ArrayList<Integer> arrList = new ArrayList<Integer>();
		arrList.add(20);
		arrList.add(39);
		arrList.add(60);
		arrList.add(90);
		arrList.add(80);
		arrList.add(80);
		System.out.println("Integer Array" + arrList);
		System.out.println("Traversal of an ArrayList ");
		for (int i = 0; i < arrList.size(); i++)

			System.out.println(arrList.get(i));
		System.out.println("Enhanced For loop Traversal of an ArrayList ");
		for (Integer j:arrList)

			System.out.println(j);
		
		ArrayList<String> arrListStr = new ArrayList<String>();
		arrListStr.add("MP");
		arrListStr.add("LMS");
		arrListStr.add("CDX");
		arrListStr.add("Cargo");
		
		
		for(String sr:arrListStr)
			System.out.println(sr);
		
		arrListStr.remove(2);
		arrListStr.set(0, "Member portal");
		System.out.println("After Remove"+arrListStr);
		
		//Set
		
		Set<String> setVal = new HashSet<String>();
		setVal.add("Mp");
		setVal.add("CDX");
		setVal.add("Cargo");
		setVal.add("MP");
		setVal.add("CDX");
		System.out.println("Set Values");
		for(String strVal: setVal)
			System.out.println(strVal);
		
		//HashMap
		
		Map<String,Integer> mapData = new HashMap<String,Integer>();
		
		mapData.put("Price1",10);
		mapData.put("Price2",70);
		mapData.put("Price3",90);
		System.out.println("Hash Map Values"+mapData);
		//Enhanced for loop
		
		System.out.println("Enhanced For loop");
		for(String str:mapData.keySet())
			
			System.out.println(mapData.get(str));
		
		
		//Employee
		
		ArrayList<Employee> empDetails = new ArrayList<Employee>();
		Employee empList1 = new Employee("Jeena",23,21023);
		Employee empList2 = new Employee("Meena",43,23323);
		Employee empList3 = new Employee("Veena",93,26723);
		
		empDetails.add(empList1);

		empDetails.add(empList2);

		empDetails.add(empList3);
		
		System.out.println("Employee details=="+empDetails);
		
		for( Employee e:empDetails)
			System.out.println(e.getName());

		
		

	}

}
