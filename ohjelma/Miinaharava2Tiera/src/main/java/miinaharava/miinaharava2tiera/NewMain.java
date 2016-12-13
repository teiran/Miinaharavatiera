/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miinaharava.miinaharava2tiera;

import grafiikka.Kayttoliityma;
import java.util.Scanner;
import javax.swing.SwingUtilities;
import logiikka.Ruutu;
import logiikka.PelinLogiikka;
import static logiikka.Kartanluonti.Kartanluonti;

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
        Kayttoliityma kayttoliittyma = new Kayttoliityma();
        SwingUtilities.invokeLater(kayttoliittyma);
    }

}
