module JavaFXCoronaPandemicDataVisualization {
    requires javafx.fxml;
    requires javafx.controls;
    opens CoronaPandemic;
    opens CoronaPandemic.Data;
    opens CoronaPandemic.Controller;
    opens CoronaPandemic.Model;

}