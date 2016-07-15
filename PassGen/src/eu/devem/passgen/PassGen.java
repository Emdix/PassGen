package eu.devem.passgen;

public class PassGen {
	private char[] lowerCase = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
	private char[] upperCase = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
	private char[] specialCharacter = {'!','§','$','%','&','/','(',')','=','?','@','€','*','_',':',';','<','>'};
	private char[] numbers = {1,2,3,4,5,6,7,8,9};
	
	public PassGen() {
		
	}

	public char[] getLowerCase() {
		return lowerCase;
	}

	public char[] getUpperCase() {
		return upperCase;
	}

	public char[] getSpecialCharacter() {
		return specialCharacter;
	}

	public char[] getNumbers() {
		return numbers;
	}
}
