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
		int[] numbersArray = passgen.getNumbers();
		String result = "";
		
		while(combination != length) {
			combination = 0;
			if(uppercase){
				lengthUppercase = (int) (Math.random()*length+Math.random());
			}
			if(lowercase) {
				lengthLowercase = (int) (Math.random()*length+Math.random());
			}
			if(specialCharacters) {
				lengthSpecial = (int) (Math.random()*length+Math.random());
			}
			if(numbers) {
				lengthNumbers = (int) (Math.random()*length+Math.random());
			}
			combination = lengthUppercase + lengthLowercase + lengthSpecial + lengthNumbers;
		}
		
		while(length>result.length()) {
			currentCombination = (int) (Math.random()*4+1);
			if(currentCombination == 1 && lengthUppercase > 0) {
				result = (result+uppercaseArray[(int) (Math.random()*uppercaseArray.length)]);
				lengthUppercase--;
			}
			if(currentCombination == 2 && lengthLowercase > 0) {
				result = (result+lowercaseArray[(int) (Math.random()*lowercaseArray.length)]);
				lengthLowercase--;
			}
			if(currentCombination == 3 && lengthSpecial > 0) {
				result = (result+(String)specialCharactersArray[(int) (Math.random()*specialCharactersArray.length)]);
				lengthSpecial--;
			}
			if(currentCombination == 4 && lengthNumbers > 0) {
				result = (result+String.valueOf(numbersArray[(int) (Math.random()*numbersArray.length)]));
				lengthNumbers--;
			}
		}
		gui.setTextFieldPassword(result);
	}
}
