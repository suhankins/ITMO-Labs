package info;

import ru.ifmo.se.pokemon.*;

public class WillOWisp extends StatusMove {
	public WillOWisp() {
		super(Type.FIRE, 0, 0.85);
	}
	
	public String describe() {
		return "uses Will-O-Wisp";
	}
	
	public void applyOppEffects(Pokemon pokemon) {
		//Why the hell is it called setCondition if
		//it sets status?
		Effect.burn(pokemon);
	}
}