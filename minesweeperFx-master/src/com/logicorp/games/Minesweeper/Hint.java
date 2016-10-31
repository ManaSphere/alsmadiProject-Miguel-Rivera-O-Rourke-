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

public class Hint extends Application {

    @Override public void start(Stage stage) {
        Text hint1 = new Text(10, 60, "Look for obvious mines like squares surrounded by eight ones!");
        Text hint2 = new Text(10, 40, "Start at the four corners to maximize sucess.");
        Text hint3 = new Text(10, 20, "Don't be afraid to take risks");
        hint1.setFont(new Font(20));
        hint2.setFont(new Font(20));
        hint3.setFont(new Font(20));
        Scene scene = new Scene(new Group(hint1, hint2, hint3));

        stage.setTitle("Hints!"); 
        stage.setScene(scene); 
        stage.sizeToScene(); 
        stage.show(); 
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}