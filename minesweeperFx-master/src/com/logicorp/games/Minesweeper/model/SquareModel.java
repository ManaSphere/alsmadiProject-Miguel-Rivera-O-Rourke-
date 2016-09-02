package com.logicorp.games.Minesweeper.model;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;


public class SquareModel {
  BooleanProperty covered   = new SimpleBooleanProperty(true);
  BooleanProperty mined     = new SimpleBooleanProperty(false);
  IntegerProperty neighbour = new SimpleIntegerProperty(0);
  BooleanProperty selected  = new SimpleBooleanProperty(false);
  boolean visited =false;
  
  
  int col;
  int row;
  
    public SquareModel(int col,int row) {
        this.col=col;
        this.row=row;        
    }

    public BooleanProperty getCovered() {
        return covered;
    }

    
    public void setCovered(BooleanProperty covered) {
        this.covered = covered;
    }

    public BooleanProperty getSelected() {
        return selected;
    }

    public void setSelected(BooleanProperty selected) {
        this.selected = selected;
    }

    public boolean isSelected(){
        return selected.getValue();        
    }
    
    public void setSelected(boolean selected){
        this.selected.setValue(selected);
    }
   
    public BooleanProperty getMined() {
        return mined;
    }

    public void setMined(BooleanProperty mined) {
        this.mined = mined;
    }

   public boolean isMined(){
       return mined.getValue()==true;
   }
  
    public boolean isCovered(){
       return covered.getValue()==true;
   }
    
   public void setMined(boolean mined){
       this.mined.set(mined);
   } 
   
   public void setCovered(boolean covered){
       this.covered.set(covered);
   } 

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public IntegerProperty getNeighbour() {
        return neighbour;
    }

 
    public void setnbNeighbours(int neighbour) {
        this.neighbour.setValue(neighbour);
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visted) {
        this.visited = visted;
    }
    
    
}
