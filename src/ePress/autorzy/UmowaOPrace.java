package ePress.autorzy;

import java.util.ArrayList;
import java.time.LocalDate;
import java.util.List;
import ePress.zlecenia.ZleceniePozycji;

public class UmowaOPrace extends Umowa{

    private List<ZleceniePozycji> zlecenia = new ArrayList<>();

    public UmowaOPrace(int id, LocalDate dataZawarcia, LocalDate dataZakonczenia, int idAutora, String rodzaj) {
        super(id, dataZawarcia, dataZakonczenia, idAutora, rodzaj);
    }

    public void dodajZlecenie(ZleceniePozycji zlecenie) {
       zlecenia.add(zlecenie);
    }

    public String toString() {
        return super.toString();
    }
}
