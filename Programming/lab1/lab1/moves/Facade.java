package info;

import ru.ifmo.se.pokemon.*;

public class Facade extends PhysicalMove {
	public Facade() {
		super(Type.NORMAL, 70, 1);
	}
	
	public double calcBaseDamage(Pokemon att, Pokemon def) {
		Status currectStatus = att.getCondition();
		//Facade has its base power doubled if user is poisoned, paralyzed or burned
		if (currectStatus.equals(Status.BURN) | currectStatus.equals(Status.PARALYZE) | currectStatus.equals(Status.POISON)){
			power = 140;
		} else {
			power = 70;
		}
		//Also Facade makes it so Burn's effect of lowering attack doesn't count
		if (currectStatus.equals(Status.BURN)) {
			att.setStats(att.getStat(Stat.HP),
						 att.getStat(Stat.ATTACK) + 2,
						 att.getStat(Stat.DEFENSE),
						 att.getStat(Stat.SPECIAL_ATTACK),
						 att.getStat(Stat.SPECIAL_DEFENSE),
						 att.getStat(Stat.SPEED));
		}
		
		return super.calcBaseDamage(att, def);
	}
	
	public String describe() {
		return "uses Facade";
	}
}