public class Problem026 {
	// Dreadfully incomplete. Might be worth starting from scratch
	public static void main(String[] args) {

		int max = 10;
		for (int i = 2; i <= max ; i++){
			double decimal = (double) 1 / i;
			System.out.println(i + " " + decimal + " " + isRepeatingDecimal(decimal) + "\tCycleLength: " + cycleLength(decimal));
		}
		
	}
	
	/**
	 * 
	 * Finds the length of recurring cycles
	 */
	public static int cycleLength(double number){
		String numberString = Double.toString(number);
		numberString = numberString.substring(2); // Remove the "0" and "."
		
		for (int cycleLength = 1; cycleLength < numberString.length() / 2; cycleLength ++ ){
			boolean correctCycleLength = true;
			
			for (int j = numberString.length() - 1; j >= 0; j--){
				
				if (numberString.charAt(j) != numberString.charAt(j - cycleLength)){
					correctCycleLength = false;
					System.out.println(cycleLength +" "+ j);
				}
				
			}
			
			if (correctCycleLength){
				return cycleLength;
			}
		}
		
		return 0;
	}
	
	public static boolean isRepeatingDecimal(double number){
		String numberString = Double.toString(number);
		numberString = numberString.substring(2); // Remove the "0" and "."
		
		if (numberString.length() >= 16){ //EDIT if i create dividing method
			return true;
		}else{
			return false;
		}
		
	}
}
