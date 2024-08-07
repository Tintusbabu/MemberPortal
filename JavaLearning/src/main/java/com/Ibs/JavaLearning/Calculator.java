package com.Ibs.JavaLearning;

/**
 * Hello world!
 *
 */
public class Calculator 
{
    public static void main( String[] args )
    {
       Operations op = new Operations();
       int sum = op.addition(10, 20);
       System.out.println("Sum :"+sum);
       int sub = op.subtraction(100, 80);
       System.out.println("Difference :"+sub);
       int pro = op.multiplication(30, 40);
       System.out.println("Product :"+pro);
       int quat = op.division(25, 5);
       System.out.println("Quotient :"+quat);
       
    }
}
