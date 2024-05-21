/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hianyzasok;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lilla
 */
public class Hianyzasok {

    static ArrayList<hianyzas> hianyzas = new ArrayList<>();
    static int szam;
    static String nev;

    public static void main(String[] args) {
        beolvasas();
        kiir();
        beker();
        bekernev();
        hianyzas();
        bekertnap();
        osszesites();
    }

    private static void beolvasas() {
        try {
            Scanner be = new Scanner(new FileInputStream("C:\\Users\\Lilla\\Documents\\NetBeansProjects\\Hianyzasok\\src\\Hianyzasok\\szeptember.csv"), "ISO-8859-2");
            be.nextLine();
            while (be.hasNextLine()) {
                String sor = be.nextLine();
                String[] adatok = sor.split(";");
                hianyzas.add(new hianyzas(adatok[0], adatok[1], Integer.parseInt(adatok[2]), Integer.parseInt(adatok[3]), Integer.parseInt(adatok[4])));

            }
        } catch (FileNotFoundException ex) {
            System.out.println("Exception: " + ex);
        }

    }

    private static void kiir() {
        int osszes = 0;
        for (int i = 0; i < hianyzas.size(); i++) {
            hianyzas h = hianyzas.get(i);
            osszes += h.getMorak();
        }
        System.out.println("2.feladat \n" + " Összes mulasztott órák száma: " + osszes + " óra.");
    }

    private static void beker() {
        Scanner be = new Scanner(System.in);
        System.out.print("3.feladat \n" + " Kérem adjon meg egy napot: ");
        szam = be.nextInt();
    }

    private static void bekernev() {
        Scanner be = new Scanner(System.in);
        System.out.print(" Tanuló neve: ");
        nev = be.nextLine();
    }

    private static void hianyzas() {
        boolean hianyzott = false;
        for (int i = 0; i < hianyzas.size(); i++) {
            if (nev.equals(hianyzas.get(i).getNev()) && szam == hianyzas.get(i).getEnap()) {
                hianyzott = true;
            }
        }
        if (!hianyzott) {
            System.out.println("4.feladat \n" + " A tanuló nem hiányzott szeptemberben");
        } else {
            System.out.println("4.feladat \n" + " A tanuló hiányzott szeptemberben");
        }
    }

    private static void bekertnap() {
        System.out.println("5.feladat: Hiányzók 2017.09." + szam + "-n:\n");
        for (int i = 0; i < hianyzas.size(); i++) {
            if (szam == hianyzas.get(i).getEnap()) {
                System.out.println(hianyzas.get(i).getNev() + " (" + hianyzas.get(i).getOsztaly() + ")");
            }
        }
    }

    private static void osszesites() {
        Map<String, Integer> osztalyok = new HashMap<>();
        try {
            FileWriter fw = new FileWriter("C:\\Users\\Lilla\\Documents\\NetBeansProjects\\Hianyzasok\\src\\Hianyzasok\\osszesites.csv");
            for (int i = 0; i < hianyzas.size(); i++) {
                Integer mulasztottorak = hianyzas.get(i).getMorak();
                String osztaly = hianyzas.get(i).getOsztaly();
                if (osztalyok.containsKey(osztaly)) {
                    osztalyok.put(osztaly, osztalyok.get(osztaly) + mulasztottorak);
                } else {
                    osztalyok.put(osztaly, mulasztottorak);
                }
            }
            for (Map.Entry<String, Integer> set
                    : osztalyok.entrySet()) {
                if (set.getValue() > 1) {
                    // Printing all elements of a Map
                    fw.write(set.getKey() + ";" + set.getValue()+"\n");
                }
            }
            fw.close();
        } catch (IOException ex) {
            System.out.println("Exception: " + ex);
        }
    }
}
