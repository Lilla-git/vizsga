/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elemek;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Lilla
 */
public class Elemek {

    static ArrayList<kelemek> elemek = new ArrayList<>();
    static String nev;

    public static void main(String[] args) {
        beolvasa();
        kiir();
        szamol();
        beker();
        kereses();
        felfedezes();
    }

    private static void beolvasa() {
        try {
            Scanner be = new Scanner(new FileInputStream("C:\\Users\\Lilla\\Documents\\NetBeansProjects\\elemek\\src\\elemek\\felfedezesek.csv"), "ISO-8859-2");
            be.nextLine();
            while (be.hasNextLine()) {
                String sor = be.nextLine();
                String[] adatok = sor.split(";");
                elemek.add(new kelemek(adatok[0], adatok[1], adatok[2], Integer.parseInt(adatok[3]), adatok[4]));
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Exception" + ex);
        }
    }

    private static void kiir() {
        int db = 0;
        for (int i = 0; i < elemek.size(); i++) {
            db++;
        }
        System.out.println("Elemek száma: " + db);
    }

    private static void szamol() {
        int szamlalo = 0;
        for (int i = 0; i < elemek.size(); i++) {
            if ("Ókor".equals(elemek.get(i).getEv())) {
                szamlalo++;
            }
        }
        System.out.println(szamlalo);
    }

    private static void beker() {
        Scanner be = new Scanner(System.in);
        boolean egyezik = false;
        Pattern pattern = Pattern.compile("\\b[a-zA-Z]{1,2}\\b");
        while (!egyezik) {
            System.out.print("Kérek egy vegyjelet: ");
            nev = be.nextLine();
            Matcher matcher = pattern.matcher(nev);
            if (matcher.find()) {
                egyezik = true;
            } else {
                System.out.println("Nem letező vegyjelet adtál meg+!");
            }
        }
    }

    private static void kereses() {
        boolean vanvegyjel = false;
        for (int i = 0; i < elemek.size(); i++) {
            if (elemek.get(i).getVegyjel().toLowerCase().equals(nev.toLowerCase())) {
                vanvegyjel = true;
                System.out.println(elemek.get(i).getEv() + " ; " + elemek.get(i).getNev() + " ; " + elemek.get(i).getVegyjel() + " ; " + elemek.get(i).getRendszam() + " ; " + elemek.get(i).getFelfedezo());
            }
        }
        if (!vanvegyjel) {
            System.out.println("Nincs ilyen elem az adatforrásban!");
        }

    }

    private static void felfedezes() {
        int legnagyobb = 0;
        for (int i = 0; i < elemek.size()-1; i++) {
            if(!elemek.get(i).getEv().equals("Ókor")){
                int kulonbseg = Integer.parseInt(elemek.get(i+1).getEv()) - Integer.parseInt(elemek.get(i).getEv());
                if(kulonbseg > legnagyobb) {
                    legnagyobb = kulonbseg;
                }
            }
        }
        System.out.println(legnagyobb);
    }
}
