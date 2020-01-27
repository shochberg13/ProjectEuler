import java.util.ArrayList;

public class Problem021 {
	public static void main(String[] args) {

		ArrayList<Integer> amicableNumberList = new ArrayList<Integer>();
		int amicableNumberSum = 0;
		int amicableNumberMax = 10000;

		for (int i = 2; i < amicableNumberMax; i++) {
			int pairNumber = sumOfDivisors(i);
			if (i != pairNumber && i == sumOfDivisors(pairNumber)) {
				
				if (!amicableNumberList.contains(i) && !amicableNumberList.contains(pairNumber)) {
					amicableNumberSum += i;
					amicableNumberSum += pairNumber;
					
					amicableNumberList.add(i);
					amicableNumberList.add(pairNumber);
					
					System.out.println("I found a pair! They are " + i + " and " + pairNumber);
					System.out.println(i + " has a divisor sum of " + sumOfDivisors(i) );
					System.out.println(pairNumber + " has a divisor sum of " + sumOfDivisors(pairNumber) );
					System.out.println("~~~~~~~~~~~~~~~~~");
				}

			}
		}
		System.out.println("\n ANSWER \nThe sum of all amicable numbers under " + amicableNumberMax + " is " + amicableNumberSum);
		System.out.println("The list of all the amicable numbers are: \n" + amicableNumberList);

	}

	public static int sumOfDivisors(int number) {
		int sumOfDivisors = 1;
		for (int i = 2; i <= Math.sqrt(number); i++) {
			if (number % i == 0) {
				sumOfDivisors += i;
				sumOfDivisors += (number / i);
			}
		}
		return sumOfDivisors;
	}

}
