/*
Magic Car Numbers
Cars in Sofia have registration numbers in format "CAabcdXY" where a, b, c and d are digits from 0 to 9 and X and Y are letters from the following subset of the Latin alphabet: 'A', 'B', 'C', 'E', 'H', 'K', 'M', 'P', 'T' and 'X'. Examples of car numbers from Sofia are "CA8517TX", "CA2277PC", "CA0710XC", "CA1111AC", while "CC7512FJ" in not valid car number from Sofia. Local people are keen to choose special numbers for their cars, know as magic car numbers. They calculate the weight of a car number as follows: they sum its digits and letters, assuming that letters have the following values: 'A'  10, 'B'  20, 'C'  30, 'E'  50, 'H'  80, 'K'  110, 'M'  130, 'P'  160, 'T'  200, 'X'  240. For example the weight("CA6511BM") = 30 + 10 + 6 + 5 + 1 + 1 + 20 + 130 = 203. A magic car number is a car number that has a special magic weight (e.g. 256 or 512 for developers) and its number is in some of the formats "CAaaaaXY", "CAabbbXY", "CAaaabXY", "CAaabbXY", "CAababXY" and "CAabbaXY", where a and b are two different digits and X and Y are letters from the Latin alphabet subset { 'A', 'B', 'C', 'E', 'H', 'K', 'M', 'P', 'T', 'X' }.
Your task is to write a program that calculates how many cars can be registered in Sofia for given magic weight.

 */

import java.util.Scanner;
public class MagicCarNumbers {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		long magicWeight = scanner.nextLong();
		long sum = 40;
		int counter = 0;
		int[] weight = {10, 20, 30, 50, 80, 110, 130, 160, 200, 240};
		for (int i1 = 0; i1 <= 9; i1++) {
			for (int i2 = 0; i2 <= 9; i2++) {
				for (int i3 = 0 ; i3 <= 9; i3++) {
					for (int i4 = 0 ; i4 <= 9; i4++) {
						for (int i5 = 0; i5 < weight.length; i5++) {
							for (int i6 = 0; i6 < weight.length; i6++) {
								sum += + i1 + i2 + i3 + i4 + weight[i5] + weight[i6];
								if (magicWeight == sum) {
									if(i1 == i2 && i2 == i3 && i3 == i4 ) { counter ++;} 		//aaaa
									else if ( i1 != i2 && i2 == i3 && i3 == i4) { counter++;}	//abbb
									else if ( i1 == i2 && i2 == i3 && i3 != i4) { counter++;}	//aaab
									else if ( i1 == i2 && i2 != i3 && i3 == i4) { counter++;}	//aabb
									else if ( i1 == i3 && i1 != i2 && i2 == i4) { counter++;}	//abab
									else if ( i1 == i4 && i1 != i2 && i2 == i3) { counter++;}	//abba
								}
								sum = 40;
							}
						}
					}
				}
			}
		}
		System.out.println(counter);
	}
}
