public class Problem039 {
	public static void main(String[] args) {
		double timeStart = System.currentTimeMillis();
		int maxSolutions = 0;
		int perimeterOfMaxSolution = 0;
		
		for (int perimeter = 3; perimeter <= 1000; perimeter++){
			int currentSolutions = howManySolutionsWithPerimiter(perimeter);
			if (currentSolutions > maxSolutions){
				maxSolutions = currentSolutions;
				perimeterOfMaxSolution = perimeter;
			}
		}
		System.out.println("ANSWER");
		System.out.println("The perimeter " + perimeterOfMaxSolution + " has " + maxSolutions + " integer right triangles, which is the most for perimeters under 1000");
		System.out.println("Time elapsed: " + (double)(System.currentTimeMillis() - timeStart ) / 1000.00 + " seconds");
	}
	
	public static int howManySolutionsWithPerimiter(int perimeter){
		int numberOfSolutions = 0;
		int c;
		for (int a = 1 ; a < perimeter / 2; a++ ){
			for (int b = a; b < perimeter / 2; b++){
				c = perimeter - (a + b);
				if (a * a + b * b == c * c){
					numberOfSolutions++;
					System.out.println("Perimeter: " + perimeter + "\ta: " + a + "\tb: " + b + "\tc: " + c);
				}
			}
		}
		return numberOfSolutions;
	}
}
