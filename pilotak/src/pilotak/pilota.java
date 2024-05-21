/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pilotak;

import java.time.LocalDate;

/**
 *
 * @author Lilla
 */
public class pilota {
    private String nev;
    private LocalDate szuletesi_datum;
    private String nemzetiseg;
    private Integer rajtszam;

    public pilota() {
    }

    public pilota(String nev, LocalDate szuletesi_datum, String nemzetiseg, Integer rajtszam) {
        this.nev = nev;
        this.szuletesi_datum = szuletesi_datum;
        this.nemzetiseg = nemzetiseg;
        this.rajtszam = rajtszam;
    }

    public Integer getRajtszam() {
        return rajtszam;
    }

    public void setRajtszam(Integer rajtszam) {
        this.rajtszam = rajtszam;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public LocalDate getSzuletesi_datum() {
        return szuletesi_datum;
    }

    public void setSzuletesi_datum(LocalDate szuletesi_datum) {
        this.szuletesi_datum = szuletesi_datum;
    }

    public String getNemzetiseg() {
        return nemzetiseg;
    }

    public void setNemzetiseg(String nemzetiseg) {
        this.nemzetiseg = nemzetiseg;
    }
}
