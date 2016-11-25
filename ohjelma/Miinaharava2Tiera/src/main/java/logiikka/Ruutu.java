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
        miinojenLukumaaraYmparilla = 0;
        onkoAuki = false;
        lippu = false;
    }
    /**
     * Asettaa Lipun ruutuun jos sitä ei ole sillä tai ottaa sen pois jos se on sillä
     * Tarkistaa on ruutu auki, eli pystyykö laittamaan lippua
     */
    public void asetalippu() {
        if (onkoAuki) {
            return;
        }
        if (lippu) {
            lippu = false;
        } else {
            lippu = true;
        }

    }
    /**
     * Asettaa miinan ruutuun, kettää alustaessa.
     */
    public void asetamiina() {
        onkoMiinaa = true;
    }
    
    /**
     * 
     * @return palauttaa onko ruudussa lippua 
     */

    public boolean onkolippua() {
        return lippu;
    }
    /**
     * 
     * @param miinat syöttää miinojen määrän ruutuun (kenttää alustaessa) 
     */
    public void laskemiinat(int miinat) {
        miinojenLukumaaraYmparilla = miinat;
    }
    /**
     * avaa ruudun jos ruudussa ei ole lippua
     */
    public void avaa() {
        if (!lippu) {
            onkoAuki = true;
        } else if (onkoMiinaa) {
            onkoAuki = true;
        }

    }
    /**
     * 
     * @return palauttaa onko ruudussa lippua 
     */
    public boolean isOnkoMiinaa() {
        return onkoMiinaa;
    }
    /**
     * 
     * @return palauttaa onko ruutu auki
     */
    public boolean isOnkoAuki() {
        return onkoAuki;
    }
    /**
     * 
     * @return palautaa miinojenmäärän vieruisruuduissa 
     */
    public int getMiinojenLukumaaraYmparilla() {
        return miinojenLukumaaraYmparilla;
    }
    /**
     * 
     * @return Syötää grafiikalle oikeassa muodossa ruutujen arvot 
     */
    @Override
    public String toString() {
        if (onkoAuki) {
            if (onkoMiinaa) {
                return "M";
            } else if (miinojenLukumaaraYmparilla == 0) {
                return " ";
            } else {
                return "" + miinojenLukumaaraYmparilla + "";
            }
        } else if (lippu) {
            return "L";
        } else {
            return " ";
        } 
    }

}
