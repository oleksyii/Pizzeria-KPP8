module com.example.demo2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.demo2 to javafx.fxml;
    exports com.example.demo2;
    exports com.example.demo2.PizzaMenu;
    opens com.example.demo2.PizzaMenu to javafx.fxml;
}