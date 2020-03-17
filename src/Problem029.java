import java.util.HashSet;


public class Problem029 {
	public static void main(String[] args) {
		
		HashSet<Double> distinct = new HashSet<Double>();
		for (int i = 2; i <= 100; i++){
			for (int j = 2; j <= 100; j++){
				distinct.add(Math.pow(i,j));
			}
		}
		System.out.println("There are " + distinct.size() + " distinct integers");
	}
}
