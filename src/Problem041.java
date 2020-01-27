public class Problem041 {
	public static void main(String[] args) {
		long max = 987654321;
		for (long i = 1; i <= max; i += 2){
			
			String numberString = Long.toString(i);
			if (isPandigital(numberString) && !containsZero(numberString) && containsAllDigits(numberString)){
				if (isPrime(i)){
					System.out.println("Prime Pandigital Found: " + i);
				}
			}
		}
		
		
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
	
	public static boolean isPrime(long number) {
		boolean isPrime = true;
		
		if (number < 2 ){
			return false;
		}
		
		for (int i = 2; i <= Math.sqrt(number); i ++) {
			if (number % i == 0) {
				isPrime = false;
				break;
			}
		}
		return isPrime;
	}
	
	public static boolean containsZero(String number){
		if (number.contains("0")){
			return true;
		}
		return false;
	}

	public static boolean containsAllDigits(String number) {
		for (int i = 1; i <= number.length(); i++) {
			if (!number.contains(Integer.toString(i))) {
				return false;
			}
		}
		return true;
	}
}
