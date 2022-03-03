package javaproject2;

import java.util.Scanner;

public class Ifelse {
	
	public static void main(String args[])
	{ 
		Scanner sc = new Scanner(System.in);
	    int leg,hand,wheel;
	   
	    System.out.println("the value of leg is");
		leg=sc.nextInt();
		
		System.out.println("the value of hand is");
		hand=sc.nextInt();
		 
		System.out.println("the value of wheel is");
		wheel=sc.nextInt();
	   
		if(leg == 2 && hand == 2 && wheel == 0 )
		{
			System.out.println("its a man");
			
		}
		else if(leg == 0 && hand == 0 && wheel == 3 )
		{
			System.out.println("it is an auto");
		}
		else 
		{
			System.out.println("it is snake");
		}
		
		
	}

}
