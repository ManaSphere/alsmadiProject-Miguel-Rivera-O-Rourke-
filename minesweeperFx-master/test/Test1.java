/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.logicorp.games.Minesweeper.Main;
import com.logicorp.games.Minesweeper.utils.Configuration;
import static com.logicorp.games.Minesweeper.utils.Configuration.setting;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class Test1 {
    
    public static final Properties setting = new Properties();

    static {
        try {
            setting.load(Main.class.getResourceAsStream("resources/config.properties"));
        } catch (IOException ex) {
            Logger.getLogger(Configuration.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Test1() {
        
        
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
        String test2 = setting.getProperty("TILE_WIDTH");
        assertNotNull(test2);
    }
    @Test
    public void test2(){
        String test2 = setting.getProperty("TILE_HEIGHT");
        assertNotNull(test2);
    }
    @Test
    public void test3(){
        String test2 = setting.getProperty("SQUARE_BACKGROUD_COLOR");
        assertNotNull(test2);
    }
    @Test
    public void test4(){
        String test2 = setting.getProperty("MINED_BACKGROUD_COLOR");
        assertNotNull(test2);
    }
    @Test
    public void test5(){
        String test1 = setting.getProperty("TILE_WIDTH");
        String test2 = "20";
        assertEquals(test1, test2);
    }
    
    @Test
    public void test6(){
        String test1 = setting.getProperty("TILE_HEIGHT");
        String test2 = "20";
        assertEquals(test1, test2);
    }
    
    @Test
    public void test7(){
        String test1 = setting.getProperty("SQUARE_BACKGROUD_COLOR");
        String test2 = "-fx-background-color: lightGray";
        assertEquals(test1, test2);
    }
    
    @Test
    public void test8(){
        String test1 = setting.getProperty("MINED_BACKGROUD_COLOR");
        String test2 = "-fx-background-color: red";
        assertEquals(test1, test2);
    }
    
    
}


