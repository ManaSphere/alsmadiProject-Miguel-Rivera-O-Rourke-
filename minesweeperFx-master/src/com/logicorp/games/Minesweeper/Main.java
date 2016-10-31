package com.logicorp.games.Minesweeper;


import com.logicorp.games.Minesweeper.ui.UserInterface;
import javafx.application.Application;
import javafx.stage.Stage;


public class Main extends Application {
       
    @Override
    public void start(Stage primaryStage) {
       primaryStage.setResizable(false);
       primaryStage.setMaximized(false);
       UserInterface ui=new UserInterface();
       
       ui.widthProperty().addListener((e)->{primaryStage.setWidth(ui.widthProperty().getValue());primaryStage.centerOnScreen();});       
       ui.heightProperty().addListener((e)->{primaryStage.setHeight(ui.heightProperty().getValue()+20);primaryStage.centerOnScreen();});              
       
       primaryStage.setScene(ui.getScene());       
       primaryStage.setTitle("Mine Sweeper");
       primaryStage.show();
       
    }
   
  
}
