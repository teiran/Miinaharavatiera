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
public class RuudukkoAvatutuSuljetut {

    private Ruutu[][] kartta;
    private int leveys;
    private int korkeus;
    private boolean onkomiinatavattu;
    /**
     * 
     * @param korkeus kentän korkeus
     * @param leveys kentän leveys
     * @param z alustettu kenttä
     */
    public RuudukkoAvatutuSuljetut(int korkeus, int leveys, Kartanluonti z) {
        kartta = z.getKartta();
        this.korkeus = korkeus;
        this.leveys = leveys;
        onkomiinatavattu = false;
    }
    /**
     * 
     * @param x avattavan ruudun x-koordinaatti
     * @param y avattavan ruudun y-koordinaatti
     */
    public void avaaruutu(int x, int y) {
        Ruutu k = kartta[x][y];
        if (k.onkolippua()) {
            return;
        }
        if (k.isOnkoMiinaa()) {
            onkomiinatavattu = true;
            osuitmiinan();
        } else {
            etosunutmiinaan(x, y);
        }
    }

    private void osuitmiinan() {
        for (int i = 0; i < korkeus; i++) {
            for (int j = 0; j < leveys; j++) {
                if (kartta[i][j].isOnkoMiinaa()) {
                    kartta[i][j].avaa();
                }
            }
        }
    }

    public void lippu(int x, int y) {
        kartta[x][y].asetalippu();
    }

    private void etosunutmiinaan(int x, int y) { // alempi(rekursiivinen osa ei toimi vielä)
        kartta[x][y].avaa();
        if (kartta[x][y].getMiinojenLukumaaraYmparilla() == 0) {
            avaatyhjaalue(x, y);
        }

    }

    private void avaatyhjaalue(int x, int y) {
        for (int rajax = Math.max(x - 1, 0); rajax < Math.min(x + 2, leveys); rajax++) {
            for (int rajay = Math.max(y - 1, 0); rajay < Math.min(y + 2, korkeus); rajay++) {
                if (kartta[rajax][rajay].getMiinojenLukumaaraYmparilla() == 0 && !kartta[rajax][rajay].isOnkoAuki() && !kartta[rajax][rajay].onkolippua()) {
                    kartta[rajax][rajay].avaa();
                    etosunutmiinaan(rajax, rajay);
                } else {
                    kartta[rajax][rajay].avaa();
                }
            }

        }
    }

    public Ruutu[][] kartta() {
        return kartta;
    }

    public boolean isOnkomiinatavattu() {
        return onkomiinatavattu;
    }

}
