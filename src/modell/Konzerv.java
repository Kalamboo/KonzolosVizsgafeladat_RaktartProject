/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modell;

import java.io.File;
import java.time.LocalDate;

/**
 *
 * @author vizsgaszf
 */
public class Konzerv extends Elelmiszer{
    private String leiras;
    private File recept;
    
    public Konzerv(String leiras, String nev, String gyarto) throws LejartTermekException {
        this(leiras, nev, gyarto, LocalDate.now().plusYears(1));
    }
    
    public Konzerv(String leiras, String nev, String gyarto, LocalDate lejaratiDatum) throws LejartTermekException {
        this(leiras, new File("."), nev, gyarto, lejaratiDatum);
    }
    
    public Konzerv(String leiras, File recept, String nev, String gyarto) throws LejartTermekException {
        this(leiras, recept, nev, gyarto, LocalDate.now().plusYears(1));
    }

    public Konzerv(String leiras, File recept, String nev, String gyarto, LocalDate lejaratiDatum) throws LejartTermekException {
        super(nev, gyarto, lejaratiDatum);
        this.leiras = leiras;
        this.recept = recept;
    }
    
    public String receptMutat(){
        if (recept.exists()) {
            return "*Recept megmutatása*";
        }
        return "Nem létezik a recept!";
    }

    public String getLeiras() {
        return leiras;
    }

    public File getRecept() {
        return recept;
    }

    @Override
    public String toString() {
        String os = super.toString();
        return os + "Konzerv{" + "leiras=" + leiras + ", recept=" + recept + '}';
    }
}
