package info;

import ru.ifmo.se.pokemon.*;

public class Clefable extends Clefairy {
    public Clefable(String name, int level) {
		super(name, level);
        this.setType(Type.FAIRY);
		this.setStats(95, 70, 73, 95, 90, 60);
		this.setMove(new Quash(), new FireBlast(), new Pound(), new Swagger());
    }
	
	public Clefable() {
        this("Безымянный", 1);
    }
}
