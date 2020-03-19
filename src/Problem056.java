public class Problem056 {
	public static void main(String[] args) {

		System.out.println(sumOfDigits(Math.pow(99,99)));
			
		
	}
	
	public static int sumOfDigits(double number){
		long num = (long) number;
		long sum = 0;
		
		while(num > 0){
			sum += num % 10;
			num = num / 10;
		}
		return (int) sum;
	}
}
