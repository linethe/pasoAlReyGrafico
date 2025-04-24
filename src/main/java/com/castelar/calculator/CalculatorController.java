package com.castelar.calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CalculatorController {
    @FXML
    private TextField txtField; // Texto de la calculadora

    // Cadenas
    private static String cadena_entrada="";// getText
    private static String cadena_salida = "0"; // setText

    // Boton
    private static String button_string;

    // Control
    private boolean primera = true; // Control: Primer operando del inicio


    // RESET
    private void casoAC(){
        System.out.println("Caso AC");
        txtField.setText("0");
        primera=true;
    }

    // Si pulso 0 y hay un 0
    private void caso0(){
    //    System.out.println("Caso 0");

        if (!primera){ //Si no es el primero
            txtField.setText(txtField.getText()+button_string);
        }
        else {
            txtField.setText("0");
        }
    }

    // Si pulso n y hay n, desplazo a la izquierda
    private void casoNumero(){
        //System.out.println("Caso Numero o Punto");
        txtField.setText(txtField.getText()+button_string);
//        cadena_salida = cadena_salida + cadena_entrada;
        primera=false;
    }

    // No puedo poner mas de una coma
    private void casoComa() {
        String texto=txtField.getText();
        if(texto.indexOf(",")==-1){
            txtField.setText(txtField.getText()+",");
        }
        primera=false;
    }

    // si pulso operador me voy quedando con el último, si
    private static void casoOperador(){
        System.out.println("Caso Operador");


//        operador = cadena_entrada;
//        valor_primer_operando = Double.parseDouble(cadena_salida);
//        bandera_operacion = true;
//        primera=true;
    }

    // obtengo el resultado siempre que haya operando
    // si hay segundo operando actuaría como un igual controlar esta situación.
    private static void casoIgual(){
        //Falta comprobación

        System.out.println("Caso Igual");


//        valor_segundo_operando =Double.parseDouble(cadena_salida);
//
//        switch(operador)
//        {
//            case "+" :
//                resultado = valor_primer_operando + valor_segundo_operando;
//                break;
//            case "-" :
//                resultado = valor_primer_operando - valor_segundo_operando;
//                break;
//            case "*" :
//                resultado = valor_primer_operando * valor_segundo_operando;
//                break;
//            case "/" :
//                resultado = valor_primer_operando / valor_segundo_operando;
//                break;
//        }
//
//        //Ver si es entero
//
//        if((resultado-(int)resultado)==0){
//            cadena_salida=(int)resultado+"";
//        }
//        else {
//            cadena_salida=resultado+"";
//        }
//
//        primera=true;
    }


    @FXML
    private void onEveryButtonClick(ActionEvent actionEvent) {
        Button button = (Button) actionEvent.getSource();
        button_string = button.getId().substring(3);
        //System.out.println(button_string);
        //System.out.println(primera);
        if(primera){
            txtField.setText("");
        }
        switch (button_string){
            case "AC": //reset
                casoAC();
                break;
            case "0":
                caso0();
                break;
            case "1","2","3","4","5","6","7","8","9":
                casoNumero();
                break;
            case "Coma":
                casoComa();
                break;
            //Case +/-

            //Case Percentage

            case "Add","Sub","Mult","Div": // operador
                //caso que debería contemplar 2 + 2 + 2 // El más actuaría como un igual // usar bandera
                casoOperador();
                break;
            case "Equals": //igual //comprobar que hay operación
                casoIgual();
        }
    }



}