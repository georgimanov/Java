import java.util.Arrays;
import java.util.Scanner;

public class _1_SortArrayOfNumbers {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = Integer.parseInt(scanner.nextLine());
		String input = scanner.nextLine();
		String[] tempArr = input.split(" ");
		Integer[] myArr = new Integer[tempArr.length];
		
		for (int i = 0; i < tempArr.length; i++) {
			myArr[i] = Integer.parseInt((tempArr[i]));
		}
		
		Arrays.sort(myArr);
		
		for (int i = 0; i < myArr.length; i++) {
			System.out.print("" + myArr[i] + " ");
		}
		

	}

}
