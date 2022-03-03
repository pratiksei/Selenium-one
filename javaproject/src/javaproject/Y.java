package javaproject;

public class Y extends X
   {
	public void n2()
	{
	System.out.println("i am from class Y");
	}	
	public static void main(String[] args) 
	{
     X x=new X();
     x.n1();
     
     //Y y=new Y();
     //y.n1();
     //y.n2();
     X obj=new Y();
     obj.n1();
     
     
   
	
	
	
	}
}
