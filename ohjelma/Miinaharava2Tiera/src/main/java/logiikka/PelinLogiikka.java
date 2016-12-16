/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logiikka;

/**
 * Logiikan käyttöliitymä joka saa sisäänsä ruudukon jossa kaikki ruudut ovat
 * kiinni Ruudukko sisältää kaikki ruudut ja päivittää näiden aukioloa ja
 * lippuja.
 *
 * @author tiera
 */
public class PelinLogiikka {

    private Ruutu[][] kartta;
    private int leveys;
    private int korkeus;
    private boolean onkoMiinatAvattu;

    /**
     * Konstruktori logiikka päivittävälle luokalle. 
     * 
     * @param korkeus kentän korkeus
     * @param leveys kentän leveys
     * @param z alustettu kenttä
     */
    public PelinLogiikka(int korkeus, int leveys, Ruutu[][] z) {
        kartta = z;
        this.korkeus = korkeus;
        this.leveys = leveys;
        onkoMiinatAvattu = false;
    }
    
    /**
     * metodi jota käyttöliitymä kutsuu muutaessan ruudun arvoa (pyyntö tullut grafiikan ruuduilta).
     * 
     * @param x logiikan ja grafiikan taulukon korkeus suuntainen koordinaatti
     * @param y logiikan ja grafiikan taulukon leveys suuntainen koordinaatti
     * @param oikeaVaiVasen numerosille että mitä nappulaa on painettu
     * @return palauttaa arvon voidaanko enää pelata tätä peliä vai ei
     */
    public boolean muutaRuutua(int x, int y, int oikeaVaiVasen) {
        if (onkoMiinatAvattu) {
            return false;
        }
        if (oikeaVaiVasen == 1) {
            this.avaaRuutu(x, y);
        } else if (oikeaVaiVasen == 2) {
            this.avaaLaimmaisetRuudutJosEiLippua(x, y);
        } else if (oikeaVaiVasen == 3) {
            this.asetaLippuTaiPoistaLippu(x, y);
        }
        return onkoKaikkiRuudutAukiTaiLippu();
    }
    
    /**
     * Hiirenkeskipainiketta painettaessa avaa lähimmät ruudut joissa ei lippua (nopeutta pelaamista).
     * 
     * @param x logiikan ja grafiikan taulukon korkeus suuntainen koordinaatti
     * @param y logiikan ja grafiikan taulukon leveys suuntainen koordinaatti
     */
    private void avaaLaimmaisetRuudutJosEiLippua(int x, int y) {
        for (int rajax = Math.max(x - 1, 0); rajax < Math.min(x + 2, korkeus); rajax++) {
            for (int rajay = Math.max(y - 1, 0); rajay < Math.min(y + 2, leveys); rajay++) {
                avaaRuutu(rajax, rajay);
            }
        }
    }

    /**
     * Avaaruudun jossa ei ole lippua eli vaihtoehtoisesti avaa miinan tai tyhjän ruudun.
     * 
     * @param x logiikan ja grafiikan taulukon korkeus suuntainen koordinaatti
     * @param y v
     */
    private void avaaRuutu(int x, int y) {
        Ruutu k = kartta[x][y];
        if (k.onkoLippua()) {
            return;
        }
        if (k.isOnkoMiinaa()) {
            onkoMiinatAvattu = true;
            avaaMiinat();
        } else {
            avaaTyhjaRuutuTaiRuutuJossaEiMinaa(x, y);
        }
    }
    
    /**
     * Tutkii onko kaikki ruudut avattu tai onko peli pelattu loppuun tai onko osuttu miinaan.
     * 
     * @return jos peli on voitettu palautta true, muuten false
     */

    private boolean onkoKaikkiRuudutAukiTaiLippu() {
        if (onkoMiinatAvattu) {
            return false;
        }
        for (Ruutu[] ruutus : kartta) {
            for (Ruutu ruutu : ruutus) {
                if (ruutu.onkoLippua()) {
                    if (!ruutu.isOnkoMiinaa()) {
                        return false;
                    }
                } else if (!ruutu.isOnkoAuki()) {
                    return false;
                }

            }
        }
        return true;
    }

    
    /**
     * Kun osutaan miinaa avataan kaikki miinat, tämä metodi hoitaa sen.
     * 
     */
    private void avaaMiinat() {
        for (int i = 0; i < korkeus; i++) {
            for (int j = 0; j < leveys; j++) {
                if (kartta[i][j].isOnkoMiinaa()) {
                    kartta[i][j].avaaRuutu();
                }
            }
        }
    }

    /**
     * asettaa tai poistaa lipun ruutuun.
     * 
     * @param x logiikan ja grafiikan taulukon korkeus suuntainen koordinaatti
     * @param y logiikan ja grafiikan taulukon leveys suuntainen koordinaatti
     */
    private void asetaLippuTaiPoistaLippu(int x, int y) {
        kartta[x][y].asetaTaiPoistaLippu();
    }
    
    /**
     * avaa ruudun jossa ei miinaa, myös jos on ruutu jonka vieressä ei ole miinaa tämä avaa ruudun ja kaikki sen vieruis ruudut sääntöjen mukaan (rekursiivisesti).
     * 
     * @param x logiikan ja grafiikan taulukon korkeus suuntainen koordinaatti
     * @param y logiikan ja grafiikan taulukon leveys suuntainen koordinaatti
     */
    private void avaaTyhjaRuutuTaiRuutuJossaEiMinaa(int x, int y) { // alempi(rekursiivinen osa ei toimi vielä)
        kartta[x][y].avaaRuutu();
        if (kartta[x][y].getMiinojenLukumaaraYmparilla() == 0) {
            avaaTyhjaAlue(x, y);
        }

    }
    
    /**
     * jos on ruutu jonka vieressä ei ole miinaa tämä avaa ruudun ja kaikki sen vieruis ruudut sääntöjen mukaan (rekursiivisesti).
     * 
     * @param x logiikan ja grafiikan taulukon korkeus suuntainen koordinaatti
     * @param y logiikan ja grafiikan taulukon leveys suuntainen koordinaatti
     */
    
    private void avaaTyhjaAlue(int x, int y) {
        for (int rajax = Math.max(x - 1, 0); rajax < Math.min(x + 2, korkeus); rajax++) {
            for (int rajay = Math.max(y - 1, 0); rajay < Math.min(y + 2, leveys); rajay++) {
                if (kartta[rajax][rajay].getMiinojenLukumaaraYmparilla() == 0 && !kartta[rajax][rajay].isOnkoAuki() && !kartta[rajax][rajay].onkoLippua()) {
                    kartta[rajax][rajay].avaaRuutu();
                    avaaTyhjaRuutuTaiRuutuJossaEiMinaa(rajax, rajay);
                } else {
                    kartta[rajax][rajay].avaaRuutu();
                }
            }

        }
    }
    
/**
 * palauttaa Ruutu kartan Kättöliitymälle.
 * 
 * @return Ruutu[][] 
 */
    public Ruutu[][] kartta() {
        return kartta;
    }

}
