package ePress.dzialy;

import ePress.zlecenia.ZlecenieDruku;
import ePress.pozycje.Pozycja;

public class Handlowy {
    private Sklep sklep;
    private int idZlecenia = 1;
    private Programowy dzialProgramowy;

    public void przygotujZlecenieDruku(int idPozycji, int ilosc) {
        ZlecenieDruku zlecenieDruku = new ZlecenieDruku(idZlecenia, idPozycji, ilosc);
        idZlecenia ++;
        dzialProgramowy.dodajZleceniaDruku(zlecenieDruku);
    }

    public void wprowadzPozycje(Pozycja pozycja, int ilosc) {

    }
}