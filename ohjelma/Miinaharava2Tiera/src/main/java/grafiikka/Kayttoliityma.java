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
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;
import static logiikka.Kartanluonti.Kartanluonti;
import logiikka.Ruutu;
import logiikka.PelinLogiikka;

/**
 * pyörittää graafista käyttöliitymää ja yhdistää tämän logiikkaan.
 *
 * @author tiera
 */
public class Kayttoliityma implements Runnable {

    private JFrame frame;
    private PelinLogiikka logiikka;
    private RuutuButton[][] ruudut;
    private int korkeus;
    private int leveys;
    private int miinojenmaara;
    private JTextArea korkeudenlukija;
    private JTextArea leveydenlukija;
    private JTextArea miinojenlukija;

    
    
    public Kayttoliityma() {
        korkeus = 0;
        leveys = 0;
        miinojenmaara = 0;
    }

    /**
     * alustaa käyttöliitymän
     */
    @Override
    public void run() {
        pelijossaeioleruudukko();
    }

    public void paivitagrafiikkaa() {
        muutaMiinojenmaraakorkeuttaleveytta();
        frame.setVisible(false);
        frame.removeAll();
        if (korkeus > 0 && leveys > 0 && korkeus * leveys >= miinojenmaara) {
            pelijossaonruudukko();
        } else {
            pelijossaeioleruudukko();
        }

    }

    private void muutaMiinojenmaraakorkeuttaleveytta() {
        String g = "Miinojenmaara \n jos tyhjä \n ekalla kerralla \n menee rikki, \n vain numeroita";
        if (miinojenlukija.getText().equals(g)) {

        } else if (!miinojenlukija.getText().isEmpty()) {
            miinojenmaara = Integer.parseInt(miinojenlukija.getText());
        }
        String g2 = "leveys \n jos tyhjä \n ekalla kerralla \n menee rikki, \n vain numeroita";
        if (leveydenlukija.getText().equals(g2)) {

        } else if (!leveydenlukija.getText().isEmpty()) {
            leveys = Integer.parseInt(leveydenlukija.getText());
        }
        String g3 = "korkeuden \n jos tyhjä \n ekalla kerralla \n menee  rikki, \n vain numeroita";
        if (korkeudenlukija.getText().equals(g3)) {

        } else if (!korkeudenlukija.getText().isEmpty()) {
            korkeus = Integer.parseInt(korkeudenlukija.getText());
        }
    }

    private void pelijossaeioleruudukko() {
        frame = new JFrame("Miinaharava");
        frame.setPreferredSize(new Dimension(400, 120));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        aloitapeli(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }

    private void pelijossaonruudukko() {
        frame = new JFrame("Miinaharava");
        frame.setPreferredSize(new Dimension(100 * leveys + 100, 100 * korkeus));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        int y = miinojenmaara;
        Ruutu[][] f = Kartanluonti(korkeus, leveys, y);
        logiikka = new PelinLogiikka(korkeus, leveys, f);

        luokomponetti(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }

    private void aloitapeli(Container container) {
        container.setLayout(new GridLayout(1, 4));
        container.add(luovalikko());
    }

    private void luokomponetti(Container container) {
        container.setLayout(new GridLayout(korkeus + 1, 1));
        container.add(luovalikko());
        ruudut = new RuutuButton[korkeus][leveys];
        for (int i = 0; i < korkeus; i++) {
            container.add(luoruudut(i));
        }
    }

    private JPanel luoruudut(int i) {
        JPanel panel = new JPanel(new GridLayout(1, leveys));
        for (int j = 0; j < leveys; j++) {
            ruudut[i][j] = new RuutuButton(logiikka.kartta()[i][j].toString(), this, i, j);
            panel.add(ruudut[i][j]);
        }

        return panel;
    }

    private JPanel luovalikko() {
        JPanel panel = new JPanel(new GridLayout(1, 2));
        JTextArea k3 = new JTextArea("Miinojenmaara \n jos tyhjä \n ekalla kerralla \n menee rikki, \n vain numeroita");
        panel.add(k3);
        miinojenlukija = k3;
        Uusintanappula u = new Uusintanappula(this);
        panel.add(u);
        JTextArea k1 = new JTextArea("korkeuden \n jos tyhjä \n ekalla kerralla \n menee  rikki, \n vain numeroita");
        panel.add(k1);
        korkeudenlukija = k1;
        JTextArea k2 = new JTextArea("leveys \n jos tyhjä \n ekalla kerralla \n menee rikki, \n vain numeroita");
        panel.add(k2);
        leveydenlukija = k2;

        return panel;
    }

    public void paivitaAvaus(int x, int y) {
        if (logiikka.isOnkomiinatavattu()) {
            return;
        }
        logiikka.avaaruutu(x, y);
        paivitaruudut();
    }

    public void paivitaLippu(int x, int y) {
        if (logiikka.isOnkomiinatavattu()) {
            return;
        }
        logiikka.lippu(x, y);
        paivitaruudut();
    }

    private void paivitaruudut() {
        for (int i = 0; i < korkeus; i++) {
            for (int j = 0; j < leveys; j++) {
                ruudut[i][j].setArvo(logiikka.kartta()[i][j].toString());
            }
        }
    }

}
