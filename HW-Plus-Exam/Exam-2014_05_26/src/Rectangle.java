import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.*;

public class Rectangle {

	public static void main(String[] args) {
		Scanner readline = new Scanner(System.in);
		String input = readline.nextLine();

		Pattern digitPattern = Pattern.compile("[\\d+]+");
		Matcher matcher = digitPattern.matcher(input);
		ArrayList<Integer> arr = new ArrayList<>();

		while (matcher.find()) {
			arr.add(Integer.parseInt(matcher.group()));
		}
		int tempSum = 0;
		int bestSum = -1;

		int i =0;
		do {
			tempSum = arr.get(i) * arr.get(i+1) + arr.get(i+2) * arr.get(i+3) + arr.get(i+4) * arr.get(i+5);
			if(tempSum>=bestSum){
				bestSum=tempSum;
			}
			i+=2;
		} while (i<arr.size()-5);
		System.out.println(bestSum);
	}
}
