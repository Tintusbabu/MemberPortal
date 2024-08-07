package com.Ibs.JavaLearning;

public class IMDPApp {

	public static void main(String[] args) {
		String actorName="Tom Cruise";
		int yearOfBorn=1962;
		int age=2024-yearOfBorn;

		System.out.println("Actor's Name:"+actorName);
		System.out.println("Born:"+yearOfBorn+"("+age+" years old");
		//Method 1
		String[]  movieTitles = new String[3];
		
		movieTitles[0]="The last samurai";
		movieTitles[1]="Top Gun";
		movieTitles[2]="Rain Man";
		
		System.out.println("Movie List:");
		for(int i=0;i<movieTitles.length;i++)
		{
			System.out.println(movieTitles[i]);
		}
		
		System.out.println("Movie Ratings:");
		
		float[]  movieRatings=  new float[3];
		movieRatings[0]= 7.7f;
		movieRatings[1]= 9.6f;
		movieRatings[2]= 6.9f;
		for(int i=0;i<movieRatings.length;i++)
		{
			System.out.println(movieRatings[i]);
		}
		
		//System		
		
		
		for(int i=0;i<movieTitles.length;i++) {
			System.out.println(movieTitles[i]+"-"+getRating(movieRatings[i]));
		}
		

	}
	
	static String getRating(float rating) {
		if(rating<=5.0)
			return "bad";
		else if(rating>5.0 && rating<=6.5)
			return "average";
		else
		return "amazing";
	}

}
