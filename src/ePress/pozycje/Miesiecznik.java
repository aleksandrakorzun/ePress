package ePress.pozycje;

import java.time.LocalDate;

public class Miesiecznik extends Czasopismo {

    private LocalDate dataWydania = LocalDate.now();

    public Miesiecznik(int id, String tytul, int idAutora, String gatunek, int numerWydania, LocalDate dataWydania) {
        super(id, tytul, idAutora, gatunek, numerWydania);
        this.dataWydania = dataWydania;
    }

    public Miesiecznik(int id, String tytul, int idAutora, String gatunek, int numerWydania) {
        super(id, tytul, idAutora, gatunek, numerWydania);
        this.dataWydania = generujDate();
    }

    public LocalDate generujDate() {
        return dataWydania.plusMonths(1);
    }

    @Override
    public String toString() {
        return super.toString() + ";" + dataWydania + ";" + "miesiecznik";
    }
}
