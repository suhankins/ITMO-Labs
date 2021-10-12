package info;

import ru.ifmo.se.pokemon.*;

//OMG is this Phoenix Wright: Ace Attorney reference!?!?!?!?
public class Gumshoos extends Pokemon {
    public Gumshoos(String name, int level) {
		super(name, level);
        this.setType(Type.FIGHTING);
		this.setStats(60, 17, 14, 18, 19, 9);
		this.setMove(new DoubleTeam(),
					 new Facade(),
					 new Swagger(),
					 new Hypnosis());
    }
	
	public Gumshoos() {
        this("Безымянный", 1);
    }
}
