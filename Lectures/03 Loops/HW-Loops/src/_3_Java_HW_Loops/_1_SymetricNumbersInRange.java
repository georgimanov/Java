package _3_Java_HW_Loops;

import java.util.Scanner;

import jdk.internal.org.objectweb.asm.util.CheckAnnotationAdapter;

public class _1_SymetricNumbersInRange {
	public static void main(String[] args) {
	
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		String[] numbers = input.split(" ");
		int start = Integer.parseInt(numbers[0]);
		int end = Integer.parseInt(numbers[numbers.length -1]);
		
		for (int i = start ; i <= end; i++) {
			String currentNumber = String.valueOf(i); 
			if (numberIsSymetric(currentNumber)) {
				System.out.print(currentNumber + " ");
			}
		}
		
	}

	public static boolean numberIsSymetric(String number) {
		Boolean isSymetric = true;
		for (int i = 0; i < number.length() - 1; i++) {
			if (number.charAt(i) != number.charAt(number.length() - i -1)){
				isSymetric = false;
			}
		}
		return isSymetric;
	}
}
