import java.util.ArrayList;

public class Problem043 {
	public static void main(String[] args) {
		double timeStart = System.currentTimeMillis();
		ArrayList<String> filter1 = new ArrayList<String>();
		
		// Create list of numbers that satisfy Property 1, 4, 7
		for (int i = 10; i < 999; i += 2){
			for (int j = 14; j < 999; j+= 7){
				for (int k = 17; k < 999; k += 17){
					if(isPandigital(concatenate(i, j, k))){
						filter1.add(concatenate(i, j, k));
					}
				}
			}
		}
		
		// All of these numbers are 9 digits. Add the missing digit in front of every number.
		ArrayList<String> filter2 = new ArrayList<String>();
		for (String number : filter1){
			for (int i = 0; i < 10; i++){
				if (!number.contains(Integer.toString(i))){
					filter2.add(i + number);
				}
			}
		}
		
		
		// Now filter for property 2, 3, 5, 6
		ArrayList<String> successfulNumbers = new ArrayList<String>();
		for (String number : filter2){
			if (satisfiesAllProperties(number)){
				successfulNumbers.add(number);
			}
		}
		
		// Print the list and get the sum
		System.out.println("After looking at all the properties, there are " + successfulNumbers.size() + " possible numbers");
		System.out.println("The list of pandigitial numbers that satisfy all the properties:");
		long sum = 0;
		for (String number : successfulNumbers){
			System.out.println(number);
			sum += Long.parseLong(number);
		}
		
		System.out.println("\nANSWER");
		System.out.println("The final sum of all these numbers are is: " + sum);
		System.out.println("Time elapsed: " + (double)((System.currentTimeMillis() - timeStart)/1000.00) + " seconds");
	}
	
	public static boolean isPandigital(String number) {
		if(number == null){
			return false;
		}
		
		for (int i = 0; i < number.length(); i++) {
			for (int j = i + 1; j < number.length(); j++) {
				if (Character.getNumericValue(number.charAt(i)) == Character.getNumericValue(number.charAt(j))) {
					return false;
				}
			}
		}
		return true;
	}
	
	public static String concatenate(int num1, int num2, int num3){
		String numString1 = Integer.toString(num1);
		String numString2 = Integer.toString(num2);
		String numString3 = Integer.toString(num3);
		
		if (numString1.length() + numString2.length() + numString3.length() < 8){
			return null;
		}
		
		if (numString1.length() == 2){
			numString1 = "0" + numString1;
		}
		
		if (numString2.length() == 2){
			numString2 = "0" + numString2;
		}
		
		if (numString3.length() == 2){
			numString3 = "0" + numString3;
		}
		
		return numString1 + numString2 + numString3;
	}

	/**
	 * 
	 * @param number Assuming this is a 9 digit number
	 * @return
	 * 
	 */
	public static boolean satisfiesProperty2(String number){
		if (Integer.parseInt(number.substring(2, 5)) % 3 == 0){
			return true;
		}
		return false;
	}
	
	public static boolean satisfiesProperty3(String number){
		if (Integer.parseInt(number.substring(3, 6)) % 5 == 0){
			return true;
		}
		return false;
	}
	
	public static boolean satisfiesProperty5(String number){
		if (Integer.parseInt(number.substring(5, 8)) % 11 == 0){
			return true;
		}
		return false;
	}
	
	public static boolean satisfiesProperty6(String number){
		if (Integer.parseInt(number.substring(6, 9)) % 13 == 0){
			return true;
		}
		return false;
	}
	
	public static boolean satisfiesAllProperties(String number){
		if (satisfiesProperty2(number) && satisfiesProperty3(number) && satisfiesProperty5(number) && satisfiesProperty6(number) ){
			return true;
		}
		return false;
	}
}
