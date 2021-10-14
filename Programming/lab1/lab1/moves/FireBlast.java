package info;

import ru.ifmo.se.pokemon.*;

public class FireBlast extends SpecialMove {
	public FireBlast() {
		super(Type.FIRE, 110, 0.85);
	}
	
	public String describe() {
		return "uses Fire Blast";
	}
	
	public void applyOppEffects(Pokemon pokemon) {
		if (Math.random() <= 0.1) {
			Effect.burn(pokemon);
		}
	} 
}