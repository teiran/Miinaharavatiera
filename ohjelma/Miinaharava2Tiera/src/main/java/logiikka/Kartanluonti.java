/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logiikka;

import logiikka.Ruutu;

/**
 *
 * @author tiera
 */
public class Kartanluonti {

    private int korkeus;
    private int leveys;
    private int miinojenMaara;
    private Ruutu[][] kartta;

    public Kartanluonti(int korkeus, int leveys, int miinojenMaara) {
        this.korkeus = korkeus;
        this.leveys = leveys;
        this.miinojenMaara = miinojenMaara;
        kartta = new Ruutu[korkeus][leveys];
        luokartta();
        arvomiinat();
        laskemiinat();

    }

    public Ruutu[][] getKartta() {
        return kartta;
    }
    
    

    private void luokartta() {
        for (int i = 0; i < korkeus; i++) {
            for (int j = 0; j < leveys; j++) {
                kartta[i][j] = new Ruutu();
            }
        }
    }

    private void arvomiinat() {
        int x = (int) (korkeus * Math.random());
        int y = (int) (leveys * Math.random());
        boolean t = (0 != miinojenMaara);
        while (t) {
            if (!kartta[x][y].isOnkoMiinaa()) {
                kartta[x][y].asetamiina();
                miinojenMaara--;
            }
            x = (int) (korkeus * Math.random());
            y = (int) (leveys * Math.random());
            t = (0 != miinojenMaara);
        }
    }

    private void laskemiinat() {
        for (int i = 0; i < korkeus; i++) {
            for (int j = 0; j < leveys; j++) {
                if (!kartta[i][j].isOnkoMiinaa()) {
                    int summa = 0;
                    for (int k = -1; k < 2; k++) {
                        int rajax =i+k;
                        if (rajax >= 0 && rajax < korkeus) {
                            for (int l = -1; l < 2; l++) {
                                int rajay = j+l;
                                if (rajay >= 0 && rajay < leveys) {
                                    if (kartta[rajax][rajay].isOnkoMiinaa()) {
                                        summa++;
                                    }
                                }
                            }
                        }

                    }
                    kartta[i][j].laskemiinat(summa);
                }
            }
        }
    }

    @Override
    public String toString() {
        String g = "";
        for (Ruutu[] ruutus : kartta) {
            for (Ruutu ruutu : ruutus) {
                if (ruutu.isOnkoMiinaa()) {
                    g += "" + -1 + " ";
                } else {
                    g += "" + ruutu.getMiinojenLukumaaraYmparilla() + "  ";
                }
            }
            g += "\n";
        }
        return g;
    }

}
