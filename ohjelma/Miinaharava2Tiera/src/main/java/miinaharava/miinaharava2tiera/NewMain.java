/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miinaharava.miinaharava2tiera;

import grafiikka.KayttoLiityma;
import javax.swing.SwingUtilities;

/**
 *  MainClass joka ajaa perus ohjelman
 * 
 * @author tiera
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        KayttoLiityma kayttoliittyma = new KayttoLiityma();
        SwingUtilities.invokeLater(kayttoliittyma);
    }

}
