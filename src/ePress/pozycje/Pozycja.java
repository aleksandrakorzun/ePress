package ePress.pozycje;


public class Pozycja {
    protected int id;
    protected String tytul;
    protected int idAutora;
    protected String gatunek;
    protected int rokWydania;

    public Pozycja(int id, String tytul, int idAutora, String gatunek) {
        this.id = id;
        this.tytul = tytul;
        this.idAutora = idAutora;
        this.gatunek = gatunek;
    }

    @Override
    public String toString() {
        return id + ";" + tytul + ";" + idAutora + ";" + gatunek;
    }

    public int getrokWydania() {
        return rokWydania;
    }

    public String getGatunek() {
        return gatunek;
    }

    public String getTytul() {
        return tytul;
    }

    public int getId() {
        return id;
    }
}
