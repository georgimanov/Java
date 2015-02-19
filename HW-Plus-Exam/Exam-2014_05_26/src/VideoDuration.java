import java.util.Scanner;


public class VideoDuration {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String readline = null ;
		
		String[] input = new String[2];
		int[] myArr = new int[2];
		
		
		long hours=0;
		long minutes = 0;
		long totalMinutes;
		while(!(readline=scanner.nextLine()).equals("End")){
			input = readline.split(":");
			hours += Long.parseLong(input[0]);
			minutes += Long.parseLong(input[1]);
		}
		if (minutes / 60 > 0)
		{
			totalMinutes = minutes % 60;
			hours += minutes / 60;
			
		} else {
			 totalMinutes = minutes;
		}
		
		System.out.printf("%d:",hours);
		if(totalMinutes==0)
		{
			System.out.println("00");
		}else if (totalMinutes<10) {
			System.out.println("0"+ totalMinutes);
		}else {
			System.out.println(totalMinutes);
		}
		
		
	}
}
