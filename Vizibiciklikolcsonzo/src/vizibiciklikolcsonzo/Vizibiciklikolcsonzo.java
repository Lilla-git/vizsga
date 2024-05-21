/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vizibiciklikolcsonzo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lilla
 */
public class Vizibiciklikolcsonzo {

    static ArrayList<kolcsonzes> kolcsonzes = new ArrayList<>();
    static String nev;
    static String ido;

    public static void main(String[] args) {
        beolvas();
        //kiir();
        //beker();
        //idopont();
        //kolcsonzes();
        //letrehozas();
        statisztika();
    }

    private static void beolvas() {
        try {
            Scanner be = new Scanner(new FileInputStream("C:\\Users\\Lilla\\Documents\\NetBeansProjects\\Vizibiciklikolcsonzo\\src\\Vizibiciklikolcsonzo\\kolcsonzesek.txt"), "UTF-8");
            be.nextLine();
            while (be.hasNextLine()) {
                String sor = be.nextLine();
                String[] adatok = sor.split(";");
                kolcsonzes.add(new kolcsonzes(
                        adatok[0],
                        adatok[1],
                        adatok[2].length() == 1 ? "0" + adatok[2] : adatok[2],
                        adatok[3].length() == 1 ? "0" + adatok[3] : adatok[3],
                        adatok[4].length() == 1 ? "0" + adatok[4] : adatok[4],
                        adatok[5].length() == 1 ? "0" + adatok[5] : adatok[5]));
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Exception" + ex);
        }
    }

    private static void kiir() {
        int db = 0;
        for (int i = 0; i < kolcsonzes.size(); i++) {
            db++;
        }
        System.out.println(db);
    }

    private static void beker() {
        Scanner be = new Scanner(System.in);
        boolean letezonev = false;
        System.out.print("Kérek egy nevet: ");
        nev = be.nextLine();
        for (int i = 0; i < kolcsonzes.size(); i++) {
            if (nev.equals(kolcsonzes.get(i).getNev())) {
                System.out.println(kolcsonzes.get(i).getNev() + " " + "kölcsönzései: " + kolcsonzes.get(i).getEora() + ":"
                        + kolcsonzes.get(i).getEperc() + "-" + kolcsonzes.get(i).getVora() + ":" + kolcsonzes.get(i).getVperc());
                letezonev = true;
            }
        }
        if (!letezonev) {
            System.out.println("Nem letező nevet adtál meg!");
        }
    }

    private static void idopont() {
        Scanner be = new Scanner(System.in);
        System.out.print("Kérek egy időt óra:perc alakban: ");
        ido = be.nextLine();
        String ora = ido.split(":")[0];
        String perc = ido.split(":")[1];
        if (ora.length() == 1) {
            ora = "0" + ora;
        }
        if (perc.length() == 1) {
            perc = "0" + perc;
        }
        ido = ora + ":" + perc;
        for (int i = 0; i < kolcsonzes.size(); i++) {
            kolcsonzes k = kolcsonzes.get(i);
            if (Integer.parseInt(ido.replace(":", "")) > Integer.parseInt(k.getEora().concat(k.getEperc()))
                    && Integer.parseInt(ido.replace(":", "")) < Integer.parseInt(k.getVora().concat(k.getVperc()))) {
                System.out.println(k.getEora() + ":" + k.getEperc() + "-" + k.getVora() + ":" + k.getVperc() + " : " + k.getNev());

            }
        }

    }

    private static void kolcsonzes() {
        int kezdes;
        int vege;
        double[] mennyiFelOra = new double[kolcsonzes.size()];
        int felOrakOsszege = 0;

        for (int i = 0; i < kolcsonzes.size(); i++) {

            kezdes = Integer.parseInt(kolcsonzes.get(i).getEora()) * 60
                    + Integer.parseInt(kolcsonzes.get(i).getEperc());
            vege = Integer.parseInt(kolcsonzes.get(i).getVora()) * 60
                    + Integer.parseInt(kolcsonzes.get(i).getVperc());

            mennyiFelOra[i] = Math.ceil(((double) vege - kezdes) / 30);
            felOrakOsszege += mennyiFelOra[i];
        }
        System.out.println("\n8. feladat: A napi bevétel: " + felOrakOsszege * 2400 + " Ft");
    }

    private static void letrehozas() {
        try {
            FileWriter fw = new FileWriter("C:\\Users\\Lilla\\Documents\\NetBeansProjects\\Vizibiciklikolcsonzo\\src\\Vizibiciklikolcsonzo\\F.txt");
            for (int i = 0; i < kolcsonzes.size(); i++) {
                if (kolcsonzes.get(i).getJazon().equals("F")) {
                    String data = kolcsonzes.get(i).getEora() + ":" + kolcsonzes.get(i).getEperc()
                            + "-" + kolcsonzes.get(i).getVora() + ":" + kolcsonzes.get(i).getVperc() + " : " + kolcsonzes.get(i).getNev();
                    fw.write(data);
                    fw.write("\n");
                }
            }
            fw.close();
        } catch (IOException ex) {
            System.out.println("Exception" + ex);
        }
    }

    private static void statisztika() {
        Map<String, Integer> statisztika = new HashMap<>();
        for (int i = 0; i < kolcsonzes.size(); i++) {
            String betu = kolcsonzes.get(i).getJazon();
            if (statisztika.containsKey(betu)) {
                statisztika.put(betu, statisztika.get(betu) + 1);
            } else {
                statisztika.put(betu, 1);
            }
        }
        for (Map.Entry<String, Integer> set
                : statisztika.entrySet()) {
            if (set.getValue() > 1) {
                // Printing all elements of a Map
                System.out.println(set.getKey() + " - " + set.getValue());
            }
        }
    }
}
