public class Problem040 {
	public static void main(String[] args) {
		double timeStart = System.currentTimeMillis();
		int newNumberOfDigits = 0;
		int oldNumberOfDigits = 0;
		int answer = 1;
		boolean digitAFound = false; // 1st digit
		boolean digitBFound = false; // 10th digit
		boolean digitCFound = false; // 100th digit
		boolean digitDFound = false; // 1000th digit
		boolean digitEFound = false; // 10000th digit
		boolean digitFFound = false; // 100000th digit
		boolean digitGFound = false; // 1000000th digit

		for (int i = 1; newNumberOfDigits <= 1000000; i++) {
			
			oldNumberOfDigits = newNumberOfDigits;
			newNumberOfDigits += Integer.toString(i).length();
//			System.out.println("i " + i + "\tNumberOfDigits: " + newNumberOfDigits );
			
			// Digit A
			if (newNumberOfDigits >= 1 && !digitAFound) {
				int temp = 0;
				answer *= Character.getNumericValue(Integer.toString(i).charAt(temp));
				System.out.println("DIGIT A: " + Character.getNumericValue(Integer.toString(i).charAt(temp)));
				digitAFound = true;
			}

			// Digit B
			if (newNumberOfDigits >= 10 && !digitBFound) {
				int temp = 9 - oldNumberOfDigits;
				answer *= Character.getNumericValue(Integer.toString(i).charAt(temp));
				System.out.println("DIGIT B: " + Character.getNumericValue(Integer.toString(i).charAt(temp)));
				digitBFound = true;
			}
			
			// Digit C
			if (newNumberOfDigits >= 100 && !digitCFound) {
				int temp = 99 - oldNumberOfDigits;
				answer *= Character.getNumericValue(Integer.toString(i).charAt(temp));
				System.out.println("DIGIT C: " + Character.getNumericValue(Integer.toString(i).charAt(temp)));
				digitCFound = true;
			}
			
			// Digit D
			if (newNumberOfDigits >= 1000 && !digitDFound) {
				int temp = 999 - oldNumberOfDigits;
				answer *= Character.getNumericValue(Integer.toString(i).charAt(temp));
				System.out.println("DIGIT D: " + Character.getNumericValue(Integer.toString(i).charAt(temp)));
				digitDFound = true;
			}
			
			// Digit E
			if (newNumberOfDigits >= 10000 && !digitEFound) {
				int temp = 9999 - oldNumberOfDigits;
				answer *= Character.getNumericValue(Integer.toString(i).charAt(temp));
				System.out.println("DIGIT E: " + Character.getNumericValue(Integer.toString(i).charAt(temp)));
				digitEFound = true;
			}
			
			// Digit F
			if (newNumberOfDigits >= 100000 && !digitFFound) {
				int temp = 99999 - oldNumberOfDigits;
				answer *= Character.getNumericValue(Integer.toString(i).charAt(temp));
				System.out.println("DIGIT F: " + Character.getNumericValue(Integer.toString(i).charAt(temp)));
				digitFFound = true;
			}
			
			// Digit G
			if (newNumberOfDigits >= 1000000 && !digitGFound) {
				int temp = 999999 - oldNumberOfDigits;
				answer *= Character.getNumericValue(Integer.toString(i).charAt(temp));
				System.out.println("DIGIT G: " + Character.getNumericValue(Integer.toString(i).charAt(temp)));
				digitGFound = true;
			}
		}

		System.out.println(answer);

		System.out.println("ANSWER: The answer is: " + answer);
		System.out.println("Time elapsed: " + (double) ((System.currentTimeMillis() - timeStart) / 1000.000) + " seconds");
	}
}
