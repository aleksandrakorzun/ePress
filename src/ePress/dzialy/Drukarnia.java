package ePress.dzialy;

public class Drukarnia {
    private int id;
    private int jakosc;

    public Drukarnia(int id, int jakosc) {
        this.id = id;
        this.jakosc = jakosc;
    }

    public void drukujZlecenie() {
        System.out.println("Wydrukowano");
    }
}