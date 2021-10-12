package info;

import ru.ifmo.se.pokemon.*;

public class Hypnosis extends StatusMove {
	public Hypnosis() {
		super(Type.PSYCHIC, 0, 0.6);
	}
	
	public String describe() {
		return "uses Hypnosis";
	}
	
	public void applySelfEffects(Pokemon pokemon) {
		Effect.sleep(pokemon);
	}
}