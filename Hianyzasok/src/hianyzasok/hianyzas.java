/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hianyzasok;

/**
 *
 * @author Lilla
 */
public class hianyzas {
    private String nev;
    private String osztaly;
    private int Enap;
    private int Unap;
    private int Morak;

    public hianyzas(String nev, String osztaly, int Enap, int Unap, int Morak) {
        this.nev = nev;
        this.osztaly = osztaly;
        this.Enap = Enap;
        this.Unap = Unap;
        this.Morak = Morak;
    }

    public int getMorak() {
        return Morak;
    }

    public void setMorak(int Morak) {
        this.Morak = Morak;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public String getOsztaly() {
        return osztaly;
    }

    public void setOsztaly(String osztaly) {
        this.osztaly = osztaly;
    }

    public int getEnap() {
        return Enap;
    }

    public void setEnap(int Enap) {
        this.Enap = Enap;
    }

    public int getUnap() {
        return Unap;
    }

    public void setUnap(int Unap) {
        this.Unap = Unap;
    }
    
}
