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
import logiikka.Logiikankayttoliityma;
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
        Scanner lukija = new Scanner(System.in);
        System.out.println("Ruudukon leveys ");
        int korkeus = Integer.parseInt(lukija.nextLine());
        System.out.println("Ruudukon korkeus ");
        int leveys = Integer.parseInt(lukija.nextLine());
        System.out.println("Miinojen maara ");
        int m = Integer.parseInt(lukija.nextLine());
        Ruutu[][] d = Kartanluonti(korkeus, leveys, m);
        Logiikankayttoliityma z = new Logiikankayttoliityma(korkeus, leveys, d);

        Kayttoliityma kayttoliittyma = new Kayttoliityma(z, korkeus, leveys);
        SwingUtilities.invokeLater(kayttoliittyma);
    }

}
