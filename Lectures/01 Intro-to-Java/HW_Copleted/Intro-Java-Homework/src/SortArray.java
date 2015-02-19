import java.util.Arrays;
import java.util.Scanner;

public class SortArray {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter arr lenght : ");
		int arrLenght = input.nextInt();
		
		String[] strArray = new String[arrLenght];
		
		for (int i = 0; i < strArray.length; i++) {
			System.err.print("string " + (i + 1) + " : ");
			strArray[i] = input.next();
		}
		input.close();
		
		Arrays.sort(strArray);
		
		for (int i = 0; i < strArray.length; i++) {
			System.out.println(strArray[i]);
		}
		
		
	}

}
