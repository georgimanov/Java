import java.util.Scanner;


public class _2_SequencesOfEqualStrings {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		String[] myArray = input.split(" ");
		
		for (int i = 0; i < myArray.length - 1; i++) {
			if ( myArray[i].equals( myArray[i + 1] )) {
				System.out.print( myArray[i] + " ");
			}
			else {
				System.out.println(myArray[i]);
			}
		}
		System.out.println(myArray[myArray.length - 1]);
	}
}
