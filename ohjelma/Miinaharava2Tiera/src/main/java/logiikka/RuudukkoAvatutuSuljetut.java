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
    private int miinojenmaara;

    public RuudukkoAvatutuSuljetut(int korkeus, int leveys, int miinojenmaara) {
        Kartanluonti k = new Kartanluonti(korkeus, leveys, miinojenmaara);
        kartta = k.getKartta();
        this.korkeus = korkeus;
        this.leveys = leveys;
        this.miinojenmaara = miinojenmaara;
    }

    public void avaaruutu(int x, int y) {
        Ruutu k = kartta[x][y];
        if (k.isOnkoMiinaa()) {
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

    private void etosunutmiinaan(int x, int y) { // alempi(rekursiivinen osa ei toimi vielä)
        kartta[x][y].avaa();
        for (int k = -1; k < 2; k++) {
            int rajax = x + k;
            if (rajax >= 0 && rajax < korkeus) {
                for (int l = -1; l < 2; l++) {
                    int rajay = y + l;
                    if (rajay >= 0 && rajay < leveys) {
                        if (!kartta[rajax][rajay].isOnkoMiinaa() && kartta[rajax][rajay].getMiinojenLukumaaraYmparilla() == 0) {
                            etosunutmiinaan(rajax, rajay);
                            avaavierusruudut(rajax, rajay);
                        }
                    }
                }
            }
        }
    }

    private void avaavierusruudut(int x, int y) {
        for (int k = -1; k < 2; k++) {
            int rajax = x + k;
            if (rajax >= 0 && rajax < korkeus) {
                for (int l = -1; l < 2; l++) {
                    int rajay = y + l;
                    if (rajay >= 0 && rajay < leveys) {
                        kartta[rajax][rajay].avaa();
                    }
                }
            }
        }
    }

    public int[][] kartta() {
        int[][] t = new int[korkeus][leveys];
        for (int i = 0; i < korkeus; i++) {
            for (int j = 0; j < leveys; j++) {
                if (kartta[i][j].isOnkoAuki()) {
                    if (kartta[i][j].isOnkoMiinaa()) {
                        t[i][j] = -2;
                    } else {
                        t[i][j] = kartta[i][j].getMiinojenLukumaaraYmparilla();
                    }
                } else {
                    t[i][j] = -1;
                }
            }
        }
        return t;
    }

    @Override
    public String toString() {
        int[][] g = kartta();
        String gs = "";
        for (int[] is : g) {
            for (int i : is) {
                if (i >= 0) {
                    gs += " " + i + " ";
                } else if (i == -1) {
                    gs += "   ";
                } else {
                    gs += "" + i + " ";
                }
            }
            gs += "\n";
        }
        return gs; //To change body of generated methods, choose Tools | Templates.
    }
    
    

}
