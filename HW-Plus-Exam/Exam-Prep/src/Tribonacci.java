import java.math.BigInteger;
import java.util.Scanner;

public class Tribonacci {
	public static void main(String[] args) {
		BigInteger tN, t1, t2, t3;
		long element = 0;

		Scanner scanner = new Scanner(System.in);

		t1 = scanner.nextBigInteger();
		t2 = scanner.nextBigInteger();
		t3 = scanner.nextBigInteger();
		element = scanner.nextLong();

		tN = Tribonacci(t1, t2, t3, element);
		System.out.println(tN);
	}

	public static BigInteger Tribonacci(BigInteger t1, BigInteger t2, BigInteger t3, long element) {
		BigInteger tN = null;
		
		if ( element < 4){
			if ( element ==  1) { return t1;
			}else if ( element == 2) { return t2;
			}else if ( element == 3) { return t3;}
			}else { 
				for (int i = 0; i < element - 3; i++) {
					tN = t1.add(t2).add(t3);
					t1 = t2;
					t2 = t3;
					t3 = tN;
				}
			}
		return t3;
	}
}
