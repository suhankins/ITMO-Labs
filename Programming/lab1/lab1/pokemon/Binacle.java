package info;

import ru.ifmo.se.pokemon.*;

public class Binacle extends Pokemon {
    public Binacle(String name, int level) {
		super(name, level);
        this.setType(Type.ROCK, Type.WATER);
		this.setStats(42, 52, 67, 39, 56, 50);
		this.setMove(new SpacialRend(), new Headbutt(), new Swagger());
    }
	
	public Binacle() {
        this("Безымянный", 1);
    }
}
