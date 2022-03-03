package javaproject2;

import javaproject.X;
import javaproject.Y;

public class Z extends X
    {
	public void n3()
	{
	 System.out.println("i am from class Z");
	}
	public static void main(String[] args) 
	{
		Z z=new Z();
		z.n3();
		z.n1();
		Y y=new Y();
		y.n1();
		y.n2();
		

	}

}
