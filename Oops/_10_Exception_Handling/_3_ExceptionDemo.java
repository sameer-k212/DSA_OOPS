package Oops._9_Exception;

import java.util.InputMismatchException;
import java.util.Scanner;
public class _3_ExceptionDemo
	{
	public static void main(String[] args)
	{
		int num=0;
		Scanner sc=new Scanner(System.in);

		try
		{
			num=sc.nextInt();
		}

//		catch(Exception e){         // if you write here it will give you error.
//			System.out.println("Bro Kuchh galat likh diya kya");
//		}


		catch(InputMismatchException e)
		{
			System.out.println("Please enter number");
		}
		catch(Exception e){
			System.out.println("Bro Kuchh galat likh diya kya");
		}

		finally {
			System.out.println("Jo hua achha hua");
		}
		sc.close();
	
		System.out.println(num);
		
	}
}

// Output1: javac ExceptionDemo3.java			
//	      java ExceptionDemo3
//          78
//          78


// Output2:			
//	      java ExceptionDemo3
//          Navin
//          Please enter number
//	      0