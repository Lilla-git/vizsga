/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vizibiciklikolcsonzo;

/**
 *
 * @author Lilla
 */
public class kolcsonzes {
    private String nev;
    private String Jazon;
    private String Eora;
    private String Eperc;
    private String Vora;
    private String Vperc;

    public kolcsonzes(String nev, String Jazon, String Eora, String Eperc, String Vora, String Vperc) {
        this.nev = nev;
        this.Jazon = Jazon;
        this.Eora = Eora;
        this.Eperc = Eperc;
        this.Vora = Vora;
        this.Vperc = Vperc;
    }

    public String getVperc() {
        return Vperc;
    }

    public void setVperc(String Vperc) {
        this.Vperc = Vperc;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public String getJazon() {
        return Jazon;
    }

    public void setJazon(String Jazon) {
        this.Jazon = Jazon;
    }

    public String getEora() {
        return Eora;
    }

    public void setEora(String Eora) {
        this.Eora = Eora;
    }

    public String getEperc() {
        return Eperc;
    }

    public void setEperc(String Eperc) {
        this.Eperc = Eperc;
    }

    public String getVora() {
        return Vora;
    }

    public void setVora(String Vora) {
        this.Vora = Vora;
    }
    
}
