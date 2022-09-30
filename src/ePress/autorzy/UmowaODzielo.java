package ePress.autorzy;

import java.time.LocalDate;

public class UmowaODzielo extends Umowa{

    private int idPozycji;

    public UmowaODzielo(int id, LocalDate dataZawarcia, LocalDate dataZakonczenia, int idAutora,
                        String rodzaj, int idPozycji) {
        super(id, dataZawarcia, dataZakonczenia, idAutora, rodzaj);
        this.idPozycji = idPozycji;
    }

    public String toString() {
        return super.toString() + ";" + idPozycji;
    }
}
