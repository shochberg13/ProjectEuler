/* TASK: Find the largest palindrome made from product of two 3-digit numbers */

public class Problem004 {
	public static void main(String[] args) {

		int largestPalindrome = 0;
		for (int i = 100; i < 1000; i ++){
			for (int j = i + 1; j < 1000; j++){
				String product = Integer.toString(i*j);
				boolean isPalindrome = false; 
				for (int numberIndex = 0; numberIndex < product.length()/2; numberIndex++){
					isPalindrome = true; 
					if (product.charAt(numberIndex) != product.charAt(product.length() - (numberIndex + 1))){
						isPalindrome = false;
						break;
						
					}
				}
				if (isPalindrome && i*j > largestPalindrome){
					largestPalindrome = i*j;
					System.out.println("Largest Palindrome so far: " + largestPalindrome + "\ti: " + i + "\tj: " + j);
				}
			}
		}
		System.out.println("The largest palindrome that is a product of two 3 digit numbers is " + largestPalindrome);
	}
}
