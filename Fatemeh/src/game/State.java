package game;

public class State {
	
	private State() {
		// TODO Auto-generated constructor stub
	}
	
	private static State instance = new State();
	
	public static State getInstance() {
		return instance;
	}
	
	public boolean []botton;

}
