/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hegyek;

/**
 *
 * @author Lilla
 */
public class hegysegek {
    private String hegycsucsnev;
    private String hegyseg;
    private int hegym;

    public hegysegek(String hegycsucsnev, String hegyseg, int hegym) {
        this.hegycsucsnev = hegycsucsnev;
        this.hegyseg = hegyseg;
        this.hegym = hegym;
    }

    public int getHegym() {
        return hegym;
    }

    public void setHegym(int hegym) {
        this.hegym = hegym;
    }

    public String getHegycsucsnev() {
        return hegycsucsnev;
    }

    public void setHegycsucsnev(String hegycsucsnev) {
        this.hegycsucsnev = hegycsucsnev;
    }

    public String getHegyseg() {
        return hegyseg;
    }

    public void setHegyseg(String hegyseg) {
        this.hegyseg = hegyseg;
    }
    
}
