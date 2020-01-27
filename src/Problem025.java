
public class Problem025 {
	/*TASK: Find the index of the first Fibonacci number with 1000 digits	 */
	public static void main(String[] args) {
		int numberOfDigits = 1000;
		int digitCounter = 0;
		
		String fibonacci1 = "1";
		String fibonacci2 = "1";
		
		int index = 3;
		while (digitCounter < numberOfDigits){
			String fibonacciNew = add(fibonacci1,  fibonacci2);
			fibonacci1 = fibonacci2;
			fibonacci2 = fibonacciNew;
			digitCounter = howManyDigits(fibonacciNew);
			
//			System.out.println("F1: " + fibonacci1 + "\tF2: " + fibonacci2 + "\tFNew: " + fibonacciNew + "\t\tDigit Counter Progress: " + digitCounter + "\t Index Progress: " + index);
			index ++;
		}
		
		System.out.println("\nANSWER");
		System.out.println("The Fibinocci first number with at least " + numberOfDigits + " digits is index: " + (index - 1));
		
	}
	
	public static int howManyDigits(String number){
		return number.length();
	}
	
	public static String add(String number1, String number2){
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
