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
    private String arvo;
    private final Kayttoliityma k;
    private final int x;
    private final int y;
    /**
     * 
     * @param arvo graafisen ruudun ulos päin näyttämä arvo
     * @param k1 linkki käyttöliitymään
     * @param x ruudun x-koordinaati kentällä
     * @param y ruudun y-koordinaati kentällä
     */
    public RuutuButton(String arvo, Kayttoliityma k1, int x, int y) {
        this.x = x;
        this.y = y;
        this.arvo = arvo;
        muutatextia();
        k = k1;
    }
    
    private void muutatextia(){
        this.setText(arvo);
    }
    /**
     * 
     * @param arvo muuttaa ulospäin näkyvää arvoa 
     */
    public void setArvo(String arvo) {
        this.arvo = arvo;
        muutatextia();
    }
    /**
     * 
     * @param painettu hiirtä päinettua kutsuu peliloopia
     */
    public void setPainettu(int painettu) {
        k.peli(this, painettu);
    }
    /**
     * 
     * @return palauttaa x-koordinaatin 
     */
    public int x(){
        return x;
    }
    /**
     * 
     * @return palauttaa y-koordinaatin 
     */
    public int y(){
        return y;
    }
    

    

    
}
