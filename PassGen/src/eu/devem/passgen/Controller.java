package eu.devem.passgen;

public class Controller {
	private GUI gui;
	private PassGen passgen;
	
	public Controller() {
		gui = new GUI(this);
		passgen = new PassGen();
		gui.initGUI();
	}

	public void generatePassword() {
		int length = gui.getSliderPasswordLength();
		int lengthUppercase = 0;
		int lengthLowercase = 0;
		int lengthSpecial = 0;
		int lengthNumbers = 0;
		int combination = 0;
		int currentCombination = 0;
		boolean uppercase = gui.getCheckBoxUppercaseLetters();
		boolean lowercase = gui.getCheckBoxLowercaseLetters();
		boolean specialCharacters = gui.getCheckBoxSpecialCharacters();
		boolean numbers = gui.getCheckBoxNumbers();
		String[] uppercaseArray = passgen.getUpperCase();
		String[] lowercaseArray = passgen.getLowerCase();
		String[] specialCharactersArray = passgen.getSpecialCharacters();
		char[] numbersArray = passgen.getNumbers();
		String result = "1";
		
		while(true) {
			lengthUppercase = (int) (Math.random()*length+1);
			lengthLowercase = (int) (Math.random()*length+1);
			lengthSpecial = (int) (Math.random()*length+1);
			lengthNumbers = (int) (Math.random()*length+1);
			
			if(uppercase == true){
				combination += lengthUppercase;
			}
			if(lowercase == true) {
				combination += lengthLowercase;
			}
			if(specialCharacters == true) {
				combination += lengthSpecial;
			}
			if(numbers == true) {
				combination += lengthNumbers;
			}
			System.out.println(combination);
			
			if(combination == length) {
				break;
			}
			combination = 0;
		}
		System.out.println(lengthLowercase);
		
		while(length>0) {
			currentCombination = (int) (Math.random()*4+1);
			//System.out.println(currentCombination);
			if(currentCombination == 1) {
				result.concat("g"+uppercaseArray[(int) (Math.random()*uppercaseArray.length)]+1);
				length--;
			}
			if(currentCombination == 2) {
				result.concat(lowercaseArray[(int) (Math.random()*lowercaseArray.length)]+1);
				length--;
			}
			if(currentCombination == 3) {
				result.concat(specialCharactersArray[(int) (Math.random()*specialCharactersArray.length)]+1);
				length--;
			}
			if(currentCombination == 4) {
				result.concat(""+numbersArray[(int) (Math.random()*numbersArray.length)]+1);
				length--;
			}
		}
		System.out.println(result);
		gui.setTextFieldPassword(result);
	}
}
