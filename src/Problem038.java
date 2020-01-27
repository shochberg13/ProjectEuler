public class Problem038 {
	public static void main(String[] args) {
		double timeStart = System.currentTimeMillis();
		long max = 0;
		// Check only up to 4 digits because two 5 digit numbers is 10 digits (too large)
		for (int i = 1; i < 9999; i++) { 
			String concat = "";
			for (int j = 1; j <= 9; j++) {
				int newNum = i * j;
				
				if(containsZeros(newNum)){
					break;
				}
				if(containsRepeats(newNum)){
					break;
				}
				if (containsRepeats(concat, newNum)) {
					break;
				} else {
					concat = concatenate(concat, newNum);
				}
			}
			if(isPandigital(concat)){
				System.out.println("Found a pandigital number: " + concat + " (i value is: " + i + ")");
				if(Long.parseLong(concat) > max){
					max = Long.parseLong(concat);
				}
			}
		}
		System.out.println("\nANSWER");
		System.out.println("Maximum: " + max);
		System.out.println("Time elapsed: " + (double)(System.currentTimeMillis() - timeStart) / 1000.00 +" seconds");
	
	
	}

	public static String concatenate(int num1, int num2) {
		return Integer.toString(num1) + Integer.toString(num2);
	}

	public static String concatenate(String num1, int num2) {
		return num1 + Integer.toString(num2);
	}

	public static String concatenate(int num1, String num2) {
		return Integer.toString(num1) + num2;
	}

	public static boolean isPandigital(String number) {
		if (number == null) {
			return false;
		}

		if(number.contains("1") && number.contains("2") && 	number.contains("3") && 
				number.contains("4") && number.contains("5") && number.contains("6") && 
				number.contains("7") && number.contains("8") && number.contains("9") ){
			return true;
		}
		return false;
	}

	public static boolean containsZeros(int newNumber){
		String newNum = Integer.toString(newNumber);
		if(newNum.contains("0")){
			return true;
		}
		return false;
	}
	
	public static boolean containsRepeats(String concat, int newNumber) {
		String newNum = Integer.toString(newNumber);
		for (int i = 0; i < newNum.length(); i++) {
			if (concat.contains(Character.toString(newNum.charAt(i)))) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean containsRepeats(int newNumber) {
		String newNum = Integer.toString(newNumber);
		for (int i = 0; i < newNum.length(); i++) {
			for (int j = i + 1; j < newNum.length(); j++){
				if (newNum.charAt(i) == newNum.charAt(j)){
					return true;
				}
			}
		}
		return false;
	}
}
