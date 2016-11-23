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
    private Kayttoliityma k;

    public RuutuButton(int arvo, Kayttoliityma k1) {
        this.arvo = arvo;
        muutatextia();
        k = k1;
    }
    
    private void muutatextia(){
        if (arvo == -1 || arvo == 0) {
            this.setText(" ");
        } else if (arvo == -2) {
            this.setText("M");
        } else if (arvo == -3) {
            this.setText("L");
        } else {
            this.setText("" + arvo + "");
        }
    }

    public void setArvo(int arvo) {
        this.arvo = arvo;
        muutatextia();
    }

    public void setPainettu(int painettu) {
        k.peli(this, painettu);
    }

    

    
}
