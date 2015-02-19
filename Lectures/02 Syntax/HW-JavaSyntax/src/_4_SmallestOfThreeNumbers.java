import java.util.Scanner;


public class _4_SmallestOfThreeNumbers {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a : ");
		float a = input.nextFloat();
		System.out.print("Enter b : ");
		float b = input.nextFloat();
		System.out.print("Enter b : ");
		float c = input.nextFloat();
		
		float smallestNumber = Float.MAX_VALUE;
		
		if ( smallestNumber > a){ smallestNumber = a; }
		if ( smallestNumber > b){ smallestNumber = b; }
		if ( smallestNumber > c){ smallestNumber = c; }
		
		System.out.println(smallestNumber);
		//input.close();
	}

}
