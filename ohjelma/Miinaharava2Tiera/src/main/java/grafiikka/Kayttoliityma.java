/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafiikka;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import static logiikka.Kartanluonti.Kartanluonti;
import static logiikka.Kartanluonti.miinojenmaara;
import logiikka.Ruutu;
import logiikka.Logiikankayttoliityma;

/**
 * pyörittää graafista käyttöliitymää ja yhdistää tämän logiikkaan.
 * @author tiera
 */
public class Kayttoliityma implements Runnable {

    private JFrame frame;
    private Logiikankayttoliityma logiikka;
    private RuutuButton[][] ruudut;
    private final int korkeus;
    private final int leveys;
    /**
     * 
     * @param k logiikkan käyttöliitymä
     * @param korkeus kentän korkeus
     * @param leveys  kentän leveys
     */
    public Kayttoliityma(Logiikankayttoliityma k, int korkeus, int leveys) {
        this.korkeus = korkeus;
        this.leveys = leveys;
        logiikka = k;

    }
    /**
     * alustaa käyttöliitymän
     */
    @Override
    public void run() {
        frame = new JFrame("Sudoku");
        frame.setPreferredSize(new Dimension(100 * korkeus, 100 * leveys));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luokomponetti(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);

    }   
    /**
     * Peli looppi
     * 
     * @param ruutu graafinenruutu mitä ollan painettu
     * @param f kummalla hiiren näppäimellä ollaan painettu
     */
    public void paivitaAvaus(int x, int y) {
        if (logiikka.isOnkomiinatavattu()) {
            return;
        }
        logiikka.avaaruutu(x, y);
        paivitaruudut();
    }
    
    public void paivitaLippu(int x, int y){
        if (logiikka.isOnkomiinatavattu()) {
            return;
        }
        logiikka.lippu(x, y);
        paivitaruudut();
    }
    
    private void paivitaruudut(){
        for (int i = 0; i < korkeus; i++) {
            for (int j = 0; j < leveys; j++) {
                ruudut[i][j].setArvo(logiikka.kartta()[i][j].toString());
            }
        }
    }
    
    public void aloitauusipeli(){
        int y = miinojenmaara();
        Ruutu[][] f = Kartanluonti(korkeus, leveys, y);
        logiikka = new Logiikankayttoliityma(korkeus, leveys, f);
        paivitaruudut();
        
    }

    private void luokomponetti(Container container) {
        frame.setLayout(new GridLayout(korkeus+1, leveys));
        ruudut = new RuutuButton[korkeus][leveys];
        for (int i = 0; i < korkeus; i++) {
            for (int j = 0; j < leveys; j++) {
                ruudut[i][j] = new RuutuButton(logiikka.kartta()[i][j].toString(), this, i, j);
                container.add(ruudut[i][j]);
            }
        }
        container.add(new Uusintanappula(this));
    }

}
