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
import logiikka.Ruutu;
import logiikka.PelinLogiikka;
import static logiikka.Kartanluonti.kartanLuonti;

/**
 * pyörittää graafista käyttöliitymää, logiikkaan ja valikon.
 *
 * @author tiera
 */
public class KayttoLiityma implements Runnable {

    private JFrame frame;
    private int korkeus;
    private int leveys;
    private int miinojenmaara;
    private final ValikkoPaneli valikko;
    private final PeliPanelit peli;
    private PelinLogiikka logiikka;

    /**
     * Käyttöliitymänkonstuktori joka alustaa käyttöliitymän ja luo valikko ja peli panelit.
     */
    public KayttoLiityma() {
        korkeus = 0;
        leveys = 0;
        miinojenmaara = 0;
        peli = new PeliPanelit(this);
        valikko = new ValikkoPaneli(this);

    }
    /**
     * Palaa logiikalta pelipanelille string muodossa arvot.
     * 
     * @param x logiikan ja grafiikan taulukon korkeus suuntainen koordinaatti
     * @param y logiikan ja grafiikan taulukon leveys suuntainen koordinaatti
     * @return palauttaa logiikalta saamansa arvon Stringmuodossa
     */
    public String getLogiikka(int x, int y) {
        return logiikka.kartta()[x][y].toString();
    }

    /**
     * käyttöliitymän aloittava looppi joka alustaa alkuvalikon.
     * 
     */
    @Override
    public void run() {
        frame = new JFrame("Miinaharava");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        luoPelkkaValikko(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }
    /**
     * päivittää valikon valintojen mukaisesksi kutsutaan uutta peliä luotaessa.
     * 
     */
    public void paivitaGrafiikkaa() {
        valikko.muutaSyoteet(korkeus, leveys, miinojenmaara);
        frame.setVisible(false);
        frame.removeAll();
        frame = new JFrame("Miinaharava");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        if (korkeus == 0 || leveys == 0) {
            luoPelkkaValikko(frame.getContentPane());
        } else {
            luoValikkoJaPeli(frame.getContentPane());
        }
        frame.pack();
        frame.setVisible(true);

    }
    /**
     * luo pelkällävalikolla varusetun version grafiikasta.
     * 
     * @param container sinne laitetaan panelit
     */
    private void luoPelkkaValikko(Container container) {
        frame.setPreferredSize(new Dimension(500, 100));
        valikko.paivita();
        container.add(valikko.getPanel());
    }
    /**
     * versio jossa on valikko ja varsinainen peli.
     * 
     * @param container paikka minne pannaa panelit
     */
    private void luoValikkoJaPeli(Container container) {
        frame.setPreferredSize(new Dimension(50 * leveys + 50, 50 * korkeus));
        container.setLayout(new GridLayout(korkeus + 1, 1));
        valikko.paivita();
        container.add(valikko.getPanel());
        peli.paivita(korkeus, leveys);
        Ruutu[][] f = kartanLuonti(korkeus, leveys, miinojenmaara);
        logiikka = new PelinLogiikka(korkeus, leveys, f);
        for (int i = 0; i < korkeus; i++) {
            container.add(peli.luoRuudut(i));
        }
    }
    
    /**
     * muokkaa korkeutta (kutsutaan valikkopanelista uutta kartta luodessa).
     * 
     * @param korkeus uusi pelikartan korkeus
     */
    public void setKorkeus(int korkeus) {
        this.korkeus = korkeus;
    }
    /**
     * muokkaa miinojenmäärää (kutsutaan valikkopanelista uutta kartta luodessa).
     * 
     * @param miinojenmaara uudenpelikartan miinojenmäärä
     */
    public void setMiinojenmaara(int miinojenmaara) {
        this.miinojenmaara = miinojenmaara;
    }
    /**
     * muokkaa leveyttä (kutsutaan valikkopanelista uutta kartta luodessa).
     * 
     * @param leveys uudenpelikartan leveys
     */
    public void setLeveys(int leveys) {
        this.leveys = leveys;
    }
     /**
      * linkki pelin "grafiikan" eli panelin ja logiikan välillä, kun painetaan nappulaa jollain kolmesta nappulasta tämä vie veistin grafiikalta logiikalle.
      * 
      * @param x logiikan ja grafiikan taulukon korkeus suuntainen koordinaatti
      * @param y logiikan ja grafiikan taulukon leveys suuntainen koordinaatti
      * @param oikeaVaiVasen numerosille että mitä nappulaa on painettu
      */
    public void paivitaAvaus(int x, int y, int oikeaVaiVasen) {
        logiikka.muutaRuutua(x, y, oikeaVaiVasen);
        paivitaRuudut();
    }
    
    /**
     * päivittää ruudut (grafiikan) muutetun logiikan mukaiseksi.
     * 
     */
    private void paivitaRuudut() {
        for (int i = 0; i < korkeus; i++) {
            for (int j = 0; j < leveys; j++) {
                peli.paivitaRuudut(i, j, logiikka.kartta()[i][j].toString());
            }
        }
        
    }
}
