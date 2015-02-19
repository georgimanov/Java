import java.awt.datatransfer.StringSelection;
import java.util.Scanner;


public class _5_DecimalOrHexaDecimal {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Integer number = input.nextInt();
		
		String hex = Integer.toHexString(number).toUpperCase();
		System.out.println(hex);
	}

}
