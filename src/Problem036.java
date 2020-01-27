
public class Problem036 {
	public static void main(String[] args) {
		
		int sumOfPalindromes = 0;
		for (int i = 1; i < 1000000; i++){
			if (isPalindrome(i) && isPalindrome(baseTentoBaseTwo(i))){
				sumOfPalindromes += i;
				System.out.println("Super Palindrome: " + i + "\t" + baseTentoBaseTwo(i) + "\tSum: " + sumOfPalindromes);
			}
		}
	}
	
	public static boolean isPalindrome(String numberString){
		for (int i = 0; i < numberString.length()/2 ; i++){
			if (numberString.charAt(i) != numberString.charAt(numberString.length() - (i + 1))){
				return false;
			}
		}
		return true;
	}
	
	public static boolean isPalindrome(int number){
		String numberString = Integer.toString(number);
		return isPalindrome(numberString);
	}
	
	public static String baseTentoBaseTwo(int number){
		return Integer.toBinaryString(number);
	}
}
