package info;

import ru.ifmo.se.pokemon.*;

public class Yungoos extends Pokemon {
    public Yungoos(String name, int level) {
		super(name, level);
        this.setType(Type.FIGHTING);
		this.setStats(40, 16, 13, 17, 18, 7);
		this.setMove(new DoubleTeam(),
					 new Facade(),
					 new Swagger());
    }
	
	public Yungoos() {
        this("Безымянный", 1);
    }
}
