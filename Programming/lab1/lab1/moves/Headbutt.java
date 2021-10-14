package info;

import ru.ifmo.se.pokemon.*;

public class Headbutt extends PhysicalMove {
	public Headbutt() {
		super(Type.NORMAL, 70, 1.00);
	}
	
	public String describe() {
		return "uses Headbutt";
	}
	
	public void applyOppEffects(Pokemon p) {
		if (Math.random() <= 0.3) {
			Effect.flinch(p);
		}
	}
}