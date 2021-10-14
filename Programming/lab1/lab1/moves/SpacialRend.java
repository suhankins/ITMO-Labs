package info;

import ru.ifmo.se.pokemon.*;

public class SpacialRend extends SpecialMove {
	public SpacialRend() {
		super(Type.DRAGON, 100, 0.95);
	}
	
	public String describe() {
		return "uses Spacial Rend";
	}
	
	//The entire point of this move is increased critical hit ratio
	//but it looks like this system doesn't even have crits 
}