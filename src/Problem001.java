public class Problem001 {
	
	//TASK: Find the sum of all the multiples of 3 and 5 that are below 1000.
	
	public static void main(String[] args) {
		int sum = 0;
		for (int i = 1; i < 1000; i++){
			if (i % 3 == 0 || i % 5 == 0){
				sum += i;
			}
		}
		System.out.println("The sum of all multiples of 3 and 5 below 1,000 is " + sum);
	}
}
