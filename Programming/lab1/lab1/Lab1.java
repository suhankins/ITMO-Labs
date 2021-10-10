package info;

import ru.ifmo.se.pokemon.*;

public class Lab1 {
    public static void main(String[] args) {
        Battle b = new Battle();
        Sawk p1 = new Sawk("Cool Sawk", 1);
        Pokemon p2 = new Pokemon("Lame", 1);
        b.addAlly(p1);
        b.addFoe(p2);
        b.go();
    }
}
