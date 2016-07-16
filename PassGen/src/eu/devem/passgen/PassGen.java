package eu.devem.passgen;

public class PassGen {
	private String[] lowerCase = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
	private String[] upperCase = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
	private String[] specialCharacters = {"!","§","$","%","&","/","(",")","=","?","@","€","*","_",":",";","<",">"};
	private char[] numbers = {1,2,3,4,5,6,7,8,9};
	
	public PassGen() {
		
	}

	public String[] getLowerCase() {
		return lowerCase;
	}

	public String[] getUpperCase() {
		return upperCase;
	}

	public String[] getSpecialCharacters() {
		return specialCharacters;
	}

	public char[] getNumbers() {
		return numbers;
	}
}
