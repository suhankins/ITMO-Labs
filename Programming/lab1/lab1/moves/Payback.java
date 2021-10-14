package info;

import ru.ifmo.se.pokemon.*;

public class Payback extends PhysicalMove {
	public Payback() {
		super(Type.DARK, 50, 1.00);
	}
	
	public String describe() {
		return "uses Payback";
	}
	
	//The actual effect of payback cannot be made 
	//with this system because i have no clue if pokemon
	//goes first or second.
	//Improve your documentation, it's really bad!
}