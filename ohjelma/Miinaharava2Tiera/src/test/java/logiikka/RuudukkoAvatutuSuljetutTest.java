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

/**
 *
 * @author tiera
 */
public class RuudukkoAvatutuSuljetutTest {
    
    public RuudukkoAvatutuSuljetutTest() {
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
        Kartanluonti k = new Kartanluonti(10, 10, 0);
        RuudukkoAvatutuSuljetut instance = new RuudukkoAvatutuSuljetut(10, 10, k);
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                instance.lippu(i, j);
            }
        }
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                instance.avaaruutu(i, j);
            }
        }
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                assertEquals(false, instance.kartta()[i][j].isOnkoAuki());
                assertEquals(true, instance.kartta()[i][j].onkolippua());
            }
        }
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                instance.lippu(i, j);
                instance.avaaruutu(i, j);
            }
        }
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                assertEquals(true, instance.kartta()[i][j].isOnkoAuki());
                assertEquals(false, instance.kartta()[i][j].onkolippua());
            }
        }
    }

    /**
     * Test of lippu method, of class RuudukkoAvatutuSuljetut.
     */
    @Test
    public void testLippu() {
        System.out.println("avaaruutuMiina");
        int x = 0;
        int y = 0;
        Kartanluonti k = new Kartanluonti(10, 10, 100);
        RuudukkoAvatutuSuljetut instance = new RuudukkoAvatutuSuljetut(10, 10, k);
        assertEquals(false, instance.isOnkomiinatavattu());
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                assertEquals(true, instance.kartta()[i][j].isOnkoMiinaa());
                assertEquals(false, instance.kartta()[i][j].isOnkoAuki());
            }
        }
        instance.avaaruutu(0, 0);
        assertEquals(true, instance.isOnkomiinatavattu());
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
        Kartanluonti k = new Kartanluonti(10, 10, 0);
        RuudukkoAvatutuSuljetut instance = new RuudukkoAvatutuSuljetut(10, 10, k);
        instance.avaaruutu(0, 0);
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
        Kartanluonti k = new Kartanluonti(10, 10, 50);
        RuudukkoAvatutuSuljetut instance = new RuudukkoAvatutuSuljetut(10, 10, k);
        int summ = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (!instance.kartta()[i][j].isOnkoMiinaa()) {
                    instance.avaaruutu(i, j);
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
    
}
