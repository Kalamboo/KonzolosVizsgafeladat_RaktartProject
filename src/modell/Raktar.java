/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modell;

import java.io.File;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vizsgaszf
 */
public class Raktar implements Iterable<Elelmiszer>, Serializable{
    ArrayList<Elelmiszer> elelmiszerek;

    public Raktar() {
        elelmiszerek = new ArrayList<>();
        
        try {
            Elelmiszer e1 = new Konzerv("Babot tartalmaz", "Babkonzerv", "Teletál");
            Elelmiszer e2 = new Konzerv("Lencsét tartalmaz", new File("recept.txt"), "Lencsekonzerv", "Alms");
            Elelmiszer e3 = new Konzerv("Epret tartalmaz", "Eperkonzerv", "SASA", LocalDate.now());
            Elelmiszer e4 = new Konzerv("Sajt tartalmaz(hat)", new File("."), "Sajtkonzerv", "JASS", LocalDate.now().plusMonths(1));
            
            elelmiszerek.add(e1);
            elelmiszerek.add(e2);
            elelmiszerek.add(e3);
            elelmiszerek.add(e4);
        } catch (LejartTermekException ex) {
            Logger.getLogger(Raktar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public Iterator<Elelmiszer> iterator() {
        return Collections.unmodifiableList(elelmiszerek).iterator();
    }
    
    public List<Elelmiszer> rendezNevSzerint(){
        Collections.sort(elelmiszerek, Elelmiszer.nevRendezo());
        return Collections.unmodifiableList(elelmiszerek);
    }
    
    public List<Elelmiszer> rendezGyartoSzerint(){
        Collections.sort(elelmiszerek, Elelmiszer.gyartoRendezo());
        return Collections.unmodifiableList(elelmiszerek);
    }
}
