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
public class RuutuTest {
    
    public RuutuTest() {
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
     * Test of asetamiina method, of class Ruutu.
     */
    @Test
    public void testAsetamiina() {
        System.out.println("asetamiina");
        Ruutu instance = new Ruutu();
        instance.asetamiina();
        assertEquals(true, instance.isOnkoMiinaa());
    }

    /**
     * Test of laskemiinat method, of class Ruutu.
     */
    @Test
    public void testLaskemiinat() {
        System.out.println("laskemiinat");
        int miinat = 6;
        Ruutu instance = new Ruutu();
        instance.annamiinojenmaara(miinat);
        assertEquals(6, instance.getMiinojenLukumaaraYmparilla());
    }

    /**
     * Test of avaa method, of class Ruutu.
     */
    @Test
    public void testAvaa() {
        System.out.println("avaa");
        Ruutu instance = new Ruutu();
        instance.avaaRuutu();
        assertEquals(instance.isOnkoAuki(), true);
    }
    
    @Test
    public void testLippu(){
        System.out.println("lippu");
        Ruutu instance = new Ruutu();
        instance.asetaTaiPoistaLippu();
        assertEquals(instance.onkolippua(), true);
        instance.avaaRuutu();
        assertEquals(instance.isOnkoAuki(), false);
        instance.asetaTaiPoistaLippu();
        assertEquals(instance.onkolippua(), false);
        instance.avaaRuutu();
        assertEquals(instance.isOnkoAuki(), true);
    }
    
    @Test
    public void testtoString(){
        System.out.println("toString");
        Ruutu k = new Ruutu();
        assertEquals(k.toString(), " ");
        k.asetaTaiPoistaLippu();
        assertEquals(k.toString(), "L");
        k.annamiinojenmaara(3);
        k.asetaTaiPoistaLippu();
        assertEquals(k.toString(), " ");
        k.avaaRuutu();
        assertEquals(Integer.parseInt(k.toString()), 3);
        k = new Ruutu();
        k.annamiinojenmaara(0);
        k.avaaRuutu();
        assertEquals(k.toString(), " ");
        k = new Ruutu();
        k.asetamiina();
        k.avaaRuutu();
        assertEquals(k.toString(), "M");
        
        
    }


}
