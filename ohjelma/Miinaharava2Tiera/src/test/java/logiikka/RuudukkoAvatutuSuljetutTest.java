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
        System.out.println("avaaruutu");
        int x = 0;
        int y = 0;
        RuudukkoAvatutuSuljetut instance = new RuudukkoAvatutuSuljetut(10, 10, 10);
        instance.avaaruutu(x, y);
        int summ = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                int t = instance.kartta()[i][j];
                if (t == -2 || t > -1) {
                    summ++;
                }
                assertEquals(true, (t > -4 && t < 9));
            }
        }

    }

    /**
     * Test of lippu method, of class RuudukkoAvatutuSuljetut.
     */
    @Test
    public void testLippu() {
        System.out.println("lippu");
        
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                RuudukkoAvatutuSuljetut instance = new RuudukkoAvatutuSuljetut(10, 10, 10);
                instance.lippu(x, y);
                assertEquals(-3, instance.kartta()[x][y]);
                instance.avaaruutu(x, y);
                assertEquals(-3, instance.kartta()[x][y]);
                instance.poistaLippu(x, y);
                assertEquals(-1, instance.kartta()[x][y]);
                instance.avaaruutu(x, y);
                assertEquals(true, (instance.kartta()[x][y] > -3) && instance.kartta()[x][y] != -1);
            }
        }

    }

}
