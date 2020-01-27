public class Problem048 {
	/*TASK: Find the last 10 digits of the sum of the series 1^1 + 2^2 + ... + 1000^1000	 */
	public static void main(String[] args) {
		double timeStart = System.currentTimeMillis();
		String number = sumOfSeries(1000);
		System.out.println("\nANSWER");
		System.out.println("The last ten digits are: " + lastTenDigits(number));
		System.out.println("Time elapsed: " + (System.currentTimeMillis() - timeStart) / 1000 + " seconds");
	}
	

	
	public static String sumOfSeries(int seriesLength){
		String finalSum = "";
		
		for (int i = 1; i <= seriesLength; i++){
			System.out.println("Progress: " + i + " / " + seriesLength);
			String temp = Integer.toString(i);
			for (int j = 1; j < i; j++){
				
				temp = multiply(temp, Integer.toString(i));	
			}
			
			try {
				finalSum = add(finalSum, temp);	
			} catch (Exception e) {
				finalSum = add(temp, finalSum);
			}
		}
		
		System.out.println("Truncated Final Sum of series (of length " + seriesLength + ") is: " + finalSum);
		return finalSum;
	}
	
	public static String lastTenDigits(String numberString){
		return numberString.substring(numberString.length() - 10);
	}
	
	public static String multiply(String num1, String num2){
		int lineNumber = 0;
		String previousLine = "";
		String lineResult = "";
		int carryOver = 0;
		
		
		for (int i = num1.length() - 1; i >= 0; i--){
			
			// Add zeros to next line (except first line)
			lineResult = "";
			for (int k = 0; k < lineNumber; k++) {
				lineResult = "0" + lineResult;
			}
			lineNumber++;
			
			// Multiply the next line (to be added at end)
			for (int j = num2.length() - 1; j >= 0; j--){
				int digitProduct = Character.getNumericValue(num1.charAt(i)) * Character.getNumericValue(num2.charAt(j));
				lineResult = ((digitProduct + carryOver)% 10) + lineResult;
				carryOver = (digitProduct + carryOver)/ 10;
			}
			
			// Move to next line
			if (carryOver > 0) {
				lineResult = carryOver + lineResult;
				carryOver = 0;
			}

			//Add last two lines and store to "previousLine"
			lineResult = add(previousLine, lineResult);
			previousLine = lineResult;
			
			//Truncate once we're well after 10 digits
			if(lineResult.length() > 13){
				break;
			}
		}
		return lineResult.replaceFirst("^0+(?!$)", "");
	}
	
	public static String add(String number1, String number2) {
//		If the numbers don't have the same number of digits, the second number must be larger than the first. 
		if (number2.length() < number1.length()){
			throw new IllegalArgumentException("number 1 cannot be larger than number 2");
		}
		
		int carryOver = 0;
		String finalSum = "";

		for (int i = 1; i <= number2.length(); i++) {
			int digit1;
			try {
				digit1 = Character.getNumericValue(number1.charAt(number1.length() - i));
			} catch (Exception e) {
				digit1 = 0;
			}
			int digit2 = Character.getNumericValue(number2.charAt(number2.length() - i));

			int digitSum = digit1 + digit2 + carryOver;
			int newDigit = digitSum % 10;
			carryOver = digitSum / 10;
			finalSum = newDigit + finalSum;
		}

		if (carryOver > 0) {
			finalSum = Integer.toString(carryOver) + finalSum;
		}

		return finalSum;
	}
}
