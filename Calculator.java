import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Calculator {
	private static Pattern regex = Pattern.compile("([0-9]+)([+*])([0-9]+)=");

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println(calc(sc.nextLine()));
		sc.close();
	}
	
	public static String calc(String expr) {
		while(true) {
			Matcher matcher = regex.matcher(expr);
			if(matcher.find()) {
				expr = matcher.replaceFirst(calcSingle(matcher.group(1), matcher.group(2), matcher.group(3)));
			} else {
				break;
			}
		}
		
		return expr;
	}
	
	public static String calcSingle(String num1, String op, String num2) {
		if(op.equals("+")) {
			return String.valueOf(Integer.valueOf(num1) + Integer.valueOf(num2));
		} else if(op.equals("*")) {
			return String.valueOf(Integer.valueOf(num1) * Integer.valueOf(num2));
		}
		
		return null;
	}
}