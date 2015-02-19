package _3_Java_HW_Loops;

import java.util.Arrays;
import java.util.HashSet;

public class _3_FullHouse {
	public static void main(String[] args) {

		String[] cardFaces = { "2", "3", "4", "5", "6", "7", "8", "9", "10",
				"J", "Q", "K", "A" };
		char[] cardSings = { '♣', '♦', '♥', '♠' };
		String[] cards = new String[52];
		int initCards = 0;

		for (int j = 0; j < cardFaces.length; j++) {
			for (int i = 0; i < cardSings.length; i++) {
				cards[initCards] = cardFaces[j] + cardSings[i];
				initCards++;
			}
		}

		HashSet<String> tempUniqueFullHouseCombinations = new HashSet<String>();

		int counter = 0;

		for (int i1 = 0; i1 < 48; i1++) {
			for (int i2 = i1 + 1; i2 < 49; i2++) {
				for (int i3 = i2 + 1; i3 < 50; i3++) {
					for (int i4 = i3 + 1; i4 < 51; i4++) {
						for (int i5 = i4 + 1; i5 < 52; i5++) {

							String[] tempArr = { cards[i1], cards[i2],
									cards[i3], cards[i4], cards[i5] };
							
							Arrays.sort(tempArr);

							for (int i = 0; i < tempArr.length; i++) {
								tempUniqueFullHouseCombinations.add(tempArr[i]);
							}
							if (tempUniqueFullHouseCombinations.size() == 5) {
								if (CheckHand(cards[i1], cards[i2], cards[i3],
										cards[i4], cards[i5])) {
									System.out.println(" " + cards[i1]
											+ cards[i2] + cards[i3] + cards[i4]
											+ cards[i5]);
									counter++;
								}
							}
							tempUniqueFullHouseCombinations.clear();
						}
					}
				}
			}
		}
		System.out.println(counter);

	}

	private static boolean CheckHand(String card1, String card2, String card3,
			String card4, String card5) {
		boolean isFullHouse = false;
		char[] cardFaces = { card1.charAt(0), card2.charAt(0), card3.charAt(0),
				card4.charAt(0), card5.charAt(0) };
		if (cardFaces[0] == cardFaces[1] && cardFaces[0] == cardFaces[2]) {
			if (cardFaces[0] != cardFaces[3] && cardFaces[3] == cardFaces[4]) {
				isFullHouse = true;
			}
		} else {
			if (cardFaces[0] == cardFaces[1]
					&& cardFaces[0] != cardFaces[2]
					&& (cardFaces[2] == cardFaces[3] && cardFaces[2] == cardFaces[4])) {
				isFullHouse = true;
			}
		}
		return isFullHouse;
	}
}