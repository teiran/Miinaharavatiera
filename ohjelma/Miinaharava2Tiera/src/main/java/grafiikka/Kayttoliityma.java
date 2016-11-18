/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafiikka;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import logiikka.RuudukkoAvatutuSuljetut;

/**
 *
 * @author tiera
 */
public class Kayttoliityma implements Runnable{
    
    private JFrame frame;
    private RuudukkoAvatutuSuljetut logiikka;
    private RuutuButton[][] ruudut;
    private int korkeus;
    private int leveys;

    public Kayttoliityma() {
        Scanner lukija = new Scanner(System.in);
        System.out.println("Ruudukon leveys ");
        korkeus = Integer.parseInt(lukija.nextLine());
        System.out.println("Ruudukon korkeus ");
        leveys = Integer.parseInt(lukija.nextLine());
        System.out.println("Miinojen maara ");
        int m = Integer.parseInt(lukija.nextLine());
        logiikka = new RuudukkoAvatutuSuljetut(korkeus, leveys, m);
        
    }
    
    
    
    @Override
    public void run() {
        frame = new JFrame("Sudoku");
        frame.setPreferredSize(new Dimension(1000, 1000));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luokomponetti(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
        
        
    }
    
    public void peli(){
        for (int i = 0; i < korkeus; i++) {
            for (int j = 0; j < leveys; j++) {
                if (ruudut[i][j].getPainettu() == 1) {
                    logiikka.avaaruutu(i, j);
                    ruudut[i][j].setPainettu(0);
                } else if (ruudut[i][j].getPainettu() == 2) {
                    logiikka.lippu(i, j);
                    ruudut[i][j].setPainettu(0);
                }
            }
        }
        for (int i = 0; i < korkeus; i++) {
            for (int j = 0; j < leveys; j++) {
                ruudut[i][j].setArvo(logiikka.kartta()[i][j]);
            }
        }
    }
    
    private void luokomponetti(Container container){
        frame.setLayout(new GridLayout(10, 10));
        ruudut = new RuutuButton[korkeus][leveys];
        for (int i = 0; i < korkeus; i++) {
            for (int j = 0; j < leveys; j++) {
                ruudut[i][j] = new RuutuButton(logiikka.kartta()[i][j],this);
                Ruudunkuuntelija k = new Ruudunkuuntelija(ruudut[i][j]);
                ruudut[i][j].addMouseListener(k);
                container.add(ruudut[i][j]);
            }
        }
    }
    
}
