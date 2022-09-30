package ePress.pozycje;

import java.lang.String;

public class Ksiazka extends Pozycja {

    private int rokWydania;

    public Ksiazka(int id, String tytul, int idAutora, String gatunek, int rokWydania) {
        super(id, tytul, idAutora, gatunek);
        this.rokWydania = rokWydania;
    }

    @Override
    public String toString() {
        return id + ";" + tytul + ";" + idAutora + ";" + gatunek + ";" + rokWydania;
    }
}