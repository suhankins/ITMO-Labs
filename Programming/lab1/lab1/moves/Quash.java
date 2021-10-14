package info;

import ru.ifmo.se.pokemon.*;

public class Quash extends StatusMove {
	public Quash() {
		super(Type.DARK, 0, 1.00, 1, 1);
	}
	
	public String describe() {
		return "wastes its turn because Quash is a useless move";
	}
}