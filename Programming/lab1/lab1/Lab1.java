package info;

import ru.ifmo.se.pokemon.*;

public class Lab1 {
    public static void main(String[] args) {
        Battle b = new Battle();
        b.addAlly(new Sawk("Kwas", 1));
		b.addAlly(new Binacle("Elcanib", 1));
		b.addAlly(new Barbaracle("barbarthing", 1));
        b.addFoe(new Cleffa("Lame Clef", 1));
		b.addFoe(new Clefairy("Normal Clef", 1));
		b.addFoe(new Clefable("Cool Clef", 1));
        b.go();
    }
}
