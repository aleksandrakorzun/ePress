package ePress.dzialy;

import ePress.ZapisOdczyt;
import ePress.autorzy.Autor;
import ePress.autorzy.Umowa;
import ePress.autorzy.UmowaODzielo;
import ePress.autorzy.UmowaOPrace;
import ePress.istniejeAutorException;
import ePress.pozycje.Pozycja;
import ePress.zlecenia.ZlecenieDruku;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Programowy  {
    private List<Autor> autorzy = ZapisOdczyt.czytajAutorow("autorzy.txt");
    private List<Umowa> umowy = new ArrayList<>();
    private List<ZlecenieDruku> zleceniaDruku = new ArrayList<>();
    private Handlowy dzialHandlowy;
    Drukarnia drukarnia1 = new Drukarnia(1, 2);
    Drukarnia drukarnia2 = new Drukarnia(2, 2);
    Drukarnia drukarnia3 = new Drukarnia(3, 1);


    public Programowy() throws FileNotFoundException {
    }

    public int zwrocIdAutora() {
        if (autorzy.isEmpty()) {
            return 1;
        }
        return (autorzy.get(autorzy.size()-1)).getId()+1;
    }

    public void dodajAutora(Autor autor) throws istniejeAutorException{
        for (Autor a : autorzy) {
            if (a.getImie().equals(autor.getImie()) && a.getNazwisko().equals(autor.getNazwisko())  ) {
                throw new istniejeAutorException("Autor juz istnieje");
            }
        }
        autorzy.add(autor);
    }

    public void usunAutora(int id) {
        autorzy.remove(autorzy.get(id-1));
    }

    public List<Autor> zwrocAutorow() {
        return this.autorzy;
    }

    public int zwrocIdUmowy() {
        if (umowy.isEmpty()) {
            return 1;
        }
        return (umowy.get(umowy.size()-1)).getId()+1;
    }

    public void zawrzyjUOP(int idAutora, LocalDate dataZawarcia) throws istniejeAutorException {
        int pom = 0;

        for (Umowa u : umowy) {
            if (u.getIdAutora() == idAutora && u.getRodzaj().equals("uop")) {
                throw new istniejeAutorException("Umowa z tym autorem istnieje");
            }
        }

        for (Autor a : autorzy) {
            if (a.getId() == idAutora) {
                pom = 1;
            }
        }

        if (pom == 0) {
            throw new istniejeAutorException("Autor nie istnieje");
        }

        for (Autor a : autorzy) {
            if (a.getId() == idAutora) {
                LocalDate dataZakonczenia = dataZawarcia.plusYears(1);
                Umowa umowaOPrace = new UmowaOPrace(zwrocIdUmowy(), dataZawarcia, dataZakonczenia, idAutora, "uop");
                umowy.add(umowaOPrace);
            }
        }
    }

    public void zawrzyjUOD(int idAutora, LocalDate dataZawarcia, int idPozycji) throws istniejeAutorException {
        int pom = 0;

        for (Autor a : autorzy) {
            if (a.getId() == idAutora) {
                LocalDate dataZakonczenia = dataZawarcia.plusMonths(6);
                Umowa umowaODzielo = new UmowaODzielo(zwrocIdUmowy(), dataZawarcia, dataZakonczenia, idAutora, "uod", idPozycji);
                umowy.add(umowaODzielo);
                pom = 1;
            }
        }

        if (pom == 0) {
            throw new istniejeAutorException("Autor nie istnieje");
        }
    }

    public void rozwiazUmowe(int id) {
        umowy.remove(umowy.get(id-1));
    }

    public List<Umowa> zwrocUmowy() {
        return this.umowy;
    }

    public void dodajZleceniaDruku(ZlecenieDruku zlecenieDruku) {
        zleceniaDruku.add(zlecenieDruku);
    }

    public void zlecPrzygotowaniePozycji(Pozycja pozycja) {
        if (pozycja.getGatunek().equals("album")) {
            drukarnia3.drukujZlecenie();
        } else {
            drukarnia1.drukujZlecenie();
        }
    }
}
