package ePress.autorzy;

import java.util.ArrayList;
import java.util.List;

import ePress.pozycje.Ksiazka;

public class Autor{
    private int id;
    private String imie;
    private String nazwisko;
    private List<Umowa> umowy = new ArrayList<>();
    private List<Ksiazka> ksiazki = new ArrayList<>();

    public Autor(int id, String imie, String nazwisko) {
        this.id = id;
        this.imie = imie;
        this.nazwisko = nazwisko;
    }

    @Override
    public String toString() {
        return id + ";" + imie + ";" + nazwisko;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void dodajUmowe(Umowa umowa)
    {
        umowy.add(umowa);
    }

    public void dodajPozycje(Ksiazka ksiazka)
    {
        ksiazki.add(ksiazka);
    }

    public String getImie()
    {
        return imie;
    }

    public String getNazwisko()
    {
        return nazwisko;
    }
}
