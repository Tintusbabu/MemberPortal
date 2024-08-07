package com.Ibs.JavaLearning;

public class Employee {
	
	
	
	private String name;
	private int age;
	private int empNumber;
	public Employee(String name,int age,int empNumber)
	{
		this.name = name;
		this.age = age;
		this.empNumber = empNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getEmpNumber() {
		return empNumber;
	}
	public void setEmpNumber(int empNumber) {
		this.empNumber = empNumber;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + ", empNumber=" + empNumber + "]";
	}

	
}
