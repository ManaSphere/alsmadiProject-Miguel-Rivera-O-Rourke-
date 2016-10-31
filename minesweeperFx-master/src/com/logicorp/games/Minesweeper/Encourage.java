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

public class Encourage extends Application {

    @Override public void start(Stage stage) {
        Text hint1 = new Text(10, 60, "You can do it!");
        Text hint2 = new Text(10, 40, "I believe in you!");
        Text hint3 = new Text(10, 20, "Do Your Best!");
        hint1.setFont(new Font(20));
        hint2.setFont(new Font(20));
        hint3.setFont(new Font(20));
        Scene scene = new Scene(new Group(hint1, hint2, hint3));

        stage.setTitle("Go For It!"); 
        stage.setScene(scene); 
        stage.sizeToScene(); 
        stage.show(); 
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
