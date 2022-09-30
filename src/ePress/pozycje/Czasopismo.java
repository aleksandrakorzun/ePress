package ePress.pozycje;

import java.time.LocalDate;

public abstract class Czasopismo extends Pozycja {

    private int numerWydania;

    public Czasopismo(int id, String tytul, int idAutora, String gatunek, int numerWydania) {
        super(id, tytul, idAutora, gatunek);
        this.numerWydania = numerWydania;
    }

    abstract LocalDate generujDate();

    @Override
    public String toString() {
        return id + ";" + tytul + ";" + idAutora + ";" + gatunek + ";" + numerWydania;
    }
}
