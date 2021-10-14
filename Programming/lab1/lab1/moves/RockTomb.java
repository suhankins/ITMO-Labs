package info;

import ru.ifmo.se.pokemon.*;

public class RockTomb extends PhysicalMove {
	public RockTomb() {
		super(Type.ROCK, 60, 0.95);
	}
	
	public String describe() {
		return "uses Rock Tomb";
	}
	
	public void applyOppEffects(Pokemon p) {
		p.setMod(Stat.SPEED, -2);
	}
}