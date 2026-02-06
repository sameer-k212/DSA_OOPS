package Oops._9_Exception;

class Demo {
	public void a() {
		System.out.println("in a");
		b();  // Call method b
	}

	public void b() {
		int num1 = 9;
		int num2 = 0;
		try {
			int result = num1 / num2;  // Division by zero
			System.out.println(result);
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());  // Handles the exception
		}
	}
}

public class _6_ExceptionDemo {
	public static void main(String[] args) {
		Demo obj = new Demo();  // Corrected class name
		obj.a();
	}
}
