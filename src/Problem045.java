public class Problem045 {

	public static boolean isPentagonal(int number){
		int adder = 1;
		for (int i = 1; i <= number; i += adder){
			adder += 3;
			if (i == number){
				return true;
			}
		}
		return false;
	}
	
	public static boolean isHexagonal(int number){
		int adder = 1;
		for (int i = 1; i <= number; i += adder){
			adder += 4;
			if (i == number){
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		double timeStart = System.currentTimeMillis();
		boolean gotFirstNumberYet = false;
		int adder = 2;
		
		for (int i = 3; true; i += adder){
			adder ++;
			if ( isPentagonal(i)){
				if (isHexagonal(i)){
					if (gotFirstNumberYet){
						System.out.println("\nANSWER");
						System.out.println("The number " + i + " is triangle, pentagonal, and hexagonal!");
						System.out.println("Total Time: " + ((System.currentTimeMillis() - timeStart) / 1000));
						return;
					}
					gotFirstNumberYet = true;
					System.out.println("Found the first number. It's " + i);
				}
			}
		}
		
	}
}
