package ePress;

import ePress.autorzy.Autor;

import java.util.List;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ZapisOdczyt {

    public static <T> void zapiszDoPliku(List<T> list, String path) throws IOException {
        FileWriter fileWriter = new FileWriter(path);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        for (T t : list) {
            printWriter.println((t.toString()));
        }
        printWriter.close();
    }

    public static ArrayList<String> czytajZPliku(String path) throws FileNotFoundException {
        File file = new File(path);
        Scanner sc = new Scanner(file);
        ArrayList<String> linie = new ArrayList<>();

        while(sc.hasNextLine()) {
            String linia = sc.nextLine();
            linie.add(linia);
        }
        return linie;
    }

    public static List<Autor> czytajAutorow(String path) throws FileNotFoundException {
        ArrayList<String> lines = czytajZPliku(path);
        ArrayList<Autor> autorzy = new ArrayList<>();

        for (String line : lines) {
            String[] splitLine = line.split(";");
            autorzy.add(new Autor(Integer.parseInt(splitLine[0]), splitLine[1], splitLine[2]));
        }
        return autorzy;
    }

}