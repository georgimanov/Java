import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;

public class Problem_1 {
	public static void main(String[] args) {
		Scanner readline = new Scanner(System.in);
		String input = readline.nextLine();

		Pattern wordPatern = Pattern.compile("[\\w]+");
		Matcher matcher = wordPatern.matcher(input);
		ArrayList<String> arr = new ArrayList<>();

		while (matcher.find()) {
			arr.add(matcher.group());
		}
			
		Set<String> set = new HashSet<>();
		boolean foundResut = false;
		for (int i = 0; i < arr.size(); i++) {
			for (int j = 0; j < arr.size(); j++) {
				for (int k = 0; k < arr.size(); k++) {
					if((arr.get(i).concat(arr.get(j))).equals(arr.get(k)) & arr.size() > 2){
						set.add(arr.get(i)+"|"+arr.get(j)+"="+arr.get(k));
						foundResut=true;
					}
				
				}
				
			}
		}
		if(!foundResut){
			System.out.println("No");
		} else {
			for (String result : set) {
				System.out.println(result);
			}
		}
	}
}
