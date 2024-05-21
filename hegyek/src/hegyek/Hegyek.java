/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hegyek;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lilla
 */
public class Hegyek {

    static ArrayList<hegysegek> hegyek = new ArrayList<>();
    static int szam;
    public static void main(String[] args) {
        beolvasas();
        kiir();
        atlag();
        legmagasabb();
        beker();
        szamitas();
        statisztika();
        file();
    }

    private static void beolvasas() {
        try {
            Scanner be = new Scanner(new FileInputStream("C:\\Users\\Lilla\\Documents\\NetBeansProjects\\hegyek\\src\\hegyek\\hegyekMo.txt"), "UTF-8");
            be.nextLine();
            while(be.hasNextLine()){
                String sor = be.nextLine();
                String [] adatok = sor.split(";");
                hegyek.add(new hegysegek(adatok[0],adatok[1],Integer.parseInt(adatok[2])));
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Exception: "+ex);
        }
    }

    private static void kiir() {
        int db = 0;
        for (int i = 0; i < hegyek.size(); i++) {
            db++; 
        }
        System.out.println("3.feladat \n"+ "Hegycsúcsok száma: "+db);
    }

    private static void atlag() {
        System.out.println("4.feladat \n"+ "Hegycsúcsok átlagmagassága: "+hegyek.get(hegyek.size() - 1).getHegym()+"m");
    }

    private static void legmagasabb() {
        int max = 0;
        for (int i = 0; i < hegyek.size(); i++) {
            if(hegyek.get(i).getHegym() > max){
                max = hegyek.get(i).getHegym();
                 System.out.println("5.feladat \n"+ "A legmagasabb hegycsúcs adatai: "+"\n"+"Név: "+hegyek.get(i).getHegycsucsnev()+"\n" +"Hegység: "+hegyek.get(i).getHegyseg()+"\n"+"Magasság: "+hegyek.get(i).getHegym());
            }
        }
    }

    private static void beker() {
        Scanner be = new Scanner(System.in);
        System.out.print("Kérek egy magasságot: ");
        szam = be.nextInt();
        for (int i = 0; i < 10; i++) {
            if(szam < hegyek.get(i).getHegym()){
                System.out.println("Van a "+szam+"m-nél nagyobb hegy");
                return;
            }
        }
        System.out.println("Nincs "+szam+"m-nél nagyobb hegy");
    }

    private static void szamitas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static void statisztika() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static void file() {
          try {
            FileWriter fw = new FileWriter("C:\\Users\\Lilla\\Documents\\NetBeansProjects\\Vizibiciklikolcsonzo\\src\\Vizibiciklikolcsonzo\\F.txt");
            for (int i = 0; i < hegyek.size(); i++) {
                {
              
                    //fw.write();
                    //fw.write();
                }
            }
            fw.close();
        } catch (IOException ex) {
            System.out.println("Exception" + ex);
        }
    }
    
}
