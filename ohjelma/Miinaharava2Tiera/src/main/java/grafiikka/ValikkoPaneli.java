/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafiikka;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * Pitää sisällään uusintanappulan, ja korkeutta, leveyttä ja miinoja sisälläpitävät tekstikentät.
 * 
 * @author tiera
 */
public class ValikkoPaneli {

    private JPanel panel;
    private JTextArea korkeudenLukija;
    private JTextArea leveydenLukija;
    private JTextArea miinojenLukija;
    private final KayttoLiityma kayttoLiityma;
    
    /**
     * Valikko panelin konstruktori.
     * 
     * @param k linkki käyttöliitymään
     */
    public ValikkoPaneli(KayttoLiityma k) {
        kayttoLiityma = k;
    }
    
    /**
     * päivittää uuden valikon grafiikan muutuessa.
     * 
     */
    public void paivita() {
        panel = new JPanel(new GridLayout());
        luoPalikat();
    }
    
    /**
     * luo panelin johon lisää tekstikentät ja uusintanappulan.
     * 
     */
    private void luoPalikat() {
        panel.setLayout(new GridLayout(1, 4));
        panel.add(tekstiKentaM());
        UusintaNappula u = new UusintaNappula(this);
        panel.add(u);
        panel.add(tekstiKentaK());
        panel.add(tekstiKentaL());
    }
    
    /**
     * Luo kirjotettavan teksitikentän (JTextArea) ja nimen tälle (JLabel) miinojenmäärälle.
     * 
     * @return palautta tämän panelin joka sitte listätään tämän olion grafiikkan.
     */
    private JPanel tekstiKentaM() {
        JPanel q = new JPanel(new GridLayout(2, 1));
        JLabel s3 = new JLabel("miinat \n (maara)");
        q.add(s3);
        miinojenLukija = new JTextArea();
        q.add(miinojenLukija);
        return q;
    }
    
    /**
     * Luo kirjotettavan teksitikentän (JTextArea) ja nimen tälle (JLabel) korkeudelle.
     * 
     * @return palautta tämän panelin joka sitte listätään tämän olion grafiikkan.
     */
    private JPanel tekstiKentaK() {
        JPanel q = new JPanel(new GridLayout(2, 1));
        JLabel s3 = new JLabel("Korkeus");
        q.add(s3);
        korkeudenLukija = new JTextArea();
        q.add(korkeudenLukija);
        return q;
    } 
    
    /**
     * Luo kirjotettavan teksitikentän (JTextArea) ja nimen tälle (JLabel) leveydelle.
     * 
     * @return palautta tämän panelin joka sitte listätään tämän olion grafiikkan.
     */
    private JPanel tekstiKentaL() {
        JPanel q = new JPanel(new GridLayout(2, 1));
        JLabel s3 = new JLabel("Leveys");
        q.add(s3);
        leveydenLukija = new JTextArea();
        q.add(leveydenLukija);
        return q;
    }
    
    /**
     * antaa tämänolion panelin.
     * 
     * @return palauttaa tämän olion panelin käyttöliitymälle
     */
    public JPanel getPanel() {
        return panel;
    }
    
    /**
     * muutaa miinojenmäärän, leveyden ja korkeuden jos niissä jotain järkvää.'
     * 
     * @param korkeus vanha korkeus
     * @param leveys vanha leveys
     * @param miinojenMaara vanha miinojenmäärä
     */
    public void muutaSyoteet(int korkeus, int leveys, int miinojenMaara) {
        int korkeus2 = muutaKorkeus(korkeus);
        int leveys2 = muutaLeveys(leveys);
        int miinojenmaara2 = muutaMiinojenMaara(miinojenMaara);
        if (korkeus2 >= 0 && leveys2 >= 0 && korkeus2 * leveys2 >= miinojenmaara2) {
            kayttoLiityma.setMiinojenmaara(miinojenmaara2);
            kayttoLiityma.setLeveys(leveys2);
            kayttoLiityma.setKorkeus(korkeus2);
        }
    }
    
    /**
     * tutkii onko miinojenmäärää määrittävän tekstikentän syöte lukukelpoista.
     * 
     * @param k vanha miinojenmäärä.
     * @return  uusi miinojenmäärä (voi olla sama)
     */
    
    private int muutaMiinojenMaara(int k) {
        try {
            k = Integer.parseInt(miinojenLukija.getText());
        } catch (NumberFormatException e) {
            
        }
        return k;
        
    }
    
    
    /**
     * tutkii onko leveyttä määrittävän tekstikentän syöte lukukelpoista.
     * 
     * @param k vanha leveys
     * @return  uusi leveys (voi olla sama)
     */
    private  int muutaLeveys(int k) {
        try {
            k = Integer.parseInt(leveydenLukija.getText());
        } catch (NumberFormatException e) {
            
        }
        return k;
        
    }
    
    /**
     * tutkii onko korkeuden määrittävän tekstikentän syöte lukukelpoista.
     * 
     * @param k vanha korkeus
     * @return uusi korkeus (voi olla sama)
     */
    private  int muutaKorkeus(int k) {
        try {
            k = Integer.parseInt(korkeudenLukija.getText());
        } catch (NumberFormatException e) {
            
        }
        return k;
        
    }
    
    
    /**
     * linkki uuden pelinappulan välillä ja käyttöliitymän.
     */
    public void uusiPeli() {
        kayttoLiityma.paivitaGrafiikkaa();
    }

}
