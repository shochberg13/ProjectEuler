public class Problem055 {
	public static void main(String[] args) {
		int counter = 0;
		for (int i = 0; i < 10000; i++){
			if (isLychrel(Integer.toString(i))){
				counter++;
				System.out.println("Lychrel Number Found: " + i);
			}
		}
		System.out.println("\n\nANSWER");
		System.out.println("There are " + counter + " Lychrel numbers below 10k.");
		
	}
	
	public static boolean isLychrel(String number){
		
		String newSum = number;
		for (int i = 1; i <= 60; i++){
			newSum = add(newSum, reverseNumber(newSum));
			if (isPalindrome(newSum)){
				return false;
			}
		}
		return true;
	}
	
	public static String reverseNumber(String num){
		String reverseNum = "";
		
		for (int i = 0; i < num.length(); i++){
			reverseNum = num.charAt(i) + reverseNum;
		}
		
		return reverseNum;
	}
	
	public static String add(String num1, String num2){
		assert(num1.length() == num2.length());
		
		int digitAdder;
		int carryOver = 0;
		String finalSum = "";

		for (int i = num1.length() - 1; i >= 0; i--) {
			digitAdder = 0;
			digitAdder += Character.getNumericValue(num1.charAt(i));
			digitAdder += Character.getNumericValue(num2.charAt(i));
			digitAdder += carryOver;

			carryOver = digitAdder / 10;
			String newDigit = Integer.toString(digitAdder % 10);
			finalSum = newDigit + finalSum;
		}
		
		if (carryOver > 0) {
			finalSum = Integer.toString(carryOver) + finalSum;
		}
		
		return finalSum;
	}
	
	public static boolean isPalindrome(String number){
		for (int i = 0; i < number.length() / 2; i++){
			if(number.charAt(i) != number.charAt(number.length() - (i + 1))){
				return false;
			}
		}
		return true;
	}
}
