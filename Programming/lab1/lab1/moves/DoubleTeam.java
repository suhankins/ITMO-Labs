package info;

import ru.ifmo.se.pokemon.*;

public class DoubleTeam extends StatusMove {
	public DoubleTeam() {
		super(Type.NORMAL, 0, 1);
	}
	
	public String describe() {
		return "uses Double Team";
	}
	
	public boolean checkAccuracy(Pokemon att, Pokemon def) {
		return true;
	}
	
	public void applySelfEffects(Pokemon pokemon) {
		pokemon.setMod(Stat.EVASION, 3);
	}
}