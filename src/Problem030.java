
public class Problem030 {
	public static void main(String[] args) {
		int sum = 0;
		System.out.println("These are the special numbers:");
		for (int i = 2; i < 1000000; i++){
			if(sumOfDigitsToFifthPower(i) == i){
				System.out.println("The sum of the digits to the fifth power of " + i + " is " + sumOfDigitsToFifthPower(i));
				sum += sumOfDigitsToFifthPower(i);
			} 
		}
		
		System.out.println("\nANSWER");
		System.out.println("The total sum of all these special numbers are: " + sum);
	}
	
	public static int sumOfDigitsToFifthPower(int number){
		String numberString = Integer.toString(number);
		int sum = 0;
		for (int i = 0; i < numberString.length(); i++){
			sum += Math.pow(Character.getNumericValue(numberString.charAt(i)), 5);
		}
		
		return sum;
	}
}
