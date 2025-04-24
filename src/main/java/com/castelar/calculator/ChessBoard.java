package com.castelar.calculator;

import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class ChessBoard {

    GridPane chessBoard;
    String theme;
    String path;
    public ArrayList<Square> squares = new ArrayList<>();

    public ChessBoard(GridPane chessBoard, String theme, String path){
        this.chessBoard = chessBoard;
        this.theme = theme;
        this.path = path;
        makeBoard(this.chessBoard, theme);
    }


    private void makeBoard(GridPane chessBoard, String theme){
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                Square square = new Square(i,j);
                square.setName("Square" + i + j);
                square.setPrefHeight(100);
                square.setPrefWidth(100);
                square.setBorder(new Border(new BorderStroke(Color.BLACK,
                        BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
                setTheme(square, theme, i, j);
                chessBoard.add(square, i, j, 1, 1);
                squares.add(square);
            }
        }
        addPieces(); // Añade las piezas
    }

    private void setTheme(Square square, String theme, int i, int j){
        Color color1 = Color.web("#ffffff00");
        Color color2 = Color.web("#ffffff00");

        switch (theme) {
            case "Coral" -> {
                color1 = Color.web("#b1e4b9");
                color2 = Color.web("#70a2a3");
            }
            case "Dusk" -> {
                color1 = Color.web("#cbb7ae");
                color2 = Color.web("#716677");
            }
            case "Wheat" -> {
                color1 = Color.web("#eaefce");
                color2 = Color.web("#bbbe65");
            }
            case "Marine" -> {
                color1 = Color.web("#9dacff");
                color2 = Color.web("#6f74d2");
            }
            case "Emerald" -> {
                color1 = Color.web("#adbd90");
                color2 = Color.web("#6e8f72");
            }
            case "Sandcastle" -> {
                color1 = Color.web("#e4c16f");
                color2 = Color.web("#b88b4a");
            }
        }

        if((i+j)%2==0){
            square.setBackground(new Background(new BackgroundFill(color1, CornerRadii.EMPTY, Insets.EMPTY)));
        }else{
            square.setBackground(new Background(new BackgroundFill(color2, CornerRadii.EMPTY, Insets.EMPTY)));
        }

    }

    private void addPiece(Square square, Piece piece){
        square.getChildren().add(piece);
        square.occupied = true;
    }

    private void addPieces(){

        char letra;
        int filas=5;
        int columnas=5;

        char[][] matriz = new char[filas][columnas];


        //PATH INTEGRAR EN EL PRINCIPAL





        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String linea=new String();

            int fila = 0;
            while ((linea = br.readLine()) != null && fila < filas) {
                String[] values = linea.split(", ");
                for (int col = 0; col < values.length; col++) {
                    letra=values[col].charAt(0);// Obtengo la letra
                    matriz[fila][col] = letra; //La guardo en la matriz

                    // Dependiendo de la letra guardo su posición

                    //Coordenadas cartesianas (suponiendo que hacia abajo es positivo y a la derecha es positivo)
                    //Abcisas: X
                    //Ordenadas: Y
                    //Fuente: https://www.youtube.com/watch?v=Q1-KWwcbLzg



                }
                fila++;
            }
            //Cuando ha terminado de rellenar la matriz guardo las distancias euclideas y manhattan
//            calcularDistanciaEuclideaRey();
//            calcularDistanciaManhattanRey();

//            calcularDistanciaEuclideaHueco();
//            calcularDistanciaManhattanHueco();


        } catch (IOException e) {
            e.printStackTrace();
        }


        for(Square square : squares){
            System.out.println("("+square.x+","+square.y+")");

            letra=matriz[square.y][square.x];
            if(square.y == 0) {
            //    System.out.println();
            }
            //System.out.print(letra+", ");

            if(square.occupied) continue;
            switch (letra){

                case 'R':
                    //posRey.setXY(col,fila);
                    //matriz[col][fila] = letra; //La guardo en la matriz
                    addPiece(square, new King("white", square.x, square.y));


                    break;

                case 'T':
                    //posRey.setXY(col,fila);
                    addPiece(square, new Rook("white", square.x,square.y ));


                    break;

                case 'A':
                    //posRey.setXY(col,fila);
                    addPiece(square, new Bishop("white", square.x, square.y));


                    break;

                case 'H':
                    //posHueco.setXY(col,fila);


                    break;

                case 'M':
                    //posHueco.setXY(col,fila);
                    addPiece(square, new Pawn("black", square.x, square.y));

                    break;

                case 'O': //REINA
                    //posObjetivo.setXY(col,fila);
                    addPiece(square, new Queen("black", square.x, square.y));

                    break;

            }



            if(square.y == 1){
//                addPiece(square, new Pawn("black", square.x, square.y));
            }
            else if(square.y == 6){
//                addPiece(square, new Pawn("white", square.x, square.y));
            }
            else if(square.y == 0){
                if(square.x == 4){
//                    addPiece(square, new King("black", square.x, square.y));
                }
                if(square.x == 3){
//                    addPiece(square, new Queen("black", square.x, square.y));
                }
                if(square.x == 2 || square.x == 5){
//                    addPiece(square, new Bishop("black", square.x, square.y));
                }
                if(square.x == 1 || square.x == 6){
//                    addPiece(square, new Knight("black", square.x, square.y));
                }
                if(square.x == 0 || square.x == 7){
//                    addPiece(square, new Rook("black", square.x, square.y));
                }
            }
            else if(square.y == 7){
                if(square.x == 4){
                }
                if(square.x == 3){
//                    addPiece(square, new Queen("white", square.x, square.y));
                }
                if(square.x == 2 || square.x == 5){
//                    addPiece(square, new Bishop("white", square.x, square.y));
                }
                if(square.x == 1 || square.x == 6){
//                    addPiece(square, new Knight("white", square.x, square.y));
                }
                if(square.x == 0 || square.x == 7){
//                    addPiece(square, new Rook("white", square.x, square.y));
                }
            }


        }
    }


}
