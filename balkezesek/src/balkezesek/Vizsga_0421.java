/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package balkezesek;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Lilla
 */
public class Vizsga_0421 {

     static ArrayList<balkezesek> balkezesek = new ArrayList<>();
     ArrayList<balkezesek> utolso = new ArrayList<>();
     static int szam;
    
    public static void main(String[] args) throws FileNotFoundException {
        beolvasas();
        kiir();
        hataroz();
        beker();
        atlag();
        
    }
     private static void beolvasas() throws FileNotFoundException {
       try(Scanner be = new Scanner(new FileInputStream("C:\\Users\\Lilla\\Documents\\NetBeansProjects\\balkezesek\\src\\balkezesek\\balkezesek.csv"), "UTF-8")) {
        be.nextLine();
        while(be.hasNextLine()){
            String line = be.nextLine();
            String[] adatok = line.split(";");
            balkezesek.add(new balkezesek(adatok[0], LocalDate.parse(adatok[1]), LocalDate.parse(adatok[2]), Double.parseDouble(adatok[3]), Integer.parseInt(adatok[4])));
        }
       }
       
    }
  
    private static void kiir() {
        int db = 0;
        for(int i = 0; i <balkezesek.size(); i++){
            db++;
        }
        System.out.println(db);
        
    }

    private static void hataroz() {
        LocalDate utolsoKezdoDatum = LocalDate.of(1999, 10, 1);
        LocalDate utolsoVegDatum = LocalDate.of(1999, 10, 31);
        for(int i = 0; i<balkezesek.size(); i ++){
            if(balkezesek.get(i).getUtolso().isAfter(utolsoKezdoDatum) &&
                    balkezesek.get(i).getUtolso().isBefore(utolsoVegDatum)){
                Double magassag = BigDecimal.valueOf(balkezesek.get(i).getMagassag() * 2.54).setScale(3, RoundingMode.HALF_UP).doubleValue();
                System.out.println(balkezesek.get(i).getNev() + ", " + String.valueOf(magassag) + "cm");
            }
        }
    }
    

    private static void beker() {
       Scanner be = new Scanner(System.in);
       boolean igaz = false;
       System.out.print("Kérek egy számot 1990 és 1999 között: ");
       while(igaz == false){
        szam = be.nextInt();
        if(szam >= 1990 && szam <= 1999){
            igaz = true;
            System.out.println("Jó számot adtál meg!");
        }else{
            System.out.println("Hibás számot adtál meg!"); 
       }
      }
    }
    
    private static void atlag() {
        ArrayList<Double> sulyok = new ArrayList<>();
        for(int i = 0; i<balkezesek.size(); i++){
            if(balkezesek.get(i).getElso().getYear() <= szam && balkezesek.get(i).getUtolso().getYear() >= szam){
                sulyok.add(balkezesek.get(i).getSuly());
            }
        }
        Double sulyokOsszeg = 0.0;
        for(Double d : sulyok){
            sulyokOsszeg += d;
        }
        System.out.println(String.valueOf(BigDecimal.valueOf(sulyokOsszeg  / sulyok.size()).setScale(2, RoundingMode.HALF_UP).doubleValue()) + " font");
    }
}
    
     
    
    

