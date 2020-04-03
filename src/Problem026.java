public class Problem026 {
	public static void main(String[] args) {
		for (int i = 2; i < 11; i++ ){
			System.out.println("1 / " + i + " has a repeating decimal length of " + lengthOfRepeat(i));
		}

		
	}
	
	public static String lengthOfRepeat(int divisor){
		String entireQuotient = "";
		int dividend = 1;
		
		do{
			dividend *= 10;
			int quotient = dividend / divisor;
			entireQuotient += quotient;
			dividend -= divisor * quotient;
		}while(entireQuotient.length() < 10);
//		}while(notRepeating(entireQuotient));
		return entireQuotient;
	}
	
	public static boolean notRepeating(String number){
		
		int length = number.length();
		if (length < 2){
			return true;
		}
		
		int lengthOfRepeat = 0;
		
		for (int i = 2; i <= length; i++){
			if (number.charAt(length - 1) == number.charAt(length - i)){
				break;
			}else{
				lengthOfRepeat++;
			}
		}
		
		
		
		
		return false;
	}
	
}
