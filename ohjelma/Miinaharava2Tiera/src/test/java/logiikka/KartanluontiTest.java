/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logiikka;

import static logiikka.Kartanluonti.Kartanluonti;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tiera
 */
public class KartanluontiTest {

    public KartanluontiTest() {
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
     * Test of getKartta method, of class Kartanluonti.
     */
    @Test
    public void testGetKartta() {
        System.out.println("getKartta");
        Ruutu[][] instance = Kartanluonti(10, 10, 50);
        int s = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (instance[i][j].isOnkoMiinaa()) {
                    s++;
                }

            }
        }
        assertEquals(s, 50);
    }

    public void testGetKartta2() {
        System.out.println("getKartta2");
        int korkeus = 10;
        int leveys = 10;
        Ruutu[][] instance = Kartanluonti(korkeus, leveys, 50);
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (instance[i][j].isOnkoMiinaa()) {
                    for (int k = -1; k < 2; k++) {
                        int rajax = i + k;
                        if (rajax >= 0 && rajax < korkeus) {
                            for (int l = -1; l < 2; l++) {
                                int rajay = j + l;
                                if (rajay >= 0 && rajay < leveys) {
                                    if (!instance[rajax][rajay].isOnkoMiinaa()) {
                                        assertEquals(true, instance[i][j].getMiinojenLukumaaraYmparilla() > 0);
                                    }
                                    
                                }
                            }
                        }

                    }
                    
                }

            }
        }
    }
}
