/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafiikka;

import java.awt.event.MouseListener;
import javax.swing.JButton;

/**
 * Ruudun kuva ja kuuntelija.
 * @author tiera
 */
public class RuutuButton extends JButton implements MouseListener {
    
    private String arvo;
    private final PeliPanelit k;
    private final int x;
    private final int y;
    /**
     * Ruudun konstruktori.
     * 
     * @param arvo String arvo "mitä ruutu näyttää ulos"
     * @param k linkki pelipaneliin
     * @param x logiikan ja grafiikan taulukon korkeus suuntainen koordinaatti
     * @param y  logiikan ja grafiikan taulukon leveys suuntainen koordinaatti
     */
    public RuutuButton(String arvo, PeliPanelit k, int x, int y) {
        this.arvo = arvo;
        this.k = k;
        this.x = x;
        this.y = y;
        this.addMouseListener(this);
        muutaTextia();
    }
    
    /**
     * kun hiirtä painetaa tämä aktivoituu ja kutsuu paivitaAvaius metodia PeliPanelissa.
     * 
     * @param e hiirenkuuntelija
     */
    
    @Override
    public void mouseClicked(java.awt.event.MouseEvent e) {
        k.paivitaAvaus(x, y, e.getButton());
        
    }
    
    /**
     * muuttaa ruudun arvoa ja tekstiä.
     * 
     * @param g uusi String muotoinen arvo
     */
    public void setArvo(String g) {
        arvo = g;
        muutaTextia();
    }
    
    /**
     * muuttaa ruudun teksitä.
     * 
     */
    private void muutaTextia() {
        this.setText(arvo);
    }

    @Override
    public void mousePressed(java.awt.event.MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(java.awt.event.MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(java.awt.event.MouseEvent e) {
    }

    @Override
    public void mouseExited(java.awt.event.MouseEvent e) {
        
    }
    
}
