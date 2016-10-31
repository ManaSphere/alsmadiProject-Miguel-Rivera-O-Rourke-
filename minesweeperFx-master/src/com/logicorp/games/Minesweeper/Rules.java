/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logicorp.games.Minesweeper;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Rules extends Application {

    @Override public void start(Stage stage) {
        Text hint1 = new Text(10, 60, "Try to reveal all the mines!");
        Text hint2 = new Text(10, 40, "Don't hit a mine or its game over.");
        Text hint3 = new Text(10, 20, "the numbers represent how close they are to a mine");
        hint1.setFont(new Font(20));
        hint2.setFont(new Font(20));
        hint3.setFont(new Font(20));
        Scene scene = new Scene(new Group(hint1, hint2, hint3));

        stage.setTitle("Rules!"); 
        stage.setScene(scene); 
        stage.sizeToScene(); 
        stage.show(); 
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
    
