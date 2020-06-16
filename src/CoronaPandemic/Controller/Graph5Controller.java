package CoronaPandemic.Controller;

import CoronaPandemic.Model.Country;
import CoronaPandemic.Model.Graph2Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.chart.XYChart;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class Graph5Controller {
    @FXML
    private StackedBarChart<String, String> barChartData;

    @FXML
    void DataEvent(ActionEvent event) {

        Show();
    }
    public static ArrayList<Country> covidData;
    public ArrayList<Graph2Model> graph2Models = new ArrayList<Graph2Model>();
    public void GetData(ArrayList<Country> countries) {

        covidData = countries;
    }
    public ArrayList<Graph2Model> ModelData() {
        Boolean boolCountry = true;
        String countryCode1;
        String countryCode2 = "";
        int sayac = 0;

        for (Country c : covidData)
        {

            countryCode1 = c.getCountryTerritoryCode();

            if (!countryCode2.equals(countryCode1))
            {
                sayac++;
            }

            graph2Models.add(new Graph2Model(c.getCountriesAndTerritories(), c.getDateRep(), c.getCases(), c.getDeaths(), sayac, c.getContinentExp()));

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
        ArrayList<Graph2Model> models = SortAndWrite();
       
        int totaldeathAsia=0;
        int totaldeathAfrica=0;
        int totaldeathAmerica=0;
        int totaldeathOceania=0;
        int totaldeathEurope=0;

        int sonnuc = 1;
        XYChart.Series seriesAsia = new XYChart.Series<>();
        XYChart.Series seriesAfrica = new XYChart.Series<>();
        XYChart.Series seriesAmerica = new XYChart.Series<>();
        XYChart.Series seriesOceania = new XYChart.Series<>();
        XYChart.Series seriesEurope = new XYChart.Series<>();


        seriesAsia.setName("Asia");
        seriesAfrica.setName("Africa");
        seriesAmerica.setName("America");
        seriesOceania.setName("Oceania");
        seriesEurope.setName("Europe");

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date1 = new Date();
        Date date2 = new Date();



        for (Graph2Model model : models) {

            if (model.getPrivateNumber() == sonnuc)
            {


                 totaldeathAsia=0;
                 totaldeathAfrica=0;
                 totaldeathAmerica=0;
                 totaldeathOceania=0;
                 totaldeathEurope=0;


                sonnuc++;

            }

            try {
                date1 = dateFormat.parse(model.getDates());
                date2 = dateFormat.parse("20/05/2020");
            } catch (ParseException e) {
                e.printStackTrace();
            }


            if (model.getContinentExp().equals("Asia")) {

                    totaldeathAsia +=Integer.parseInt(model.getDeaths());
                    if (date1.after(date2))
                    {
                        seriesAsia.getData().add(new XYChart.Data(model.getDates(), totaldeathAsia));
                    }
                }
                if (model.getContinentExp().equals("Africa")){

                    totaldeathAfrica +=Integer.parseInt(model.getDeaths());
                    if (date1.after(date2))
                    {
                        seriesAfrica.getData().add(new XYChart.Data(model.getDates(), totaldeathAfrica));
                    }

                }
                if (model.getContinentExp().equals("America"))
                {

                    totaldeathAmerica +=Integer.parseInt(model.getDeaths());
                    if (date1.after(date2))
                    {
                        seriesAmerica.getData().add(new XYChart.Data(model.getDates(), totaldeathAmerica));
                    }

                }
                if (model.getContinentExp().equals("Oceania"))
                {
                    totaldeathOceania +=Integer.parseInt(model.getDeaths());
                    if (date1.after(date2))
                    {
                        seriesOceania.getData().add(new XYChart.Data(model.getDates(), totaldeathOceania));
                    }

                }
                if (model.getContinentExp().equals("Europe"))
                {
                    totaldeathEurope +=Integer.parseInt(model.getDeaths());
                    if (date1.after(date2))
                    {
                        seriesEurope.getData().add(new XYChart.Data(model.getDates(), totaldeathEurope));
                    }
                }

        }

        barChartData.getData().addAll(seriesAsia, seriesAfrica, seriesAmerica, seriesOceania, seriesEurope);
    }
}





