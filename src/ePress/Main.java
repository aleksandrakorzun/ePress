package ePress;

import ePress.autorzy.Autor;
import ePress.autorzy.UmowaOPrace;
import ePress.dzialy.Handlowy;
import ePress.dzialy.Programowy;
import ePress.pozycje.Ksiazka;
import ePress.pozycje.Miesiecznik;
import ePress.pozycje.Pozycja;
import ePress.pozycje.Tygodnik;
import ePress.zlecenia.ZleceniePozycji;
import ePress.dzialy.Sklep;


import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

import static java.lang.System.exit;

public class Main {
    public static void main(String[] args) throws IOException {

        Programowy dzialProgramowy = new Programowy();
        Handlowy dzialHandlowy = new Handlowy();
        Sklep sklep = new Sklep();

        Autor autor;

        LocalDate data = LocalDate.now();

        Pozycja pozycja1 = new Ksiazka(1, "ABC", 3,"romans",1999);
        Pozycja pozycja2 = new Miesiecznik(2, "Mój piękny ogród", 7,
                "ogrodnictwo", 1, LocalDate.parse("2020-07-01"));
        Pozycja pozycja3 = new Tygodnik(3, "DEF",7, "nauka", 10,
                LocalDate.parse("2022-10-01"));
        Pozycja pozycja4 = new Miesiecznik(4, "DEFG",7, "nauka", 10);
        Pozycja pozycja5 = new Ksiazka(5, "album", 2, "album", 2010);

        sklep.dodajPozycje(pozycja1, 1);
        sklep.dodajPozycje(pozycja2,2);
        sklep.dodajPozycje(pozycja3, 6);
        sklep.dodajPozycje(pozycja4,4);
        sklep.dodajPozycje(pozycja5, 6);

        ZleceniePozycji zleceniePozycji;
        UmowaOPrace UOP = new UmowaOPrace(1, data, data.plusYears(1), 2, "uop");

        Scanner scanner = new Scanner(System.in);

        boolean b = true;

        int wybor;
        int wybor1;

        while (true) {

            b = true;
            System.out.println("Wybierz akcję");
            System.out.println("0. Wyjscie");
            System.out.println("1. Zarzadzanie autorami");
            System.out.println("2. Zarzadzanie umowami");
            System.out.println("3. Przygotuj zlecenie druku");
            System.out.println("4. Sklep");
            System.out.println("5. Zapis stanu systemu");

            wybor = scanner.nextInt();

            switch (wybor) {

                case 1:
                    while (b) {

                        System.out.println("0. Wroc");
                        System.out.println("1. Dodaj autora");
                        System.out.println("2. Usun autora");
                        System.out.println("3. Przeglad autorow");
                        wybor1 = scanner.nextInt();

                        switch (wybor1) {
                            case 1:
                                String imie = null, nazwisko = null;
                                System.out.print("Podaj imie: ");
                                imie = scanner.next();
                                System.out.print("Podaj nazwisko: ");
                                nazwisko = scanner.next();
                                autor = new Autor(dzialProgramowy.zwrocIdAutora(), imie, nazwisko);
                                try {
                                    dzialProgramowy.dodajAutora(autor);
                                    System.out.println("Dodano");
                                } catch(istniejeAutorException e) {
                                    e.printStackTrace();
                                }
                                break;
                            case 2:
                                int id;
                                System.out.print("Podaj id autora: ");
                                id = scanner.nextInt();
                                dzialProgramowy.usunAutora(id);
                                break;
                            case 3:
                                System.out.println(dzialProgramowy.zwrocAutorow());
                                break;
                            case 0:
                                b = false;
                                break;
                        }
                    }
                    break;

                case 2:
                    while(b) {

                        System.out.println("0. Wroc");
                        System.out.println("1. Zawieranie umowy o prace");
                        System.out.println("2. Zawieranie umowy o dzielo na konkretna pozycje");
                        System.out.println("3. Zlecanie w ramach umowy o prace przygotowanie konkretnej pozycji");
                        System.out.println("4. Rozwiazywanie umow");
                        System.out.println("5. Przeglad umow");
                        wybor1 = scanner.nextInt();

                        switch (wybor1) {

                            case 1:
                                System.out.print("Podaj id autora: ");
                                int idA = scanner.nextInt();
                                try {
                                    dzialProgramowy.zawrzyjUOP(idA, data);
                                    System.out.println("Zawarto umowe o prace");
                                } catch(istniejeAutorException e) {
                                    e.printStackTrace();
                                }
                                break;
                            case 2:
                                System.out.print("Podaj id autora: ");
                                idA = scanner.nextInt();
                                System.out.print("Podaj id pozycji: ");
                                int idP = scanner.nextInt();
                                try{
                                    dzialProgramowy.zawrzyjUOD(idA, data, idP);
                                    System.out.println("Zawarto umowe o dzielo");
                                } catch(istniejeAutorException e) {
                                    e.printStackTrace();
                                }
                                break;
                            case 3:
                                zleceniePozycji = new ZleceniePozycji(1, pozycja1, 1, data, data);
                                UOP.dodajZlecenie(zleceniePozycji);
                                break;
                            case 4:
                                int idUmowy;
                                System.out.print("Podaj indeks umowy: ");
                                idUmowy = scanner.nextInt();
                                dzialProgramowy.rozwiazUmowe(idUmowy);
                                break;
                            case 5:
                                System.out.println(dzialProgramowy.zwrocUmowy());
                                break;
                            case 0:
                                b = false;
                                break;
                        }
                    }
                    break;

                case 3:
                    int idPozycji;
                    int ilosc;
                    System.out.print("Podaj pozycje: ");
                    idPozycji = scanner.nextInt();
                    System.out.println("Podaj ilosc: ");
                    ilosc = scanner.nextInt();
                    dzialHandlowy.przygotujZlecenieDruku(idPozycji, ilosc);
                    break;

                case 4:
                    while (b) {

                        System.out.println("0. Wroc");
                        System.out.println("1. Przyjmowanie zlecen zakupu");
                        System.out.println("2. Katalog dostępnych pozycji");
                        System.out.println("3. Dodawanie pozycji do sklepu");
                        System.out.println("4. Wycofanie pozcyji ze sprzedazy");
                        wybor1 = scanner.nextInt();

                        switch(wybor1)
                        {
                            case 1:
                                try {
                                    sklep.zlecZakupPozycji(pozycja3, 2);
                                } catch(zlaIloscException e){
                                    e.printStackTrace();
                                } catch(istniejePozycjaException e) {
                                    e.printStackTrace();
                                }
                                break;
                            case 2:
                                sklep.zwrocKatalogPozycji();
                                break;
                            case 3:
                                sklep.dodajPozycje(pozycja1,15);
                                System.out.println("Dodano pozycje");
                                break;
                            case 4:
                                sklep.usunPozycje(pozycja1);
                                System.out.println("Usunieto pozycje");
                                break;
                            case 0:
                                b = false;
                                break;
                        }
                    }
                    break;

                case 5:
                    ZapisOdczyt.zapiszDoPliku(dzialProgramowy.zwrocAutorow(), "autorzy.txt");
                    break;

                case 0:
                    exit(0);

                default:
                    break;
            }
        }
    }
}
