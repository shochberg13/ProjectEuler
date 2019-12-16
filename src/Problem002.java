public class Problem002 {
	// TASK: find the sum of the even Fibonacci numbers (up to 4M)
	public static void main(String[] args) {
		int fibonacci1 = 1;
		int fibonacci2 = 2;

		int sum = 2;
		while (fibonacci2 < 4000000) {
			fibonacci1 += fibonacci2;
			if (fibonacci1 >= 4000000) {
				break;
			}
			fibonacci2 += fibonacci1;
			if (fibonacci1 % 2 == 0){
				sum += fibonacci1;
			}
			if (fibonacci2 % 2 == 0){
				sum += fibonacci2;
			}

		}
	System.out.println("The sum of the even Fibonacci Numbers < 4M is " + sum);
	
	}
}
