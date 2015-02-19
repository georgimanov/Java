import java.util.Scanner;


public class _9_PointInsideTheHouse {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		String[] numbers = input.split(" ");
	
		float x1 = 17.5f;
		float y1 = 3.5f;
		float x2 = 22.5f;
		float y2 = 8.5f;
		float x3 = 12.5f;
		float y3 = 8.5f;
		
		float x = Float.parseFloat(numbers[0]);
		float y = Float.parseFloat(numbers[1]);
		
		Boolean insideBigFigure = false;
		Boolean insideSmallFigure = false;
		Boolean insideTriangle = false;
		
		
		if ( (x >= 12.5) & (x<= 17.5) & ( y >= 8.5) & (y<= 13.5)){
			insideBigFigure = true;	
		}
		if ( (x >= 20) & (x<= 22.5) & ( y >= 8.5) & (y <= 13.5) ){
			insideSmallFigure = true;
		}
		if (insideTriangle(x1, y1, x2, y2, x3, y3, x, y ) ){
			insideTriangle = true;
		}
			
			
		if ( (insideBigFigure == true) || (insideSmallFigure == true) || (insideTriangle == true) ){
			System.out.println("Inside");
		}
		else {
			System.out.println("Outside");
		}
	}

	private static boolean insideTriangle(float x1, float y1, float x2,
			float y2, float x3, float y3, float x, float y) {
		float A = area (x1, y1, x2, y2, x3, y3);
		float A1 = area (x, y, x2, y2, x3, y3);
		float A2 = area (x1, y1, x, y, x3, y3);
		float A3 = area (x1, y1, x2, y2, x, y);
		return (A == A1 + A2 + A3);
	}

	private static float area(float x1, float y1, float x2, float y2, float x3,
			float y3) {
		return  Math.abs(( x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1-y2))/2);
	}

	
	
	}
