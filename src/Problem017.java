public class Problem017 {
	// Needs a lot of work!
	private long letterCounter;

	public Problem017() {
		this.letterCounter = 0;
	}

	public void runProgram() {

		for (int entireNumber = 1; entireNumber <= 1000; entireNumber++) {
			int hundredsDigit = entireNumber / 100;
			int lastTwoDigits = entireNumber % 100;
			
			if (entireNumber == 1000){
				letterCounter += 11;
				break;
			}
			
			if (hundredsDigit > 0){
				if (entireNumber % 100 == 0){
					switchCounter(hundredsDigit); // e.g. Add the "1" in 100 or the "8" in 800. 
					letterCounter += 7; // Add the 7 letters for "hundred"
				}else{
					switchCounter(hundredsDigit); // e.g. Add the "1" in 100 or the "8" in 800
					letterCounter += 10; // Add the 10 letters for "hundred and"
								
				}
			}
			
			// Always add characters the same way for last two digits
			if (lastTwoDigits / 20 == 0){
				switchCounter(lastTwoDigits);

				
			} else if (lastTwoDigits / 20 > 0){
				// Ones Digit
				switchCounter(lastTwoDigits % 10);
	
				// Tens Digit
				int tensDigit = lastTwoDigits - (lastTwoDigits % 10);
				switchCounter(tensDigit);
	
			}
			
			System.out.println("Letter Counter after " + entireNumber + ": " + letterCounter);
		}

	}

	public long getLetterCounter() {
		return this.letterCounter;
	}

	public void switchCounter(int number) {
		switch (number) {
		case 1:
			this.letterCounter += 3;
			break;
		case 2:
			this.letterCounter += 3;
			break;
		case 3:
			this.letterCounter += 5;
			break;
		case 4:
			this.letterCounter += 4;
			break;
		case 5:
			this.letterCounter += 4;
			break;
		case 6:
			this.letterCounter += 3;
			break;
		case 7:
			this.letterCounter += 5;
			break;
		case 8:
			this.letterCounter += 5;
			break;
		case 9:
			this.letterCounter += 4;
			break;
		case 10:
			this.letterCounter += 3;
			break;
		case 11:
			this.letterCounter += 6;
			break;
		case 12:
			this.letterCounter += 6;
			break;
		case 13:
			this.letterCounter += 8;
			break;
		case 14:
			this.letterCounter += 8;
			break;
		case 15:
			this.letterCounter += 7;
			break;
		case 16:
			this.letterCounter += 7;
			break;
		case 17:
			this.letterCounter += 9;
			break;
		case 18:
			this.letterCounter += 8;
			break;
		case 19:
			this.letterCounter += 8;
			break;
		case 20:
			this.letterCounter += 6;
			break;
		case 30:
			this.letterCounter += 6;
			break;
		case 40:
			this.letterCounter += 5;
			break;
		case 50:
			this.letterCounter += 5;
			break;
		case 60:
			this.letterCounter += 5;
			break;
		case 70:
			this.letterCounter += 7;
			break;
		case 80:
			this.letterCounter += 6;
			break;
		case 90:
			this.letterCounter += 6;
			break;
		case 100: // "Hundred and"
			this.letterCounter += 10;
			break;

		default:
			break;

		}
	}
}
