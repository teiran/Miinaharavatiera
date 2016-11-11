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

    public Ruutu() {
        onkoMiinaa = false;
        miinojenLukumaaraYmparilla= 0;
        onkoAuki = false;
    }
    
    public void asetamiina(){
        onkoMiinaa = true;
    }
    
    public void laskemiinat(int miinat){
        miinojenLukumaaraYmparilla = miinat; 
    }
    
    public void avaa(){
        onkoAuki = true;
        
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
