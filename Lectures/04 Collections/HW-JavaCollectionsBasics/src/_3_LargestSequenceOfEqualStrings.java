import java.util.Scanner;

import sun.tools.jar.resources.jar;

public class _3_LargestSequenceOfEqualStrings {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		String[] myArray = scanner.nextLine().split(" ");

		int bestIndex = 0;
		int bestLen = 1;
		String bestSequence = myArray[0];

		int position = 0;
		int counter = 1;
		String tempStr = myArray[0];
		int index = 1;

		for (int i = 0; i < myArray.length - 1; i++) {
			index = 1;
			while (index < myArray.length - i  && myArray[i].equals(myArray[i + index])) {
				counter++;
				position = i;
				tempStr = myArray[i];
				index++;
			}
			if (counter > bestLen) {
				bestSequence = tempStr;
				bestLen = counter;
				bestIndex = position;
			}
			counter = 1;
			position = 0;
			tempStr = "";
		}

		for (int i = 0; i < bestLen; i++) {
			System.out.print(bestSequence + " ");
		}
		
//		System.out.println("Sequence " + bestSequence);
//		System.out.println("Counter " + bestLen);
//		System.out.println("Start Pos " + bestIndex);

	}

}
