/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafiikka;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import org.w3c.dom.events.MouseEvent;

/**
 *
 * @author tiera
 */
public class Ruudunkuuntelija implements MouseListener {
    
    private RuutuButton k;

    public Ruudunkuuntelija(RuutuButton k) {
        this.k = k;
    }


 

  

    @Override
    public void mouseClicked(java.awt.event.MouseEvent e) {
        if (e.getButton() == 1) {
            k.setPainettu(1);
        } else if (e.getButton() == 2) {
            k.setPainettu(2);
        }
        
    }

    @Override
    public void mousePressed(java.awt.event.MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(java.awt.event.MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(java.awt.event.MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(java.awt.event.MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
