/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logiikka;

import java.util.Scanner;

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
        RuudukkoAvatutuSuljetut j = new RuudukkoAvatutuSuljetut(10, 5, 40);
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
        
    }

}
