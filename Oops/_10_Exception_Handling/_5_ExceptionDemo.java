// try With Resources 
package Oops._9_Exception;
import java.util.Scanner;
public class _5_ExceptionDemo
	{
	public static void main(String[] args)
	{
		int num=0;
		
		// try with Resources
		try(Scanner sc=new Scanner(System.in))
		{
			num=sc.nextInt();
		}


		System.out.println(num);
	}
}


