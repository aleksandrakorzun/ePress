package ePress.zlecenia;

import ePress.pozycje.Pozycja;
import java.time.LocalDate;

public class ZleceniePozycji {

    private int idZlecenia;
    private Pozycja pozycja;
    private int idUmowy;
    private LocalDate dataRozpoczecia;
    private LocalDate dataZakonczenia;

    public ZleceniePozycji(int idZlecenia, Pozycja pozycja, int idUmowy, LocalDate dataRozpoczecia,
                           LocalDate dataZakonczenia) {
        this.idZlecenia = idZlecenia;
        this.pozycja = pozycja;
        this.idUmowy = idUmowy;
        this.dataRozpoczecia = dataRozpoczecia;
        this.dataZakonczenia =  dataZakonczenia;
    }
}
