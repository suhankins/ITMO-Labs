package info;

import ru.ifmo.se.pokemon.*;

public class Sawk extends Pokemon {
    public Sawk(String name, int level) {
		super(name, level);
        this.setType(Type.FIGHTING);
		this.setStats(50, 14, 17, 10, 12, 16);
		this.setMove(//new FlameCharge(),
					 //new WillOWisp(),
					 //new HeatWave(),
					 new Facade());
    }
	
	public Sawk() {
        this("Безымянный", 1);
    }
}
