package info;

import ru.ifmo.se.pokemon.*;

public class Pound extends PhysicalMove {
	public Pound() {
		super(Type.NORMAL, 40, 1.00);
	}
	
	public String describe() {
		return "uses Pound";
	}
}