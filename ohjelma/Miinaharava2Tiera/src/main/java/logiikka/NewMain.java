/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logiikka;

import grafiikka.Kayttoliityma;
import java.util.Scanner;
import javax.swing.SwingUtilities;

/**
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
        Kartanluonti d = new Kartanluonti(korkeus, leveys, m);
        RuudukkoAvatutuSuljetut z = new RuudukkoAvatutuSuljetut(korkeus, leveys, d);

        Kayttoliityma kayttoliittyma = new Kayttoliityma(z, korkeus, leveys);
        SwingUtilities.invokeLater(kayttoliittyma);

        /*
        Scanner lukija = new Scanner(System.in);
        RuudukkoAvatutuSuljetut j = new RuudukkoAvatutuSuljetut(10, 5, 0);
        System.out.println(j.toString());
        
        while (true){
            System.out.println("Rajat 1-10");
            System.out.println("Anna x ");
            int x = Integer.parseInt(lukija.nextLine()) -1;
            System.out.println("Anna y ");
            int y = Integer.parseInt(lukija.nextLine()) -1;
            j.avaaruutu(x, y);
            System.out.println(j);
            
        }
         */
    }

}
