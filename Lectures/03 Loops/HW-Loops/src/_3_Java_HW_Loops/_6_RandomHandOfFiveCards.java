package _3_Java_HW_Loops;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class _6_RandomHandOfFiveCards {

	public static void main(String[] args) throws InterruptedException {
		
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int counter = 0;
		
		String[] cardFaces = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A" };
		char[] cardSings = { '♣', '♦', '♥', '♠' };
		String[] cards = new String[52];
		int initCards = 0;

		for (int j = 0; j < cardFaces.length; j++) {
			for (int i = 0; i < cardSings.length; i++) {
				cards[initCards] = cardFaces[j] + cardSings[i];
				initCards++;
			}
		}
		
		HashSet<String> currentHand = new HashSet<String>();
		Random rand = new Random();

		while (counter < n) {
			do {
				currentHand.add( cards[rand.nextInt(52)]);
				
			} while (currentHand.size() < 5);
			System.out.println(currentHand.toString());
			currentHand.clear();
			counter++;
		}
	}
}
