package grafiikka;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * ei vilä toimi täysin mutta tällä pystyy aloittamaan miinaharavan alusta, 
 * "tällä nappulalla"s
 *
 * @author tiera
 */
public class UusintaNappula extends JButton implements MouseListener {
    private final ValikkoPaneli ka;
    
    /**
     * uudenpelin alottavan nappulan konstruktori.
     * 
     * @param ka linkki valikko palenliin
     */
    public UusintaNappula(ValikkoPaneli ka) {
        this.ka = ka;
        this.setText("uusipeli");
        this.addMouseListener(this);
    }
    
    
    /**
     * kun nappulaa klikataan tämä kuuntelee ja luo uudenpelin valikon kautta joka konstruktorin.
     * 
     * @param e 
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        ka.uusiPeli();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
       
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
    
}
