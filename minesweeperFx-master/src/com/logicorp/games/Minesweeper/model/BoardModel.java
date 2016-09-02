package com.logicorp.games.Minesweeper.model;

import com.logicorp.games.Minesweeper.utils.GameMode;
import java.util.ArrayList;
import java.util.List;
import javafx.beans.binding.Bindings;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class BoardModel {

    SquareModel[][] board;
    GameMode gameMode;
    IntegerProperty nbMinesLeft     = new SimpleIntegerProperty();
    BooleanProperty endGame         = new SimpleBooleanProperty();
    IntegerProperty secondsElapsed  = new SimpleIntegerProperty();
    IntegerProperty nbCellsUncovred = new SimpleIntegerProperty();
    BooleanProperty success         =new SimpleBooleanProperty(false);

    public BoardModel(GameMode gameMode) {
        this.gameMode=gameMode;
        initiate();
    }

    public final void initiate(){
      board = new SquareModel[gameMode.getNbCols()][gameMode.getNbRows()];
      createSquares();
      seedMines();
      nbMinesLeft.setValue(gameMode.getNbMines());
      nbCellsUncovred.setValue(0);
      secondsElapsed.setValue(0);  
      endGame.setValue(false);     
      success.bind(Bindings.when(Bindings.not(endGame).and(nbCellsUncovred.isEqualTo((gameMode.getNbCols()*gameMode.getNbRows())-gameMode.getNbMines()))).then(true).otherwise(false));      
    }
    
    /*TODO review this alogrithm */
    private void seedMines() {
        int nbMines = gameMode.getNbMines();
        int n = nbMines;
        while (n != 0) {
            int col = (int) (Math.random() * gameMode.getNbCols());
            int line = (int) (Math.random() * gameMode.getNbRows());
            if (!board[col][line].isMined()) {
                board[col][line].setMined(true);
                n--;
            }
        }
    }

    public int getNbRows() {
        return gameMode.getNbRows();
    }

    public int getNbCols() {
        return gameMode.getNbCols();
    }

    public GameMode getGameMode() {
        return gameMode;
    }

    public SquareModel getSquare(int col, int row) {
        return board[col][row];
    }

    private void createSquares() {
        for (int i = 0; i < gameMode.getNbCols(); i++) {
            for (int j = 0; j < gameMode.getNbRows(); j++) {
                board[i][j] = new SquareModel(i, j);
            }
        }
    }

    List<SquareModel> getAdjacentSquare(SquareModel square) {
        int col = square.getCol();
        int row = square.getRow();
        assert col < gameMode.getNbCols() && row < gameMode.getNbRows() : "bounds pb";
        List<SquareModel> result = new ArrayList();
        for (int i = col - 1; i <= col + 1; i++) {
            for (int j = row - 1; j <= row + 1; j++) {
                if ((i >= 0 && j >= 0)
                        && !(i == col && j == row)
                        && (i < gameMode.getNbCols() && j < gameMode.getNbRows())
                        && !board[i][j].isMined()
                        && !board[i][j].isVisited()) {
                    result.add(board[i][j]);
                    board[i][j].setVisited(true);
                }
            }
        }
        return result;
    }

    int getNbMinesAround(SquareModel square) {
        int col = square.getCol();
        int row = square.getRow();
        assert col < gameMode.getNbCols() && row < gameMode.getNbRows() : "IndexOutOfBounds";
        int result = 0;
        for (int i = col - 1; i <= col + 1; i++) {
            for (int j = row - 1; j <= row + 1; j++) {
                if ((i >= 0 && j >= 0)
                        && !(i == col && j == row)
                        && (i < gameMode.getNbCols() && j < gameMode.getNbRows())
                        && (board[i][j].isMined())) {
                    result++;
                }
            }
        }
        return result;
    }

    public void uncoverAdjacentSquares(SquareModel square,boolean all) {
        uncoverSquare(square);
        if ( getNbMinesAround(square) == 0  || all) {
            getAdjacentSquare(square).stream().forEach((s) -> {
               uncoverAdjacentSquares(s,all);
            });
        }
    }

    private void uncoverSquare(SquareModel square) {
        if (square.isCovered() && !square.isMined()) {
            nbCellsUncovred.setValue(nbCellsUncovred.getValue()+1);
            square.setCovered(false);
            square.setnbNeighbours(getNbMinesAround(square));
        }
    }

    public IntegerProperty getNbMinesLeft() {
        return nbMinesLeft;
    }

    public void setNbMinesLeft(IntegerProperty nbMinesLeft) {
        this.nbMinesLeft = nbMinesLeft;
    }
    
      public void setNbMinesLeft(int nbMinesLeft) {
        this.nbMinesLeft.setValue(nbMinesLeft);
    }

    public BooleanProperty getEndGame() {
        return endGame;
    }

    public void setEndGame(BooleanProperty endGame) {
        this.endGame = endGame;
    }

    public void setEndGame(boolean endGame) {
        this.endGame.setValue(endGame);
    }
    
    public IntegerProperty getSecondsElapsed() {
        return secondsElapsed;
    }

    public void setSecondsElapsed(IntegerProperty secondsElapsed) {
        this.secondsElapsed = secondsElapsed;
    }
    
     public void incSecondsElapsed() {
        secondsElapsed.setValue(secondsElapsed.getValue()+1);
    }

    public BooleanProperty getSuccess() {
        return success;
    }

    public void setSuccess(BooleanProperty success) {
        this.success = success;
    }
     
     
    
}
