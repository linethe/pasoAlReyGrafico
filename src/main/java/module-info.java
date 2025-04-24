module com.castelar.calculator {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.castelar.calculator to javafx.fxml;
    exports com.castelar.calculator;
}