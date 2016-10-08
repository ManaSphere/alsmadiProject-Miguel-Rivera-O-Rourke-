/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
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
public class Test3 {
    
     BooleanProperty covered   = new SimpleBooleanProperty(true);
  BooleanProperty mined     = new SimpleBooleanProperty(false);
  IntegerProperty neighbour = new SimpleIntegerProperty(0);
  BooleanProperty selected  = new SimpleBooleanProperty(false);
  boolean visited =false;
    
    public Test3() {
        
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
        BooleanProperty test1 = getCovered();
        assertEquals(test1, covered);
    }
    
    @Test
    public void test2(){
         BooleanProperty test1 = getSelected();
        assertEquals(test1, selected);
        
    }
    
    @Test
    public void test3(){
         BooleanProperty test1 = getMined();
         assertEquals(test1, mined);
        
    }
    
    @Test
    public void test4(){
         BooleanProperty test1 = getMined();
         assertEquals(test1, mined);
        
    }
    
    @Test
    public void test5(){
         boolean test1 = isVisited();
         assertEquals(test1, visited);
        
    }
    
    
    
    private BooleanProperty getCovered() {
        return covered;
    }
    public BooleanProperty getSelected() {
        return selected;
    }
    public BooleanProperty getMined() {
        return mined;
    }
    
    public boolean isVisited() {
        return visited;
    }
    
    
}
