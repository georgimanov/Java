import java.util.Scanner;

public class SumTwoNumbers {
	public static void main(String[] args)
	{
		Scanner inNumber = new Scanner(System.in);
		System.out.println("Enter first integer number:");
		int a = inNumber.nextInt();
		System.out.println("Enter second integer number:");
		int b = inNumber.nextInt();
		inNumber.close();
		System.out.println(a + b);
	}
		
}
