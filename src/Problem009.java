/*TASK: Find the only pythagorean triplet that adds to 1000;*/ 
public class Problem009 {
	public static void main(String[] args) {
		double startTime = System.currentTimeMillis();
		
		for (int i = 1; i < 1000; i++){
			for (int j = i + 1; j < 1000; j++){
				for (int k = j + 1 ; k < 1000; k++){
					if ((Math.pow(i, 2) + Math.pow(j, 2) == Math.pow(k, 2)) &&
						(i + j + k == 1000)){
						System.out.println("The special triplet is " + i + ", " + j + ", and " + k);
						System.out.println("The product of a*b*c is " + i*j*k);
						break;
					}
				}
			}
		}
		
		double stopTime = System.currentTimeMillis();
		double elapsedTime = (double) ((stopTime - startTime)/1000.00);
		System.out.println("Total time: " + elapsedTime + " seconds");
	}
}
