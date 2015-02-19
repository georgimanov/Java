import java.util.Scanner;


public class Coordinates {
public static void main(String[] args) {
		
		float x = 0f;
		float y = 0f;
		
		Scanner scan = new Scanner(System.in);
		
		x = scan.nextFloat();
		y = scan.nextFloat();
		
		if ( x == 0 && y == 0) { System.out.println(0);	}
		else if (x > 0 && y > 0 ) {	System.out.println(1);	}
		else if (x < 0 && y > 0 ) {	System.out.println(2);	}
		else if (x < 0 && y < 0 ) {	System.out.println(3);	}
		else if (x > 0 && y < 0 ) {	System.out.println(4);	}
		else if (y == 0 ) {	System.out.println(6);	}
		else if (x == 0 ) {	System.out.println(5);	}

}
}
