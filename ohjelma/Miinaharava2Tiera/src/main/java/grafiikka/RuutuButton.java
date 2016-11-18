/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafiikka;

import javax.swing.JButton;

/**
 *
 * @author tiera
 */
public class RuutuButton extends JButton {
    private int arvo;
    private int painettu;
    private Kayttoliityma k;

    public RuutuButton(int arvo, Kayttoliityma k1) {
        this.arvo = arvo;
        painettu = 0;
        muutatextia();
        k = k1;
    }
    
    private void muutatextia(){
        if (arvo == -1) {
            this.setText(" ");
        } else if (arvo == -2) {
            this.setText("M");
        } else {
            this.setText("" + arvo + "");
        }
    }

    public void setArvo(int arvo) {
        this.arvo = arvo;
        muutatextia();
    }

    public void setPainettu(int painettu) {
        this.painettu = painettu;
        k.peli();
        
    }

    public int getPainettu() {
        return painettu;
    }

    
}
