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
    private final Kayttoliityma k;
    private final int x;
    private final int y;

    public RuutuButton(String arvo, Kayttoliityma k, int x, int y) {
        this.arvo = arvo;
        this.k = k;
        this.x = x;
        this.y = y;
        this.addMouseListener(this);
        muutaTextia();
    }
    

    @Override
    public void mouseClicked(java.awt.event.MouseEvent e) {
        if (e.getButton() == 1) {
            k.paivitaAvaus(x, y);
        } else if (e.getButton() == 3) {
            k.paivitaLippu(x, y);
        }
        
    }
    
    public void setArvo(String g){
        arvo = g;
        muutaTextia();
    }
    
    private void muutaTextia(){
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
