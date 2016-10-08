/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javafx.scene.effect.Light;
import javafx.scene.effect.Lighting;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Miguel
 */
public class Test2 {
    
    static final Lighting lighting = new Lighting();
    static final Lighting bright = new Lighting();

    static {
        Light.Distant light = new Light.Distant();
        light.setAzimuth(-135);
        light.setElevation(30);
        lighting.setLight(light);
        bright.setLight(light);
    }
    
    public Test2() {
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

   @Test
   public void test1(){
       assertNotNull(lighting);
   }
   
   @Test
   public void test2(){
       assertNotEquals(lighting, bright);
   }
}
