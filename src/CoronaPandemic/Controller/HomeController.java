package CoronaPandemic.Controller;

import CoronaPandemic.Utilities.ThreadForThisProject;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class HomeController {

    @FXML
    private TextField tbxUrl;

    @FXML
    void btnGetDataClickEvent(ActionEvent event) {

        ThreadForThisProject th = new ThreadForThisProject();
        ThreadForThisProject threadForThisProject = new ThreadForThisProject("covidThread",tbxUrl.getText());
        threadForThisProject.start();
        OpenGraphManager();
    }
    public void OpenGraphManager()  {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/CoronaPandemic/View/graphManager.fxml"));
            Parent root1 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Graph Manager");
            stage.setResizable(false);
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
