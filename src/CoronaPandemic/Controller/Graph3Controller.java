package CoronaPandemic.Controller;

import CoronaPandemic.Model.Country;
import CoronaPandemic.Model.Graph2Model;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.ResourceBundle;

public class Graph3Controller implements Initializable {
    @FXML
    private LineChart<String, Number> lineChartData;

    @FXML
    private ListView<String> listViewGraph3;
    @FXML
    void DataEventGrap3(ActionEvent event) {
        Show();
    }

    public static ArrayList<Country> covidData;
    public ArrayList<Graph2Model> graph2Models = new ArrayList<Graph2Model>();
    public static ArrayList<Graph2Model> models;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        listViewGraph3.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        Boolean boolCountry = true;
        String countryCode1;
        String countryCode2="";

        for (Country gm:covidData)
        {

            countryCode1 =gm.getCountryTerritoryCode();
            if(!boolCountry)
            {
                if(!countryCode2.equals(countryCode1))
                {
                    boolCountry = true;
                }
            }

            if(countryCode1.equals(gm.getCountryTerritoryCode()) && boolCountry )
            {

                listViewGraph3.getItems().add(gm.getCountriesAndTerritories());

                boolCountry = false;

                countryCode2=countryCode1;

            }

        }


    }
    public ArrayList<Graph2Model> ModelData() {
        Boolean boolCountry = true;
        String countryCode1;
        String countryCode2 = "";
        int sayac = 0;
        for (Country c: covidData)
        {

            countryCode1 = c.getCountryTerritoryCode();
            if (!countryCode2.equals(countryCode1))
            {
                sayac++;
            }

            graph2Models.add(new Graph2Model(c.getCountriesAndTerritories(),c.getDateRep(),c.getCases(),c.getDeaths(),sayac));

            if (!countryCode2.equals(countryCode1))
            {
                boolCountry = true;

            }
            if (boolCountry)
            {

                boolCountry = false;
                countryCode2 = countryCode1;
            }
        }
        return graph2Models;
    }
    public ArrayList<Graph2Model> SortAndWrite() {
        ArrayList<Graph2Model> models = ModelData();
        ArrayList<Graph2Model> onlyOneCountry = new ArrayList<Graph2Model>();
        ArrayList<Graph2Model> lastList = new ArrayList<Graph2Model>();
        int sayac=1;
        Boolean ok=false;
        for (Graph2Model g2m:models)
        {
            if(g2m.getPrivateNumber() == sayac)
            {
                onlyOneCountry.add(new Graph2Model(g2m.getCountry(),g2m.getDates(),g2m.getCases(),g2m.getDeaths(),g2m.getPrivateNumber(),g2m.getContinentExp()));
            }
            if(g2m.getPrivateNumber() != sayac)
            {
                Collections.reverse(onlyOneCountry);
                sayac++;
                ok =true;
            }
            if(ok)
            {
                for(Graph2Model gm:onlyOneCountry)
                {
                    lastList.add(new Graph2Model(gm.getCountry(),gm.getDates(),gm.getCases(),gm.getDeaths(),gm.getPrivateNumber(),gm.getContinentExp()));
                }
                onlyOneCountry.clear();
                onlyOneCountry.add(new Graph2Model(g2m.getCountry(),g2m.getDates(),g2m.getCases(),g2m.getDeaths(),g2m.getPrivateNumber(),g2m.getContinentExp()));
                ok = false;
            }
        }
        Collections.reverse(onlyOneCountry);
        for(Graph2Model gm:onlyOneCountry)
        {
            lastList.add(new Graph2Model(gm.getCountry(),gm.getDates(),gm.getCases(),gm.getDeaths(),gm.getPrivateNumber(),gm.getContinentExp()));
        }
        return lastList;
    }
    public void Show() {
        ObservableList<String> countryInfo;
        countryInfo = listViewGraph3.getSelectionModel().getSelectedItems();

        int totaldeath=0;
        XYChart.Series<String, Number> series = new XYChart.Series<String, Number>();
        series.getData().removeAll(Collections.singleton(lineChartData.getData().setAll()));

        String check = "check";
        String nowCheck = "nowCheck";

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        for (String s:countryInfo)
        {
            for (Graph2Model model : models)
            {

                if (s.equals(model.getCountry()))
                {
                    nowCheck = model.getCountry();

                    if (!check.equals(nowCheck))
                    {

                        series = new XYChart.Series();
                        series.setName(model.getCountry());
                        totaldeath=0;
                        check = model.getCountry();
                        nowCheck = model.getCountry();
                        lineChartData.getData().add(series);

                    }

                    totaldeath +=Integer.parseInt(model.getDeaths());

                    Date date1 = new Date();
                    Date date2 = new Date();
                    try {
                        date1=dateFormat.parse(model.getDates());
                        date2=dateFormat.parse("20/05/2020");
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    if(date1.after(date2))
                    {
                        series.getData().add(new XYChart.Data<String, Number>(model.getDates(),totaldeath));
                    }

                }
            }

        }

    }
    public void GetData(ArrayList<Country> countries) {

        covidData = countries;
        models = SortAndWrite();

    }
}
