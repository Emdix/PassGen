package eu.devem.passgen;

public class Controller {
	private GUI gui;
	private PassGen passgen;
	
	public Controller() {
		gui = new GUI(this);
		passgen = new PassGen();
	}
}
