package ePress.pozycje;

import java.time.LocalDate;

public class Tygodnik extends Czasopismo{

    private LocalDate dataWydania = LocalDate.now();

    public Tygodnik(int id, String tytul, int idAutora, String gatunek, int numerWydania, LocalDate dataWydania) {
        super(id, tytul, idAutora, gatunek, numerWydania);
        this.dataWydania = dataWydania;
    }

    public Tygodnik(int id, String tytul, int idAutora, String gatunek, int numerWydania) {
        super(id, tytul, idAutora, gatunek, numerWydania);
        this.dataWydania = generujDate();
    }

    public LocalDate generujDate() {
        return dataWydania.plusDays(7);
    }

    @Override
    public String toString() {
        return super.toString() + ";" + dataWydania + ";" + "tygodnik";
    }

}
