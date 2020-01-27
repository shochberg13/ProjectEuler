public class Problem024 {
	public static void main(String[] args) {
		double timeStart = System.currentTimeMillis();
		
		int permutationCounter = 0;
		int permutationMax = 4000;
		String number = "0123456788";
		for (int i = 0; permutationCounter < permutationMax; i++){
			number = addOne(number);
			
			if (containsNoRepeats(number)){
				
				permutationCounter++;
//				System.out.println("i: " + i + "\t permutationCounter: " + permutationCounter + "\tnumber: " + number);
			}
			
		}
		System.out.println("permutationCounter: " + permutationCounter + "\tnumber: " + number);
		System.out.println("Time elapsed: " + (double) (System.currentTimeMillis() - timeStart) / 1000.000 + " seconds");
	}

	public static String addOne(String number) {

		try {
			Long.parseLong(number);
		} catch (Exception e) {
			System.out.println("Invalid number");
			return null;
		}
		String newNumber = "";

		int digit = Character.getNumericValue(number.charAt(number.length() - 1));
		int newDigit = (digit + 1) % 10;
		int carryOver = (digit + 1) / 10;
		newNumber = newDigit + newNumber;

		for (int i = number.length() - 2; i >= 0; i--) {
			digit = Character.getNumericValue(number.charAt(i));
			newDigit = (digit + carryOver) % 10;
			carryOver = (digit + carryOver) / 10;
			newNumber = newDigit + newNumber;
		}

		return newNumber;
	}

	public static boolean containsNoRepeats(String number) {
		for (int i = 0; i < number.length(); i++) {
			for (int j = i + 1; j < number.length(); j++) {
				if (number.charAt(i) == number.charAt(j)) {
					return false;
				}
			}
		}
		return true;
	}
}
