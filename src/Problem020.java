public class Problem020 {
	/*TASK: Find the sum of the digits in 100!	 */
	public static void main(String[] args) {
		System.out.println(multiply("8888", 11));
		
		String largeNumber = "1";
		int max = 100;
		for (int i = 2; i <= max; i++){
			largeNumber = multiply(largeNumber, i);
		}
		
		System.out.println("ANSWER");
		System.out.println(max + "! is " + largeNumber);
		System.out.println("The sum of digits of " + max + "! is " + sumOfDigits(largeNumber));
	}
	
	public static String multiply(String largeNumberBefore, int number2){
		String largeNumberAfter = "";
		int carryOver = 0;
		
		for (int i = largeNumberBefore.length() - 1; i >= 0; i--){
			int digit = Character.getNumericValue(largeNumberBefore.charAt(i));
			int newDigit = ((digit * number2) + carryOver) % 10;
			carryOver = ((digit * number2) + carryOver) / 10;
			
			largeNumberAfter = newDigit + largeNumberAfter;
		}
		largeNumberAfter = carryOver + largeNumberAfter;
		largeNumberAfter = largeNumberAfter.replaceFirst("^0*", "");
		return largeNumberAfter;
	}
	
	public static int sumOfDigits(String largeNumber){
		int sumOfDigits = 0;
		for (int i = 0; i < largeNumber.length(); i++){
			sumOfDigits += Character.getNumericValue(largeNumber.charAt(i));
		}
		return sumOfDigits;
	}
}
