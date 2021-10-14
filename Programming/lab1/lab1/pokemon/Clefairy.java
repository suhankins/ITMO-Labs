package info;

import ru.ifmo.se.pokemon.*;

public class Clefairy extends Cleffa {
    public Clefairy(String name, int level) {
		super(name, level);
		this.setStats(70, 45, 48, 60, 65, 35);
		this.setMove(new Quash(), new FireBlast(), new Pound());
    }
	
	public Clefairy() {
        this("Безымянный", 1);
    }
}
