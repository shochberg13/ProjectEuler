import java.util.HashSet;
import java.util.Set;

public class Problem032 {
	public static void main(String[] args) {
		int sumOfProducts = 0;
		Set<Integer> products = new HashSet<Integer>();
		double timeStart = System.currentTimeMillis();
		for (int i = 2; i < 100; i++){
			for(int j = i + 1; j < 9999; j++){
				if (isPandigital(i, j, i * j)){
					if (!products.contains(i*j)){
						products.add(i * j);
						sumOfProducts += (i * j);
						System.out.println("i: " + i + "\tj: " + j + "\t product: " + (i * j));
					}
				}
			}
		}
		System.out.println("\nANSWER");
		System.out.println("The sum of products: " + sumOfProducts);
		System.out.println("Time elapsed: " + (double) (System.currentTimeMillis() - timeStart) / 1000.000);
	}
	public static boolean isPandigital(int multiplicand, int multiplier, int product){
		String longNumber = Integer.toString(multiplicand) + Integer.toString(multiplier) + Integer.toString(product);
		if (longNumber.length() == 9){
			for (int i = 1; i <= 9; i++){
				if(!longNumber.contains(Integer.toString(i))){
					return false;
				}
			}
			return true;
		}
		return false;	
		
	}

}
