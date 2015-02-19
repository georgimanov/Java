import java.util.Scanner;


public class _8_CountOfEqualBitPairs {
	public static void main(String[] args) {
	
		Scanner scan = new Scanner(System.in);
		long number = scan.nextLong();
		String binary = Long.toBinaryString(number);
		int counter = 0;
		for (int i = 0; i < binary.length() - 1; i++) {
			if (binary.charAt(i) == binary.charAt(i + 1)  ){ counter++;}
		}
		System.out.println("Binary representation : " + binary);
		System.out.println("Counter of equal bit pairs = " + counter);
	}
}
