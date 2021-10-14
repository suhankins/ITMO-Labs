package info;

import ru.ifmo.se.pokemon.*;

public class Barbaracle extends Binacle {
    public Barbaracle(String name, int level) {
		super(name, level);
        this.setType(Type.ROCK, Type.WATER);
		this.setStats(72, 105, 115, 54, 86, 68);
		this.setMove(new SpacialRend(), new Headbutt(), new Swagger(), new BulkUp());
    }
	
	public Barbaracle() {
        this("Безымянный", 1);
    }
}
