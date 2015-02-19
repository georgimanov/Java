import java.util.Scanner;

public class Problem_2 {
	public static void main(String[] args) {
		Scanner readline = new Scanner(System.in);

		double cX = readline.nextInt();
		double cY = readline.nextInt();
		double radius = readline.nextInt();
		double counter = readline.nextInt();
		Double[] shots = new Double[(int) (counter*2)];
		
		double cX1 = cX - radius;
		double cY1 = cY - radius/2;
		double cX1_up = cX1 + radius*2;
		double cY1_up = cY1 + radius;
	
		double cX2 = cX - radius/2;
		double cY2 = cY - radius;
		double cX2_up = cX2 + radius;
		double cY2_up = cY2 + radius/2;
	
		double cX3 = cX - radius/2; 
		double cY3 = cY + radius /2;
		double cX3_up = cX3 + radius;
		double cY3_up = cY3 + radius/2;
		
		for (int i = 0; i < shots.length; i++) {
			shots[i]= readline.nextDouble();
		}
		
		for (int i = 0; i < shots.length; i+=2) {
			double x = shots[i];
			double y = shots[i+1];
			
			if ( (x >= cX1) && (x<= cX1_up)  && ( y >= cY1) && (y <= cY1_up ) ) {
				System.out.println("yes");
			} else if ((x >= cX2) && (x <= cX2_up ) && ( y >= cY2) && (y <= cY2_up )) {
				System.out.println("yes");
			} else if ((x >= cX3) && (x<= cX3_up ) && ( y >= cY3) && (y <= cY3_up )) {
				System.out.println("yes");
			} else {
				System.out.println("no");
			}
		}
	}
}
