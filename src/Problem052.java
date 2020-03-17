public class Problem052 {
	public static void main(String[] args) {
		for (int i = 1; true; i++){
			int x6 = i * 6;
			if (!containSameDigits(i, x6)){
				continue;
			}
			
			int x5 = i * 5;
			if (!containSameDigits(i, x5)){
				continue;
			}
			
			int x4 = i * 4;
			if (!containSameDigits(i, x4)){
				continue;
			}
			
			int x3 = i * 3;
			if (!containSameDigits(i, x3)){
				continue;
			}
			
			int x2 = i * 2;
			if (!containSameDigits(i, x2)){
				continue;
			}
			System.out.println("ANSWER");
			System.out.println("The lowest number that has a the same digits as 2x, 3x, 4x, 5x, and 6x is: " + i);
			System.out.println("2x: " + x2);
			System.out.println("3x: " + x3);
			System.out.println("4x: " + x4);
			System.out.println("5x: " + x5);
			System.out.println("6x: " + x6);
			return;
		}
	}
	
	public static boolean containSameDigits(int num1, int num2){
		if (numberOfDigits(num1) != numberOfDigits(num2)){
			return false;
		}

		int[] digitCounter1 = new int[10];
		int[] digitCounter2 = new int[10];
		int number1 = num1;
		int number2 = num2;
		
		while(number1 > 0){
			int newDigit1 = number1 % 10;
			int newDigit2 = number2 % 10;
			number1 = number1 / 10;
			number2 = number2 / 10;
			digitCounter1[newDigit1]++;
			digitCounter2[newDigit2]++;
		}
		
		for (int i = 0; i < digitCounter1.length; i++){
			if (digitCounter1[i] != digitCounter2[i]){
				return false;
			}
		}
		return true;
		
	}
	
	public static int numberOfDigits(int num){
		int digits = 0;
		int number = num;
		while(number > 0){
			number /= 10;
			digits++;
		}
		return digits;
	}
}
