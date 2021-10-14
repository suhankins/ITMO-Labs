package info;

import ru.ifmo.se.pokemon.*;

public class Sawk extends Pokemon {
    public Sawk(String name, int level) {
		super(name, level);
        this.setType(Type.FIGHTING);
		this.setStats(75, 125, 75, 30, 75, 85);
		this.setMove(new Payback(), new RockTomb(), new BulkUp(), new ShiftGear());
    }
	
	public Sawk() {
        this("Безымянный", 1);
    }
}
