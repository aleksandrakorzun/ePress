package ePress.autorzy;

import java.time.LocalDate;

public class Umowa {

    private int id;
    private LocalDate dataZawarcia;
    private LocalDate dataZakonczenia;
    private int idAutora;
    private String rodzaj;

    public Umowa(int id, LocalDate dataZawarcia, LocalDate dataZakonczenia, int idAutora, String rodzaj) {
        this.id = id;
        this.dataZawarcia = dataZawarcia;
        this.dataZakonczenia = dataZakonczenia;
        this.idAutora = idAutora;
        this.rodzaj = rodzaj;
    }

    public int getId() {
        return id;
    }

    public int getIdAutora(){
        return idAutora;
    }

    public String getRodzaj() {
        return rodzaj;
    }

    @Override
    public String toString() {
        return id + ";" + dataZawarcia + ";" + dataZakonczenia + ";" + idAutora;
    }
}
