/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package balkezesek;

import java.time.LocalDate;

/**
 *
 * @author Lilla
 */
public class balkezesek {
    public String nev;
    public LocalDate elso;
    public LocalDate utolso;
    public Double suly;
    public int magassag;

    public balkezesek(String nev, LocalDate elso, LocalDate utolso, Double suly, int magassag) {
        this.nev = nev;
        this.elso = elso;
        this.utolso = utolso;
        this.suly = suly;
        this.magassag = magassag;
    }

    public int getMagassag() {
        return magassag;
    }

    public void setMagassag(int magassag) {
        this.magassag = magassag;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public LocalDate getElso() {
        return elso;
    }

    public void setElso(LocalDate elso) {
        this.elso = elso;
    }

    public LocalDate getUtolso() {
        return utolso;
    }

    public void setUtolso(LocalDate utolso) {
        this.utolso = utolso;
    }

    public Double getSuly() {
        return suly;
    }

    public void setSuly(Double suly) {
        this.suly = suly;
    }

    @Override
    public String toString() {
        return "balkezesek{" + "nev=" + nev + ", elso=" + elso + ", utolso=" + utolso + ", suly=" + suly + ", magassag=" + magassag + '}';
    }
    
    
    
}
