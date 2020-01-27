public class Problem033 {
	
	public static void main(String[] args) {
		int productNumerator = 1;
		int productDenominator = 1;
		for (int i = 10; i <= 99; i ++ ){
			for (int j = i + 1; j <= 99; j++){
				double longFraction = (double) i / (double) j;
				
				String iStr = Integer.toString(i);
				String jStr = Integer.toString(j);
				
				if(iStr.charAt(1) == '0'){
					continue;
				}
				
				if (longFraction == shortFraction(iStr, jStr, containsSameDigit(iStr, jStr))){
					System.out.println("Long fraction found: " + i + " / " + j);
					productNumerator *= i;
					productDenominator *= j;
				}
				
			}
		}
		
		System.out.println("\nANSWER");
		System.out.println("The product of the four denominators found is " + productNumerator + " / " + productDenominator);
		
		
	}
	
	public static String containsSameDigit(String num1, String num2){
		String firstDigit = Character.toString(num1.charAt(0));
		String secondDigit = Character.toString(num1.charAt(1));
		
		if (num2.contains(firstDigit)){
			return firstDigit;
		}
		
		if (num2.contains(secondDigit)){
			return secondDigit;
		}
		
		return null;
	}
	
	public static double shortFraction(String num1, String num2, String repeatDigit){
		if (repeatDigit == null ){
			return 0;
		}
		
		num1 = num1.replaceFirst(repeatDigit, "");
		num2 = num2.replaceFirst(repeatDigit, "");
		
		int shortNum1 = Integer.parseInt(num1);
		int shortNum2 = Integer.parseInt(num2);
		
		return (double) shortNum1 / (double) shortNum2;
	}
}