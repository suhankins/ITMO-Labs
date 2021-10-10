package info;

import ru.ifmo.se.pokemon.*;

public class HeatWave extends SpecialMove {
	public HeatWave() {
		super(Type.FIRE, 95, 0.9);
	}
	
	public String describe() {
		return "uses Heat Wave";
	}
	
	public void applyOppEffects(Pokemon pokemon) {
		//This move has a 10% chance to inflict burn
		if (Math.random() <= 0.1) Effect.burn(pokemon);
	}
}