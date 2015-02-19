import java.util.Scanner;

public class _6_CountSpecificWord {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String sentence = in.nextLine().toLowerCase();
		String word = in.nextLine().toLowerCase();
		String[] str = sentence.split("\\W+");
		int counter = 0;

		for (int i = 0; i < str.length; i++) {
			if (word.equals(str[i])) {
				counter++;
			}
		}
		System.out.println(counter);
	}
}
