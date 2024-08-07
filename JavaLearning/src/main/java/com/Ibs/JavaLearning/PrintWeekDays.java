package com.Ibs.JavaLearning;

import java.util.Scanner;

public class PrintWeekDays {
	
	public static void main(String args[]){
		
		 int day;
	        Scanner s = new Scanner(System.in);
	        System.out.print("Enter the day number:");
	        day= s.nextInt();
	        
	        //if .... else
	        if(day==1)
	        	
	        	 System.out.print("Sunday");
	        else  if(day==2)
	        	
	        	 System.out.print("Monday");
	        else if(day==3)
	        	
	        	 System.out.print("Tuesday");
	        else if(day==4)
	        	
	        	 System.out.print("Wednesday");
	        else  if(day==5)
	        	
	        	 System.out.print("Thursday");
	        else if (day==6)
	        	System.out.println("Friday");
	        else if (day==7)
	        	System.out.println("Saturday");
	        else
	 	        	System.out.println("Not a valid day");
	        
	      //switch case
	        switch (day) {
	        case 1:
		          System.out.println("Sunday");
		          break;
	        case 2:
	          System.out.println("Monday");
	          break;
	        case 3:
	          System.out.println("Tuesday");
	          break;
	        case 4:
	          System.out.println("Wednesday");
	          break;
	        case 5:
	          System.out.println("Thursday");
	          break;
	        case 6:
	          System.out.println("Friday");
	          break;
	        case 7:
	          System.out.println("Saturday");
	          break;
	          default:
	          System.out.println("Not a valid day");
	        	  
	       
	      }
	}

}
