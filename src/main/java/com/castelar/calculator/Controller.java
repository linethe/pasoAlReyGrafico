package com.castelar.calculator;

import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;

import java.net.URL;

public class Controller {

    @FXML
    GridPane chessBoard;

    public void initialize(){

        String textPath = "/com/castelar/calculator/files/PASOALREY2.txt";
        //        String textPath="/com/castelar/calculator/files/PASOALREY2.txt";
//        String textPath="/com/castelar/calculator/files/PASOALREY3.txt";
//        String textPath="/com/castelar/calculator/files/PASOALREY4.txt";
//        String textPath="/com/castelar/calculator/files/PASOALREY5.txt";
//        String textPath="/com/castelar/calculator/files/PASOALREY6.txt";
//        String textPath="/com/castelar/calculator/files/PASOALREY7.txt";
//        String textPath="/com/castelar/calculator/files/PASOALREY8.txt";
//        String textPath="/com/castelar/calculator/files/PASOALREY9.txt";
//        String textPath="/com/castelar/calculator/files/PASOALREY10.txt";

        URL textUrl = getClass().getResource(textPath);
        if (textUrl == null) {
            throw new IllegalArgumentException("No se encontró el archivo: " + textPath);
        }
        System.out.println("Cargando "+textUrl.toExternalForm().substring(5));


        // Themes are Coral, Dusk, Wheat, Marine, Emerald, Sandcastle

        Game game = new Game(chessBoard, "Coral", textUrl.toExternalForm().substring(5));

    }
}
