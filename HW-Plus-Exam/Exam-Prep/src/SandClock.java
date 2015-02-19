import java.util.Scanner;

public class SandClock {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();

		// upper part
		for (int i = 0; i < n / 2 + 1; i++) {
			PrintChar('.', i);
			PrintChar('*', n - i * 2);
			PrintChar('.', i);
			System.out.println();
		}
		//lower part
		for (int i = n / 2 - 1; i >= 0; i--) {
			PrintChar('.', i);
			PrintChar('*', n - i * 2);
			PrintChar('.', i);
			System.out.println();
		}
	}

	public static void PrintChar(char character, int repeat) {
		for (int i = 0; i < repeat; i++) {
			System.out.print(character);
		}

	}

}