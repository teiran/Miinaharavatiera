/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logiikka;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static logiikka.Kartanluonti.kartanluonti;

/**
 *
 * @author tiera
 */
public class logiikankayttoliitymaTest {
    
    public logiikankayttoliitymaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of avaaruutu method, of class RuudukkoAvatutuSuljetut.
     */
    @Test
    public void testAvaaruutu() {
        System.out.println("avaaruutu1lippu");
        int x = 0;
        int y = 0;
        Ruutu[][] k = kartanluonti(10, 10, 0);
        PelinLogiikka instance = new PelinLogiikka(10, 10, k);
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                instance.muutaRuutua(i, j, 3);
            }
        }
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                instance.muutaRuutua(i, j, 1);
            }
        }
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                assertEquals(false, instance.kartta()[i][j].isOnkoAuki());
                assertEquals(true, instance.kartta()[i][j].onkoLippua());
            }
        }
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                instance.muutaRuutua(i, j, 3);
                instance.muutaRuutua(i, j, 1);
            }
        }
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                assertEquals(true, instance.kartta()[i][j].isOnkoAuki());
                assertEquals(false, instance.kartta()[i][j].onkoLippua());
            }
        }
    }

    /**
     * Test of lippu method, of class RuudukkoAvatutuSuljetut.
     */
    @Test
    public void testLippu() {
        System.out.println("avaaruutuMiina");
        Ruutu[][] k = kartanluonti(10, 10, 100);
        PelinLogiikka instance = new PelinLogiikka(10, 10, k);
        assertEquals(false, instance.kartta()[0][0].isOnkoAuki());
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                assertEquals(true, instance.kartta()[i][j].isOnkoMiinaa());
                assertEquals(false, instance.kartta()[i][j].isOnkoAuki());
            }
        }
        instance.muutaRuutua(0, 0, 1);
        assertEquals(true, instance.kartta()[0][0].isOnkoAuki());
        assertEquals(true, instance.kartta()[0][1].isOnkoAuki());
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                assertEquals(true, instance.kartta()[i][j].isOnkoMiinaa());
                assertEquals(true, instance.kartta()[i][j].isOnkoAuki());
            }
        }
    }

    /**
     * Test of kartta method, of class RuudukkoAvatutuSuljetut.
     */
    @Test
    public void testKartta() {
        System.out.println("Tyhjaalue");
        Ruutu[][] k = kartanluonti(10, 10, 0);
        PelinLogiikka instance = new PelinLogiikka(10, 10, k);
        instance.muutaRuutua(0, 0, 1);
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                assertEquals(true, instance.kartta()[i][j].isOnkoAuki());
            }
        }
    }

    /**
     * Test of isOnkomiinatavattu method, of class RuudukkoAvatutuSuljetut.
     */
    @Test
    public void testIsOnkomiinatavattu() {
        System.out.println("Oikeat numerot");
        Ruutu[][] k = kartanluonti(10, 10, 50);
        PelinLogiikka instance = new PelinLogiikka(10, 10, k);
        int summ = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (!instance.kartta()[i][j].isOnkoMiinaa()) {
                    instance.muutaRuutua(i, j, 1);
                } else {
                    summ++;
                }
            }
        }
        assertEquals(50, summ);
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                assertEquals(true, (-1 < instance.kartta()[i][j].getMiinojenLukumaaraYmparilla() && instance.kartta()[i][j].getMiinojenLukumaaraYmparilla() < 9));
            }
        }
    }
    
    @Test
    public void testavaaRuudutJoissaEiLippua(){
        System.out.println("testaa 2 syöteet");
        Ruutu [][] k = kartanluonti(10, 10, 39);
        k[0][1].asetaMiina();
        k[1][1].asetaMiina();
        PelinLogiikka instance = new PelinLogiikka(10, 10, k);
        instance.muutaRuutua(0, 1, 3);
        instance.muutaRuutua(1, 1, 3);
        instance.muutaRuutua(1, 0, 3);
        instance.muutaRuutua(0, 0, 2);
        assertEquals(true, instance.kartta()[0][1].onkoLippua());
        k = kartanluonti(10, 10, 50);
        instance = new PelinLogiikka(10, 10, k);
        instance.muutaRuutua(4, 5, 2);
        for (int i = 3; i < 6; i++) {
            for (int j = 4; j < 7; j++) {
                assertEquals(true, k[i][j].isOnkoAuki());
            }
        }
    }
    
    @Test
    public void testaonkoKaikkiRuudutAuki(){
        Ruutu [][] k = kartanluonti(10, 10, 1);
        PelinLogiikka instance = new PelinLogiikka(10, 10, k);
        int x = 0;
        int y = 0;
        int x2 = 0;
        int y2 = 0;
        if (instance.kartta()[x2][y2].isOnkoMiinaa()) {
            x2 = 1;
            y2 = 1;
        }
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (instance.kartta()[i][j].isOnkoMiinaa()) {
                    x = i;
                    y = j;
                }
            }
        }
        assertEquals(false, instance.muutaRuutua(x2, y2, 1));
        assertEquals(true, instance.muutaRuutua(x, y, 3));
        k = kartanluonti(10, 10, 100);
        instance = new PelinLogiikka(10, 10, k);
        assertEquals(false, instance.muutaRuutua(0, 0, 1));
    }
    
}
