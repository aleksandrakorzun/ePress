package ePress.dzialy;

import ePress.istniejePozycjaException;
import ePress.pozycje.Pozycja;
import ePress.zlaIloscException;


import java.util.ArrayList;
import java.util.List;

public class Sklep {
    private List<Pozycja> magazyn = new ArrayList<>();
    private List<Integer> magazynIlosc = new ArrayList<>();

    public void zlecZakupPozycji(Pozycja pozycja, int ilosc) throws istniejePozycjaException, zlaIloscException {
        for (Pozycja p : magazyn) {
            if(!(p.getTytul().equals(pozycja.getTytul())) && !(p.getrokWydania() == (pozycja.getrokWydania()))) {
                throw new istniejePozycjaException("Pozycja nie istnieje");
            } else if(magazynIlosc.get(pozycja.getId()-1)<ilosc){
                throw new zlaIloscException("Za duza ilosc ", ilosc);
            }
        }
        int indeksPozycji = magazyn.indexOf(pozycja);
        int wartosc = magazynIlosc.get(indeksPozycji);
        magazynIlosc.set(indeksPozycji, wartosc-ilosc);
    }

    public void zwrocKatalogPozycji() {
        for (int i = 0; i < magazyn.size(); i++) {
            System.out.print(magazyn.get(i));
            System.out.println(" "+magazynIlosc.get(i));
        }
    }

    public void dodajPozycje(Pozycja pozycja, int ilosc) {
        int pom = 0;
        for (Pozycja p : magazyn) {
            if (p.getTytul().equals(pozycja.getTytul()) && p.getrokWydania() == (pozycja.getrokWydania())) {
                int x = magazynIlosc.get(pozycja.getId()-1);
                x += ilosc;
                magazynIlosc.set(pozycja.getId()-1, x);
                pom = 1;
            }
        }
        if(pom == 0) {
            magazyn.add(pozycja);
            magazynIlosc.add(ilosc);
        }
    }

    public void usunPozycje(Pozycja pozycja) {
        magazyn.remove(pozycja);
    }
}
