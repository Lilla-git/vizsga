/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pilotak;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Lilla
 */
public class Pilotak {

    static ArrayList<pilota> pilotak = new ArrayList<>();

    public static void main(String[] args) throws FileNotFoundException {
        beolvasas();
        kiir();
        hataroz();
        szuletes();
        legkisebb();
        rajtszam();

    }

    private static void beolvasas() throws FileNotFoundException {
        try {
            File f = new File("pilotak.csv");
            Scanner be = new Scanner(new FileInputStream("C:\\Users\\Lilla\\Documents\\NetBeansProjects\\pilotak\\src\\pilotak\\pilotak.csv"), "UTF-8");
            be.nextLine();
            while (be.hasNextLine()) {
                String sor = be.nextLine();
                String[] adatok = sor.split(";");
                pilota pilota = new pilota();
                pilota.setNev(adatok[0]);
                pilota.setSzuletesi_datum(LocalDate.parse(adatok[1].replace(".", "-")));
                pilota.setNemzetiseg(adatok[2]);
                if (adatok.length == 4) {
                    pilota.setRajtszam(Integer.parseInt(adatok[3]));
                }
                pilotak.add(pilota);
            }
        } catch (Exception e) {
            System.out.println("Exception" + e);

        }
    }

    private static void kiir() {
        int db = 0;
        for (int i = 0; i < pilotak.size(); i++) {
            db++;
        }
        System.out.println(db);
    }

    private static void hataroz() {
        System.out.println(pilotak.get(pilotak.size() - 1).getNev());
    }

    private static void szuletes() {
        LocalDate datum = LocalDate.of(1901, 01, 01);
        for (int i = 0; i < pilotak.size(); i++) {
            if (pilotak.get(i).getSzuletesi_datum().isBefore(datum)) {
                System.out.println(pilotak.get(i).getNev() + "(" + pilotak.get(i).getSzuletesi_datum() + ")");
            }
        }
    }

    private static void legkisebb() {
        int legkisebb = 0;
        int elsorajtszamindex = 0;
        int legkisebbindex = 0;
        for (int i = 0; i < pilotak.size(); i++) {
            if (pilotak.get(i).getRajtszam() != null) {
                legkisebb = pilotak.get(i).getRajtszam();
                elsorajtszamindex = i;
                legkisebbindex = i;
                break;
            }
        }
        for (int i = elsorajtszamindex + 1; i < pilotak.size(); i++) {
            if (pilotak.get(i).getRajtszam() != null && pilotak.get(i).getRajtszam() < legkisebb) {
                legkisebb = pilotak.get(i).getRajtszam();
                legkisebbindex = i;
            }
        }
        System.out.println(pilotak.get(legkisebbindex).getNemzetiseg());
    }

    private static void rajtszam() {
        Map<Integer, Integer> rajtszamdb = new HashMap<>();
        for (int i = 0; i < pilotak.size(); i++) {
            Integer rajtszam = pilotak.get(i).getRajtszam();
            if (rajtszam != null) {
                if (rajtszamdb.containsKey(rajtszam)){
                   rajtszamdb.put(rajtszam,rajtszamdb.get(rajtszam)+1);
                }else{
                    rajtszamdb.put(rajtszam, 1);
                }
            }
        }
            for (Map.Entry<Integer, Integer> set :
             rajtszamdb.entrySet()) {
                if(set.getValue()>1){
            // Printing all elements of a Map
            System.out.println(set.getKey());
                }
        }

    }
}
