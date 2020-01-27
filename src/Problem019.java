public class Problem019 {
	// 1 - Sun // 2-Mon // 3 - Tue // 4 - Wed // 5 - Thu // 6 - Fri // 7 - Sat //
	private int[] firstOfMonths;
	
	public Problem019() {
		// Initialize days of week for the year 1900
		this.firstOfMonths = new int[]{2, 5, 5, 1, 3, 6, 1, 4, 7, 2, 5, 7};
	}

	public void run(int lastYear) {
		int sundayTheFirstCounter = 0;
		int year = 1900;
	
		while(year < lastYear){
			year++;
			
			// Every year, the first of the month moves one day forward in the week
			addOneToMonths(0, 11);
			
			// If leap year, add an extra one day to Mar - Dec
			if(year % 4 == 0 && year % 100 != 0){
				addOneToMonths(2, 11);
			}
			
			// If last year was leap year, add an extra one day to Jan + Feb
			if((year - 1) % 4 == 0 && (year - 1) % 100 != 0){
				addOneToMonths(0, 1);
			}
			
			// Add to counter how many firstOfMonths are Sunday 
			for(int i = 0; i < 12; i++){
				if(this.firstOfMonths[i] == 1){
					sundayTheFirstCounter ++;
				}
			}
		}
		
		System.out.println("ANSWER");
		System.out.println("From 1 Jan 1901 to 31 Dec " + lastYear + ", there are " + sundayTheFirstCounter + " Sundays that fall on the first of the month.");
	}

	public void addOneToMonths(int firstMonth, int lastMonth) {
		for(int i = firstMonth; i <= lastMonth; i++){
			if(this.firstOfMonths[i] == 7){
				this.firstOfMonths[i] = 1;
			}else{
				this.firstOfMonths[i] ++;
			}
		}
	}

	public static void main(String[] args) {

		Problem019 program = new Problem019();
		program.run(2000);

	}
}
