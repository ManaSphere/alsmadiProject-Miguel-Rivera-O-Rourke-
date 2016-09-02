package com.logicorp.games.Minesweeper.ui;

import com.logicorp.games.Minesweeper.utils.Configuration;
import com.logicorp.games.Minesweeper.model.BoardModel;
import com.logicorp.games.Minesweeper.model.SquareModel;
import javafx.beans.binding.Bindings;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.effect.Light;
import javafx.scene.effect.Lighting;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

public class Square extends Label {

    SquareModel model;
    BoardModel board;

    static final Lighting lighting = new Lighting();

    static {
        Light.Distant light = new Light.Distant();
        light.setAzimuth(-135);
        light.setElevation(30);
        lighting.setLight(light);
    }

    public Square(SquareModel model, BoardModel board) {
        this.model = model;
        this.board = board;
        init();
    }

    private void init() {
        setMinSize(Configuration.getTileWidth(), Configuration.getTileHeight());
        setAlignment(Pos.BASELINE_CENTER);
        styleProperty().bind(Bindings.when(model.getSelected()).then(Configuration.getMinedStyle()).otherwise(Configuration.getBackgroundStyle()));
        effectProperty().bind(Bindings.when(model.getCovered()).then(lighting).otherwise((Lighting) null));


        textProperty().bind(Bindings.when(model.getCovered().not().and(model.getNeighbour().isEqualTo(0)).or(model.getCovered())).then("")
                                    .otherwise(model.getNeighbour().asString()));
        
        setOnMouseClicked((MouseEvent e) -> {

            if (e.getButton() == MouseButton.PRIMARY && ! model.isSelected()  && model.isCovered()) {
                
                if (model.isMined()) {
                    board.setEndGame(true);
                    board.uncoverAdjacentSquares(model,true);
                }else{                
                    board.uncoverAdjacentSquares(model,false);
                }
                
            } else if (e.getButton() == MouseButton.SECONDARY && model.isCovered()) {
                
                model.setSelected(!model.getSelected().getValue());
                
                if (model.isSelected() && board.getNbMinesLeft().getValue()!=0) {
                    board.setNbMinesLeft(board.getNbMinesLeft().getValue()-1);
                }else if (!model.isSelected() && board.getNbMinesLeft().getValue()<board.getGameMode().getNbMines()) {
                    board.setNbMinesLeft(board.getNbMinesLeft().getValue()+1);
                } 
                
            }
            
        });
    }
}
