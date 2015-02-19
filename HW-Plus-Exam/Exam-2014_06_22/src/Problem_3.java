import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem_3 {
	public static void main(String[] args) {
		Scanner readLine = new Scanner(System.in);
		String input = readLine.nextLine();

		boolean resultfound = false;

		Pattern wordPatern = Pattern.compile("[\\w]+");
		Matcher matcher = wordPatern.matcher(input);
		ArrayList<String> arrayCards = new ArrayList<>();

		while (matcher.find()) {
			arrayCards.add(matcher.group());
		}
		Set<String> set = new HashSet();

		for (int i1 = 0; i1 < arrayCards.size(); i1++) {
			for (int i2 = 0; i2 < arrayCards.size(); i2++) {
				for (int i3 = 0; i3 < arrayCards.size(); i3++) {
					for (int i4 = 0; i4 < arrayCards.size(); i4++) {
						for (int i5 = 0; i5 < arrayCards.size(); i5++) {
							boolean suit = checkSameSuit(arrayCards.get(i1),
									arrayCards.get(i2), arrayCards.get(i3),
									arrayCards.get(i4), arrayCards.get(i5));
							boolean cards = checkConsecutiveCards(
									arrayCards.get(i1), arrayCards.get(i2),
									arrayCards.get(i3), arrayCards.get(i4),
									arrayCards.get(i5));
							if (suit && cards) {
									set.add("[" + arrayCards.get(i1) + ", "
											+ arrayCards.get(i2) + ", "
											+ arrayCards.get(i3) + ", "
											+ arrayCards.get(i4) + ", "
											+ arrayCards.get(i5) + "]");
									resultfound = true;
								}
							}
						}
					}
				}
			}

			if (!resultfound) {
				System.out.println("No Straight Flushes");
			} else {
				for (String result : set) {
					System.out.println(result);
				}
			}
		
	}

	private static boolean checkSameSuit(String a, String b, String c,
			String d, String e) {
		boolean sameSuit = false;
		if (a.charAt(a.length() - 1) == b.charAt(b.length() - 1)
				&& a.charAt(a.length() - 1) == c.charAt(c.length() - 1)
				&& a.charAt(a.length() - 1) == d.charAt(d.length() - 1)
				&& a.charAt(a.length() - 1) == e.charAt(e.length() - 1)) {
			sameSuit = true;
		}
		return sameSuit;
	}

	private static boolean checkConsecutiveCards(String a, String b, String c,
			String d, String e) {
		boolean consecutiveCards = false;

		if ((calculateWeight(a.charAt(0)) + 1) == calculateWeight(b.charAt(0)) && (calculateWeight(a.charAt(0)) + 2) == calculateWeight(c.charAt(0)) && (calculateWeight(a.charAt(0)) + 3) == calculateWeight(d.charAt(0))
				&& (calculateWeight(a.charAt(0)) + 4) == calculateWeight(e.charAt(0))) {
			consecutiveCards = true;
		}

		return consecutiveCards;
	}

	private static int calculateWeight(char charAt) {
		int weight = 0;
		switch (charAt) {
		case '2':
			weight = 2;
			break;
		case '3':
			weight = 3;
			break;
		case '4':
			weight = 4;
			break;
		case '5':
			weight = 5;
			break;
		case '6':
			weight = 6;
			break;
		case '7':
			weight = 7;
			break;
		case '8':
			weight = 8;
			break;
		case '9':
			weight = 9;
			break;
		case '1':
			weight = 10;
			break;
		case 'J':
			weight = 11;
			break;
		case 'Q':
			weight = 12;
			break;
		case 'K':
			weight = 13;
			break;
		case 'A':
			weight = 14;
			break;
		default:
			break;
		}
		return weight;
	}
}