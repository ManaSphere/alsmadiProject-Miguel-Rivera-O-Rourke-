package com.logicorp.games.Minesweeper.utils;

public enum GameMode {
   BEGINNER(10,9,9),INTERMEDIATE(40,16,16),EXPERT(99,16,30); 
    
   private GameMode(int nbMines,int nbRows,int nbCols){
       this.nbMines=nbMines;
       this.nbRows=nbRows;
       this.nbCols=nbCols;
   }

    public int getNbMines() {
        return nbMines;
    }

    public int getNbRows() {
        return nbRows;
    }

    public int getNbCols() {
        return nbCols;
    }
   
   
   private final int nbMines;
   private final int nbRows;
   private final int nbCols;
}

