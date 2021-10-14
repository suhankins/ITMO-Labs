package info;

import ru.ifmo.se.pokemon.*;

public class BulkUp extends StatusMove {
	public BulkUp() {
		super(Type.FIGHTING, 0, 0);
	}
	
	public String describe() {
		return "uses Bulk Up";
	}
	
	public boolean checkAccuracy(Pokemon att, Pokemon def) {
		return true;
	}
	
	public void applySelfEffects(Pokemon p) {
		p.setMod(Stat.ATTACK, 2);
		p.setMod(Stat.DEFENSE, 2);
	}
}