package _3_Java_HW_Loops;
 
import java.util.Scanner;
 
public class _5_AngleUnitConverter {
 
        public static void main(String[] args) {
                Scanner in = new Scanner(System.in);
                int n = in.nextInt();
                String input = "";
                String measure = "";
 
                for (int i = 0; i <= n; i++) {
                        input = in.nextLine();
                        input = input.replaceAll("\\s+", "");
                        measure = input.replaceAll("\\d+", "");
                        measure = measure.replace(".", "");
                        input = input.replaceAll("[^0-9.,]+", "");
 
                        if (measure.equals("deg")) {
                                System.out.format("%.6f rad%n",
                                                degreesToRadians(Double.parseDouble(input)));
                        } else if (measure.equals("rad")) {
                                System.out.format("%.6f deg%n",
                                                radiansToDegrees(Double.parseDouble(input)));
                        }
                }
        }
 
        public static double degreesToRadians(double degrees) {
                double convertedValue = degrees * 0.0174532925;
                return convertedValue;
        }
 
        public static double radiansToDegrees(double degrees) {
                double convertedValue = degrees / 0.0174532925;
                return convertedValue;
        }
}
