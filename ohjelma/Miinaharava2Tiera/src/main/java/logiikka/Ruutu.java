/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logiikka;

/**
 *
 * @author tiera
 */
public class Ruutu {
    private boolean onkoMiinaa;
    private int miinojenLukumaaraYmparilla;
    private boolean onkoAuki;
    private boolean lippu;

    public Ruutu() {
        onkoMiinaa = false;
        miinojenLukumaaraYmparilla= 0;
        onkoAuki = false;
        lippu = false;
    }
    
    public void asetalippu(){
        if (onkoAuki) {
            return;
        }
        if (lippu) {
            lippu = false;
        } else {
            lippu = true;
        }
        
    }
    
    public void asetamiina(){
        onkoMiinaa = true;
    }
    
    public boolean onkolippua(){
        return lippu;
    }
    
    public void laskemiinat(int miinat){
        miinojenLukumaaraYmparilla = miinat; 
    }
    
    public void avaa(){
        if (!lippu) {
            onkoAuki = true;
        }
        
    }
    
    

    public boolean isOnkoMiinaa() {
        return onkoMiinaa;
    }

    public boolean isOnkoAuki() {
        return onkoAuki;
    }

    public int getMiinojenLukumaaraYmparilla() {
        return miinojenLukumaaraYmparilla;
    }
    
    
    
    
    
}
