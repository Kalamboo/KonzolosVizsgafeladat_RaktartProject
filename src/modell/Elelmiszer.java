/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modell;

import java.io.Serializable;
import java.text.Collator;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;

/**
 *
 * @author vizsgaszf
 */
class NevComparator implements Comparator<Elelmiszer>{
    @Override
    public int compare(Elelmiszer o1, Elelmiszer o2) {
        Collator coll = Collator.getInstance();
        return coll.compare(o1.getNev(), o2.getNev());
    }
}

class GyartoComparator implements Comparator<Elelmiszer>{
    @Override
    public int compare(Elelmiszer o1, Elelmiszer o2) {
        Collator coll = Collator.getInstance();
        return coll.compare(o1.getGyarto(), o2.getGyarto());
    }
}


public abstract class Elelmiszer implements Serializable{
    private String nev, gyarto;
    private LocalDate lejaratiDatum;

    public Elelmiszer(String nev, String gyarto) throws LejartTermekException {
        this(nev, gyarto, LocalDate.now().plusYears(1));
    }
    
    public Elelmiszer(String nev, String gyarto, LocalDate lejaratiDatum) throws LejartTermekException {
        if (lejaratiDatum.isBefore(LocalDate.now())) {
            throw new LejartTermekException();
        }
        this.nev = nev;
        this.gyarto = gyarto;
        this.lejaratiDatum = lejaratiDatum;
    }
    
    public static NevComparator nevRendezo(){
        return new NevComparator();
    }
    
    public static GyartoComparator gyartoRendezo(){
        return new GyartoComparator();
    }
    
    public String getNev() {
        return nev;
    }

    public String getGyarto() {
        return gyarto;
    }

    public LocalDate getLejaratiDatum() {
        return lejaratiDatum;
    }

    @Override
    public String toString() {
        return "Elelmiszer{" + "nev=" + nev + ", gyarto=" + gyarto + ", lejaratiDatum=" + lejaratiDatum + '}';
    }
}
