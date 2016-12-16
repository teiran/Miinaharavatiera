/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logiikka;

import logiikka.Ruutu;

/**
 * Luo Ruutu[][] kartan jossa on kaikki miinat ja luvut siitä kuinka monta miinaa on 
 * naapurissa
 *
 * @author tiera
 */
public class Kartanluonti {

    private static int korkeus;
    private static int leveys;
    private static int miinojenMaara;
    private static Ruutu[][] kartta;
    /**
     * Konstruktori kartan luonnille, staatinen ja palauttaa uuden logiikan alustetun kartan.
     * 
     * @param korkeus kentän korkeus
     * @param leveys kentän leveys
     * @param miinojenMaara Miinojen määrä
     * @return palauttaa alustetun kartan
     */
    public static Ruutu[][] kartanLuonti(int korkeus, int leveys, int miinojenMaara) {
        Kartanluonti.korkeus = korkeus;
        Kartanluonti.leveys = leveys;
        Kartanluonti.miinojenMaara = miinojenMaara;
        kartta = new Ruutu[korkeus][leveys];
        luoKartta();
        arvoMiinat();
        laskeMiinat();
        return kartta;

    }
    
    /**
     * luo tyhjän kartan.
     * 
     */
    private static void luoKartta() {
        for (int i = 0; i < korkeus; i++) {
            for (int j = 0; j < leveys; j++) {
                kartta[i][j] = new Ruutu();
            }
        }
    }
    
    /**
     * arpoo miinat tyhjään karttaan.
     * 
     */
    private static void arvoMiinat() {
        int x = (int) (korkeus * Math.random());
        int y = (int) (leveys * Math.random());
        boolean t = (0 != miinojenMaara);
        while (t) {
            if (!kartta[x][y].isOnkoMiinaa()) {
                kartta[x][y].asetaMiina();
                miinojenMaara--;
            }
            x = (int) (korkeus * Math.random());
            y = (int) (leveys * Math.random());
            t = (0 != miinojenMaara);
        }
    }
    
    /**
     * laskee naapurimiinojen määrän karttaan jossa on miinat.
     * 
     */
    private static void laskeMiinat() {
        for (int i = 0; i < korkeus; i++) {
            for (int j = 0; j < leveys; j++) {
                if (!kartta[i][j].isOnkoMiinaa()) {
                    laskeMiinat(i, j);
                }
            }
        }
    }
    
    /**
     * laskee yksittäisen ruudun naapureiden miinojen määrän.
     * 
     * @param x logiikan ja grafiikan taulukon korkeus suuntainen koordinaatti
     * @param y logiikan ja grafiikan taulukon leveys suuntainen koordinaatti
     */
    private static void laskeMiinat(int x, int y) {
        int summa = 0;
        for (int rajax = Math.max(x - 1, 0); rajax < Math.min(x + 2, korkeus); rajax++) {
            for (int rajay = Math.max(y - 1, 0); rajay < Math.min(y + 2, leveys); rajay++) {
                if (kartta[rajax][rajay].isOnkoMiinaa()) {
                    summa++;
                }
            }

        }
        kartta[x][y].annaMiinojenMaara(summa);
    }

}
