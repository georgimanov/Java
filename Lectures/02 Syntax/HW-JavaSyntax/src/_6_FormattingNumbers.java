import java.util.Scanner;


public class _6_FormattingNumbers {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int first = scan.nextInt(); 
		float second = scan.nextFloat(); 
		float third = scan.nextFloat(); 
		
		String hex = Integer.toHexString(first).toUpperCase();
		String binaryString = String.format("%10s", Integer.toBinaryString(first)).replace(' ', '0');
		System.out.printf("|%-10s|%-10s|%10.2f|%-10.3f|\n", hex, binaryString, second, third);
	}
}
