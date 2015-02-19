import java.util.Arrays;
import java.util.Scanner;


public class PythagoreanNumbers {

	public static void main(String[] args) {
		
		Scanner readline = new Scanner(System.in);
		int n = Integer.parseInt(readline.nextLine());
		Integer[] myArr = new Integer[n];
		boolean result=false;
		for (int i = 0; i < n; i++) {
			myArr[i] = Integer.parseInt(readline.nextLine());
		}
		for (int i = 0; i < myArr.length; i++) {
			for (int j = 0; j < myArr.length; j++) {
				for (int k = 0; k < myArr.length; k++) {
					if(myArr[i] <= myArr[j]){
					if ( myArr[i]*myArr[i] + myArr[j]*myArr[j] == myArr[k]*myArr[k]){
						System.out.println(myArr[i]+"*"+myArr[i] + " + " + myArr[j]+"*"+myArr[j]+" = "+myArr[k]+"*"+myArr[k]);
						result=true;
					}
					}
				}
			}
		}
		if(!result){
			System.out.println("No");
		}

	}
}
