package com.logicorp.games.Minesweeper.ui;
import com.logicorp.games.Minesweeper.model.BoardModel;
import javafx.scene.layout.GridPane;


public class Board extends GridPane{
   BoardModel model;

    public Board(BoardModel model) {
       this.model=model;
       layOutTheTiles();                 
    }
   
    private void layOutTheTiles() {
        for (int i = 0; i < model.getNbCols(); i++) {
            for (int j = 0; j < model.getNbRows(); j++) {
              add(new Square(model.getSquare(i, j),model )
                  ,i,j);
            }
        }
      
    }
       
}
