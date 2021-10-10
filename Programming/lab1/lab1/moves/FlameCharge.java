package info;

import ru.ifmo.se.pokemon.*;

public class FlameCharge extends PhysicalMove {
	public FlameCharge() {
		super(Type.FIRE, 50, 1);
	}
	
	public String describe() {
		return "uses Flame Charge";
	}
}