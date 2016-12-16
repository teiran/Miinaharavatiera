/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafiikka;

import java.awt.GridLayout;
import javax.swing.JPanel;
import logiikka.PelinLogiikka;
import logiikka.Ruutu;
import static logiikka.Kartanluonti.kartanluonti;

/**
 * Paneli pelin grafiikalle (peliruuduille ja näiden kuutelioille).
 * 
 * @author tiera
 */
public class PeliPanelit {
    
    private RuutuButton[][] ruudut;
    private int korkeus;
    private int leveys;
    private final KayttoLiityma kayttoLiityma;
    /**
     * alustaa tämän panelin käyttöön.
     * 
     * @param k käyttöliitymä (final)
     */
    public PeliPanelit(KayttoLiityma k) {
        kayttoLiityma = k;
    }
    
    /**
     * päivittää uuden korkeuden ja leveyden ja luo uuden grafiisen ruudukon.
     * 
     * @param korke ruudukon uusi korkeus
     * @param leve  ruudukon uusi leveys
     */
    public void paivita(int korke, int leve) {
        korkeus = korke;
        leveys = leve;
        ruudut = new RuutuButton[korkeus][leveys];
    }
    
    /**
     * luo uudet ruudut grafiikkan hakee tiedot käyttöliitymästä.
     * 
     * @param i koska käytin GridLayouttia niin käyttöliitymä jakaa grafiikan sopiviin osii ja i kertoo osan tälle metodille joka hoitaa loput
     * @return Palauttaa tämän yhden mittaisen Panelin
     */
    public JPanel luoRuudut(int i) {
        JPanel panel = new JPanel(new GridLayout(1, leveys));
        for (int j = 0; j < leveys; j++) {
            ruudut[i][j] = new RuutuButton(kayttoLiityma.getLogiikka(i, j), this, i, j);
            panel.add(ruudut[i][j]);
        }
        return panel;
    }
    /**
     * Ruudusta kutsutaa tätä metodia jolla kutsutaan käyttöliitymää ja päivitetään ruudulta tullut komento.
     * 
     * @param x logiikan ja grafiikan taulukon korkeus suuntainen koordinaatti
     * @param y logiikan ja grafiikan taulukon leveys suuntainen koordinaatti
     * @param oikeeVaiVasen numerosille että mitä nappulaa on painettu
     */
    public void paivitaAvaus(int x, int y, int oikeeVaiVasen) {
        kayttoLiityma.paivitaAvaus(x, y, oikeeVaiVasen);
    }

    
    /**
     * päivittää ruudut logiikan mukaiseksi.
     * 
     * @param x logiikan ja grafiikan taulukon korkeus suuntainen koordinaatti
     * @param y logiikan ja grafiikan taulukon leveys suuntainen koordinaatti
     * @param arvo palauttaa logiikalta saamansa arvon Stringmuodossa
     */
    public void paivitaRuudut(int x, int y, String arvo) {
        ruudut[x][y].setArvo(arvo);
    }

}
