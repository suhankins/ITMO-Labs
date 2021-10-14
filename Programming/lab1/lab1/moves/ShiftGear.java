package info;

import ru.ifmo.se.pokemon.*;

public class ShiftGear extends StatusMove {
	public ShiftGear() {
		super(Type.FIGHTING, 0, 0);
	}
	
	public String describe() {
		return "uses Shift Gear";
	}
	
	public boolean checkAccuracy(Pokemon att, Pokemon def) {
		return true;
	}
	
	public void applySelfEffects(Pokemon p) {
		p.setMod(Stat.ATTACK, 2);
		p.setMod(Stat.SPEED, 3);
	}
}