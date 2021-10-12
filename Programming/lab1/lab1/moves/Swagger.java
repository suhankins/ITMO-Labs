package info;

import ru.ifmo.se.pokemon.*;

public class Swagger extends StatusMove {
	public Swagger() {
		super(Type.NORMAL, 0, 0.85);
	}
	
	public String describe() {
		return "used Swagger";
	}
	
	public boolean checkAccuracy(Pokemon att, Pokemon def) {
		return true;
	}
	
	public void applyOppEffects(Pokemon pokemon) {
		pokemon.setMod(Stat.ATTACK, 2);
		Effect.confuse(pokemon);
	}
}