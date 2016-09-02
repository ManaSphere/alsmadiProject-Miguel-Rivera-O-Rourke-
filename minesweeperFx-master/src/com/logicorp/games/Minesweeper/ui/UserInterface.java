package com.logicorp.games.Minesweeper.ui;

import com.logicorp.games.Minesweeper.utils.Configuration;
import com.logicorp.games.Minesweeper.model.BoardModel;
import com.logicorp.games.Minesweeper.utils.GameMode;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.Observable;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

public class UserInterface {

    BorderPane gameArea = new BorderPane();
    MenuPane menu = new MenuPane();
    TopPane topPane;
    StackPane rootPanel = new StackPane();
    Board board;
    DoubleProperty width = new SimpleDoubleProperty(this, "width", 0);
    DoubleProperty height = new SimpleDoubleProperty(this, "height", 0);

    Timeline ticker ;
    BoardModel bm;
    GameMode gm = GameMode.EXPERT;
    Scene scene;

    public UserInterface() {
        rootPanel.getChildren().addAll(menu);
        scene = new Scene(rootPanel, menu.getWidth(), menu.getHeight());
        scene.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode()==KeyCode.F2) {ticker.stop();constructGameArea();ticker.play();}
            else if (e.getCode()==KeyCode.F3) {ticker.stop(); menu.switchToMenuArea();}
        });
    }

    public final void constructGameArea() {
        ticker = new Timeline();
        
        bm = new BoardModel(gm);
        board = new Board(bm);
        board.disableProperty().bind(Bindings.or(bm.getEndGame(),bm.getSuccess()));
        topPane = new TopPane();
        resizeUserInterface();

        gameArea.setTop(topPane.getContent());

        ticker.getKeyFrames().add(new KeyFrame(Duration.seconds(1), (ActionEvent event) -> {
            bm.incSecondsElapsed();
            topPane.time.setText("time : " + bm.getSecondsElapsed().getValue().toString());
        }));

        ticker.setCycleCount(Timeline.INDEFINITE);
        
        gameArea.setCenter(board);

        bm.getEndGame().addListener((Observable value) -> {
            if (bm.getEndGame().get()) {
                ticker.stop();
            }
        });
        
        bm.getSuccess().addListener((Observable value) -> {
            if (bm.getSuccess().get()) {
                ticker.stop();
            }
        });

        topPane.mines.textProperty().bind(bm.getNbMinesLeft().asString());
        topPane.gameStatus.textProperty().bind(Bindings.when( bm.getSuccess()  ).then(":)").otherwise(Bindings.when(bm.getEndGame()).then(":(").otherwise(":|")));
        
        
    }

    private void resizeUserInterface() {
        width.setValue(gm.getNbCols() * Configuration.getTileWidth());
        height.setValue(gm.getNbRows() * Configuration.getTileHeight() + topPane.getContent().getPrefHeight());
    }

    public DoubleProperty widthProperty() {
        return width;
    }

    public DoubleProperty heightProperty() {
        return height;
    }

    public Scene getScene() {
        return scene;
    }

    final class MenuPane extends VBox {

        Button beginnerModeBtn = new Button("  beginner   ");
        Button intermediateModeBtn = new Button("intermediate ");
        Button expertModeBtn = new Button("  expert     ");

        public MenuPane() {
            setPadding(new Insets(20));
            setAlignment(Pos.CENTER);
            setSpacing(20);
            setStyle("-fx-background-color: #373737;");
           
            
            beginnerModeBtn.setPrefWidth(100);
            intermediateModeBtn.setPrefWidth(beginnerModeBtn.getPrefWidth());
            expertModeBtn.setPrefWidth(beginnerModeBtn.getPrefWidth());
            getChildren().addAll(beginnerModeBtn, intermediateModeBtn, expertModeBtn);

            beginnerModeBtn.setOnAction((e) -> {
                gm = GameMode.BEGINNER;
                switchToGameArea();
                ticker.play();
            });
            intermediateModeBtn.setOnAction((e) -> {
                gm = GameMode.INTERMEDIATE;
                switchToGameArea();
                ticker.play();
            });
            expertModeBtn.setOnAction((e) -> {
                gm = GameMode.EXPERT;
                switchToGameArea();
                ticker.play();
            });
        }

        public void switchToGameArea() {
            constructGameArea();
            rootPanel.getChildren().remove(menu);
            rootPanel.getChildren().addAll(gameArea);
        }
        
        public void switchToMenuArea() {         
            rootPanel.getChildren().remove(gameArea);
            rootPanel.getChildren().addAll(menu);
            width.setValue(menu.getWidth());
            height.setValue(menu.getHeight());
        }
    }

    class TopPane {

        Pane p = new Pane();
        Label time = new Label("time : ");
        Label mines = new Label();
        Label gameStatus = new Label();

        public TopPane() {
            p.getChildren().addAll(time, gameStatus, mines);
            constructPane();
        }

        private void constructPane(){
            time.setLayoutX(10);
            gameStatus.layoutXProperty().bind(width.divide(2).subtract(20));
            mines.layoutXProperty().bind(height);
            mines.layoutXProperty().bind(width.subtract(40));
            time.setLayoutY(19);
            gameStatus.setLayoutY(19);
            mines.setLayoutY(19);
            p.setPrefHeight(50);
            p.setStyle("-fx-background-color : linear-gradient(from 0px 0px to 0px 50px, gray, darkgray 50%, dimgray 99%, white)");
            p.prefWidthProperty().bind(width);
        }
        
        public Pane getContent() {
            return p;
        }

        StringProperty time() {
            return time.textProperty();
        }

        StringProperty mines() {
            return mines.textProperty();
        }

    }
}
