import java.util.Scanner;

public class _2_TriangleArea {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("enter aX = ");
		long aX = input.nextLong();
		System.out.print("enter aY = ");
		long aY = input.nextLong();
		
		System.out.print("enter bX = ");
		long bX = input.nextLong();
		System.out.print("enter bY = ");
		long bY = input.nextLong();
		
		System.out.print("enter cX = ");
		long cX = input.nextLong();
		System.out.print("enter cY = ");
		long cY = input.nextLong();
		
		
		long area = Math.abs(((aX * (bY - cY)) + (bX * (cY - aY)) + (cX* (aY - bY))) / 2);
		System.out.println(area);
		input.close();
		
	}
}
