module com.example.comp1011st1178551test1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.comp1011st1178551test1 to javafx.fxml;
    exports com.example.comp1011st1178551test1;
}