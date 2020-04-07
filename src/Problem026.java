public class Problem026 {
	public static void main(String[] args) {
		int longestDivisor = 0;
		int longestCycleLength = 0;
		String longestDecimal = "";
		
		for (int i = 2; i < 1000; i++){
			String decimal = initialDecimals(i);
			int cycleLength = cycleLength(decimal);
			
			System.out.println("1 / " + i + " has a decimal cycle length of " + cycleLength(decimal) + ". The decimal is: " + decimal);
			
			// Set max values if new max is found
			if (cycleLength > longestCycleLength){
				longestDivisor = i;
				longestCycleLength = cycleLength;
				longestDecimal = decimal;
			}
		}
		
		System.out.println("\n\n\nANSWER");
		System.out.println("1 / " + longestDivisor + " has the longest decimal cycle length of " + longestCycleLength + ". The decimal is: " + longestDecimal);
		
	}
	
	public static String initialDecimals(int divisor){
		String entireQuotient = "";
		int dividend = 1;
		
		do{
			dividend *= 10;
			int quotient = dividend / divisor;
			entireQuotient += quotient;
			dividend -= divisor * quotient;
		}while(entireQuotient.length() < 2000);
		
		return entireQuotient;
	}
	
	public static int cycleLength(String number){
		assert(number.length() > 10);
		
		
		for (int cycleLength = 1; cycleLength < number.length(); cycleLength++){
			boolean cycleFound = true;
			for (int i = 0; i <= cycleLength; i++){
				if (number.charAt(number.length() - (1 + i)) != number.charAt(number.length() - (1 + cycleLength + i) )){
					cycleFound = false;
					break;
				}
			}
			if (cycleFound){
				return cycleLength;
			}
		}
		return -1;
	}
}
