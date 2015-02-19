package _3_Java_HW_Loops;

import java.util.Scanner;

public class _2_GenerateThreeLetterWords {
	public static void main(String[] args) {
	
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
				
		for (int i1 = 0; i1 < input.length(); i1++) {
			for (int i2 = 0; i2 < input.length(); i2++) {
				for (int i3 = 0; i3 < input.length(); i3 ++) {
					System.out.println("" + input.charAt(i1) + input.charAt(i2) + input.charAt(i3));
				}
			}
		}
	}
}
