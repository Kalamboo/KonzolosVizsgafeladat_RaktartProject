/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import modell.Elelmiszer;
import modell.Raktar;

/**
 *
 * @author vizsgaszf
 */
public class Program {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Raktar raktar = new Raktar();
        
        for (Elelmiszer elelmiszer : raktar.rendezGyartoSzerint()) {
            System.out.println(elelmiszer);
        }
        
        for (Elelmiszer elelmiszer : raktar.rendezNevSzerint()) {
            System.out.println(elelmiszer);
        }
    }
    
}
