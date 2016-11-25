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
import logiikka.Kartanluonti;
import logiikka.RuudukkoAvatutuSuljetut;

/**
 *
 * @author tiera
 */
public class Kayttoliityma implements Runnable {

    private JFrame frame;
    private RuudukkoAvatutuSuljetut logiikka;
    private RuutuButton[][] ruudut;
    private int korkeus;
    private int leveys;
    /**
     * 
     * @param k logiikkan käyttöliitymä
     * @param korkeus kentän korkeus
     * @param leveys  kentän leveys
     */
    public Kayttoliityma(RuudukkoAvatutuSuljetut k, int korkeus, int leveys) {
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
    public void peli(RuutuButton ruutu, int f) {
        if (logiikka.isOnkomiinatavattu()) {
            return;
        }
        int x = ruutu.x();
        int y = ruutu.y();
        if (ruudut[x][y] == ruutu) {
            if (f == 1) {
                logiikka.avaaruutu(x, y);
            } else if (f == 2) {
                logiikka.lippu(x, y);
            }
        }

        for (int i = 0; i < korkeus; i++) {
            for (int j = 0; j < leveys; j++) {
                ruudut[i][j].setArvo(logiikka.kartta()[i][j].toString());
            }
        }
    }

    private void luokomponetti(Container container) {
        frame.setLayout(new GridLayout(korkeus, leveys));
        ruudut = new RuutuButton[korkeus][leveys];
        for (int i = 0; i < korkeus; i++) {
            for (int j = 0; j < leveys; j++) {
                ruudut[i][j] = new RuutuButton(logiikka.kartta()[i][j].toString(), this, i, j);
                Ruudunkuuntelija k = new Ruudunkuuntelija(ruudut[i][j]);
                ruudut[i][j].addMouseListener(k);
                container.add(ruudut[i][j]);
            }
        }
    }

}
