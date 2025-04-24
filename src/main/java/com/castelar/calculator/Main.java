package com.castelar.calculator;

/***
 * Calculadora estándar que ofrece operaciones básicas y evalúa los comandos inmediatamente a medida que se ingresan.
 * Se crea una clase Main, ya que Jar no puede ejecutar una clase que extienda de otra.
 * El archivo pom.xml debe contener el plugin maven-shade para crear el JAR
 * author: Miguel Castelló Sosa
 */
public class Main {
    public static void main(String[] args) {
        CalculatorApplication.main(args);
    }
}
