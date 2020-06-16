package CoronaPandemic.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class GraphManager {

    @FXML
    void eventChangeGraph1(ActionEvent event) {
        OpenGraph1();
    }
    @FXML
    void eventChangeGraph2(ActionEvent event) {
        OpenGraph2();
    }

    @FXML
    void eventChangeGraph3(ActionEvent event) {
        OpenGraph3();
    }
    @FXML
    void eventChangeGraph4(ActionEvent event) {
        OpenGraph4();
    }
    @FXML
    void eventChangeGraph5(ActionEvent event) {
        OpenGraph5();
    }


    public void OpenGraph1()  {


        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/CoronaPandemic/View/graph1.fxml"));
            Parent root1 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Cases And Deaths By Country Table");
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void OpenGraph2()  {



        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/CoronaPandemic/View/graph2.fxml"));
            Parent root1 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Total Cases By Country Graphic");
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void OpenGraph3()  {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/CoronaPandemic/View/graph3.fxml"));
            Parent root1 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Total Deaths By Country Graphic");
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void OpenGraph4()  {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/CoronaPandemic/View/graph4.fxml"));
            Parent root1 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Total Cases By The Continent Graphic");
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void OpenGraph5()  {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/CoronaPandemic/View/graph5.fxml"));
            Parent root1 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Total Deaths By The Continent Graphic");
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
