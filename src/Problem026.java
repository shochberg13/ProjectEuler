public class Problem026 {
	public static void main(String[] args) {
		for (int i = 2; i < 20; i++){
			System.out.println("The OG number " + i + " has initial decimals: " + initialDecimals(i));
		}
	}
	
	public static String initialDecimals(int divisor){
		String entireQuotient = "";
		int dividend = 1;
		
		do{
			dividend *= 10;
			int quotient = dividend / divisor;
			entireQuotient += quotient;
			dividend -= divisor * quotient;
		}while(notRepeating(entireQuotient));
		
		return entireQuotient;
	}
	
	public static boolean notRepeating(String number){
		if (number.length() < 2){
			return true;
		}
		int cycleLength = number.length() / 3 + 1;
		
		for (int i = 1; i <= number.length() - cycleLength; i++){
			if (number.charAt(number.length() - i) != number.charAt(number.length() - (i + cycleLength))){
				return true;
			}
		}
		System.out.println("\t\tThe number " + number + " has a cycle length of " + cycleLength);
		return false;
	}
}
