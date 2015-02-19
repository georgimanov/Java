import java.util.Scanner;


public class _3_PointInsideFigure {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		String[] numbers = input.split(" ");
	
		float x = Float.parseFloat(numbers[0]);
		float y = Float.parseFloat(numbers[1]);
		
		Boolean insideBigFigure = false;
		Boolean insideSmallFigure = false;
		
		if ( (x >= 12.5) & (x<= 22.5) & ( y >= 6) & (y<= 13.5)){
			insideBigFigure = true;
			if ( (x >= 17.5) & (x<= 0) & ( y >= 8.5) & (y <= 13.5) ){
				insideSmallFigure = true;
			}
		}
		if ( (insideBigFigure == true) & (insideSmallFigure == false) ){
			System.out.println("Inside");
		}
		else {
			System.out.println("Outside");
		}
	}
}
