import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.Scanner;

public class Problem_4 {
	public static void main(String[] args) {
		Scanner readline = new Scanner(System.in);
		String skipline1 = readline.nextLine();
		String skipline2 = readline.nextLine();
		String skipline3 = readline.nextLine();
		
		String input = null;
		
		ArrayList<String> stringList = new ArrayList<>();
		while(!(input = readline.nextLine()).contains("-")){
			Pattern wordPatern = Pattern.compile("[A-Za-z.0-9]+");
			Matcher matcher = wordPatern.matcher(input);
			while (matcher.find()) {
			stringList.add(matcher.group());

			for (String string : stringList) {
				System.out.println(string);
			}
		}
		
	}
}
}
