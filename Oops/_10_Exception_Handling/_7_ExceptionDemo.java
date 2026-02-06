package Oops._9_Exception;// handling vs ducking

class Demos
{
	public void a() throws Exception
	{
		System.out.println("in a");
		int value=9;
			
		b();

	}
	public void b() throws Exception
	{
		int num1=9;
		int num2=0;

		int result = num1 / num2;
		System.out.println(result);	
	}
}

public class _7_ExceptionDemo
{
	public static void main(String[] agrs) throws Exception {
		Demos obj=new Demos();
		obj.a();
	}
}

			