import java.util.HashSet;
import java.util.Set;

public class Problem023 {
	private Set<Integer> abundantNumbers;
	
	public Problem023(){
		this.abundantNumbers = new HashSet<Integer>();
	}
	
	public void run(){
		double timeStart = System.currentTimeMillis();
		findAllAbundantNumbers();
		int sum = 0;
		for (int i = 1; i <= 28123; i++){
			if (!isSumOfTwoAbundantNumbers(i)){
				sum += i;
			}
		}
	
		
		System.out.println("ANSWER");
		System.out.println("The sum of all numbers that are not a sum of two abundant numbers is: " + sum);
		System.out.println("Time elapsed: " + (double)(System.currentTimeMillis() - timeStart) / 1000.000 + " seconds");
	}
	
	public void findAllAbundantNumbers(){
		for (int i = 12; i <= 28123; i++){
			if (isAbundant(i)){
				this.abundantNumbers.add(i);
			}
		}
	}
	
	public boolean isAbundant(int number){
		int sumOfDivisors = 0;
		for (int i = 1; i <= number / 2; i++){
			if (number % i == 0){
				sumOfDivisors += i;
			}
		}
		return sumOfDivisors > number;
	}
	
	public boolean isSumOfTwoAbundantNumbers(int number){
		for (int abundantNumber : this.abundantNumbers){
			if(this.abundantNumbers.contains(number - abundantNumber)){
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		Problem023 program = new Problem023();
		program.run();
	}
}
