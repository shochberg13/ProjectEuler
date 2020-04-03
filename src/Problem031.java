public class Problem 031 {
	
}





// First attempt with recursion below
// Took way too long. Besides that, with the simple of case of getting all 11
// cases for just 10p, it counts duplicates to get 129 cases =(

//import java.util.HashSet;
//
//public class Problem031 {
//	public static void main(String[] args) {
//		HashSet<int[]> hist = new HashSet<int[]>();
//		System.out.println("Begin");
//		int count = helper(hist, 0, 10, 0, 0, 0, 0);
//		System.out.println("There are " + count + " possible permutations of coins that add to 2 pounds.");
//	}
//	// Need to address duplicates --> HashSet creates two hash f(x) for two different arrays with same values.
//	
//	public static int helper(HashSet<int[]> history, int count, int money, int p1, int p2, int p5, int p10){
//		int[] newRow = new int[]{p1, p2, p5, p10};
//		for (int i = 0; i < newRow.length; i++){
//			System.out.print(newRow[i] + "\t");
//		}
//		System.out.println("Money: " + money);
//		
//		if (money == 0){
//			System.out.println("Money is zero.");
//			if (!history.contains(newRow)){
//				history.add(newRow);
//				count++;
//				System.out.println("New count is: " + count);
//				
//			}else{
//				System.out.println("New count unchanged: " + count);
//			}
//		}
//		
//		int tempCount = count;
//		
//		if (money >= 10){
//			tempCount += helper(history, count, money - 10, p1, p2, p5, p10 + 1);
//		}
//		if (money >= 5){
//			tempCount += helper(history, count, money - 5, p1, p2, p5 + 1, p10);
//		}
//		if (money >= 2){
//			tempCount += helper(history, count, money - 2, p1, p2 + 1, p5, p10);
//		}
//		if (money >= 1){
//			tempCount += helper(history, count, money - 1, p1 + 1, p2, p5, p10);
//		}
//		return tempCount;
//	}
//}
