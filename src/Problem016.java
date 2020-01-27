public class Problem016 {
	
	/*TASK: Find the sum of digits of 2^1000 */
	public static void main(String[] args) {
		int max = 1000;
		String result = "1";
		for (int i = 1; i <= max ; i ++){
			result = multiplyByTwo(result);
		}
		result = result.replaceFirst("^0+(?!$)", "");
		System.out.println("2 to the power of " + max + " is " + result);
		System.out.println("The sum of digits is " + sumOfDigits(result));
	}
	
	public static String multiplyByTwo(String number){
		String result = ""; 
		int carryOver = 0;
		
		for (int i = number.length() - 1; i >= 0; i--){
			// Calculate single digit
			int digit = Character.getNumericValue(number.charAt(i));
			int newDigit = ((digit * 2) + carryOver) % 10;
			carryOver = ((digit * 2) + carryOver) / 10;
			result = Integer.toString(newDigit) + result;
		}
		
		result = Integer.toString(carryOver) + result;
		return result;
	}
	
	public static int sumOfDigits(String number){
		int sumOfDigits = 0;
		for (int i = 0; i < number.length(); i++){
			sumOfDigits += Character.getNumericValue(number.charAt(i)); 
		}
		
		return sumOfDigits;
	}
}
