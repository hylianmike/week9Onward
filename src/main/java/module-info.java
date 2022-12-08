module com.example.week9onward {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.net.http;
    requires com.google.gson;

    opens com.example.week9onward to javafx.fxml, com.google.gson;
    exports com.example.week9onward;
}