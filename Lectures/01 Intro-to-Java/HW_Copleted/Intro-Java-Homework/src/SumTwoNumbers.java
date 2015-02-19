import java.util.Scanner;

public class SumTwoNumbers {
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter first integer number: ");
		int a = input.nextInt();
		
		System.out.print("Enter second integer number: ");
		int b = input.nextInt();
		input.close();
		System.out.print("The sum is = ");
		System.out.println(a + b);
	}
		
}
