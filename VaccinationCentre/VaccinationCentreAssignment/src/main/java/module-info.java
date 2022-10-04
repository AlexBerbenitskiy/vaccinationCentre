module com.example.vaccinationcentre {
    requires javafx.controls;
    requires javafx.fxml;
    requires xstream;


    opens com.example.vaccinationcentre to javafx.fxml, xstream;
    exports com.example.vaccinationcentre;
}