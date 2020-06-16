package CoronaPandemic.Controller;

import CoronaPandemic.Model.Country;
import CoronaPandemic.Model.Graph1Model;
import CoronaPandemic.Utilities.ThreadForThisProject;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import java.util.ArrayList;


public class Graph1Controller extends ThreadForThisProject {


    @FXML
    private TableView<Graph1Model> tblView;

    @FXML
    private TableColumn colCountry;

    @FXML
    private TableColumn colTotalCases;

    @FXML
    private TableColumn colNewCases;

    @FXML
    private TableColumn colTotalDeaths;

    @FXML
    private TableColumn colNewDeaths;

    @FXML
    private TableColumn colPopulation;

    @FXML
    private TableColumn colMortality;

    @FXML
    private TableColumn colAttackRate;

    @FXML
    void DataEvent(ActionEvent event) {
        loadData();
    }
    public static final ObservableList<Graph1Model> list = FXCollections.observableArrayList();
    public void GetData(ArrayList<Country> countries) {
        hesaplaNew(countries);
        ArrayList<Country> countriess = countries;
        ArrayList<Graph1Model> graph1Models;
        ArrayList<Graph1Model> grap1NewModels;
        graph1Models = hesaplaTotal(countries);
        grap1NewModels = hesaplaNew(countries);

        int newCase=0;
        int newDeath=0;
        int newPopulation=0;
        Boolean boolCountry = true;

        String countryCode1;
        String countryCode2="";

        for (Country c:countriess)
        {
            countryCode1 =c.getCountryTerritoryCode();
            if(!boolCountry)
            {
                if(!countryCode2.equals(countryCode1))
                {
                    boolCountry = true;
                }
            }
            if(countryCode1.equals(c.getCountryTerritoryCode()) && boolCountry )
            {
                for (Graph1Model model: graph1Models)
                {

                    if (c.getCountriesAndTerritories().equals(model.getCountry()))
                    {
                        double mortality = (Double.parseDouble(model.getTotalDeaths())/Double.parseDouble(model.getTotalCases()));
                        double attackRate;
                         newCase=0;
                         newDeath=0;
                         newPopulation=0;
                        for (Graph1Model newModel : grap1NewModels)
                        {

                            if (c.getCountriesAndTerritories().equals(newModel.getCountry()))
                            {
                                newCase = Integer.parseInt(newModel.getNewCases());
                                newDeath = Integer.parseInt(newModel.getNewDeaths());
                                newPopulation = Integer.parseInt(newModel.getPopulatio());

                            }

                        }
                        attackRate = (Double.parseDouble(model.getTotalCases())/Double.parseDouble(String.valueOf(newPopulation)));
                        list.add(new Graph1Model(c.getCountriesAndTerritories(),model.getTotalCases(),String.valueOf(newCase),model.getTotalDeaths(),String.valueOf(newDeath),String.valueOf(newPopulation),String.valueOf(mortality),String.valueOf(attackRate)));
                    }
                }
                boolCountry = false;
                countryCode2=countryCode1;
            }

        }

    }
    public ArrayList<Graph1Model> hesaplaNew(ArrayList<Country> data) {
        ArrayList<Graph1Model> arrayList = new ArrayList<Graph1Model>();
        int newCase=0;
        int newDeath=0;
        int newPopulation=0;
        boolean change=true;
        String s1="AFG";
        String s1Name="bos";
        String s2;

        for (Country c : data)
        {

            s2=c.getCountryTerritoryCode();

            if (!s1.equals(s2))
            {
                arrayList.add(new Graph1Model(s1Name,String.valueOf(newCase),String.valueOf(newDeath),String.valueOf(newPopulation)));
                change=true;
            }
            if(change)
            {
                s1=c.getCountryTerritoryCode();
                s1Name=c.getCountriesAndTerritories();
                newCase = Integer.parseInt(c.getCases());
                newDeath = Integer.parseInt(c.getDeaths());

                if(!c.getPopData2018().isEmpty())
                {
                    newPopulation = Integer.parseInt(c.getPopData2018());
                }
                else
                {
                    newPopulation = Integer.parseInt("1");
                }
                change=false;
            }

        }
        arrayList.add(new Graph1Model(s1Name,String.valueOf(newCase),String.valueOf(newDeath),String.valueOf(newPopulation)));
        return  arrayList;

    }
    public  ArrayList<Graph1Model> hesaplaTotal(ArrayList<Country> data) {

        ArrayList<Graph1Model> newArrayList = new ArrayList<Graph1Model>();
        int numberCase = 0;
        int numberDeath =0;
        boolean change=true;
        String s1="";
        String s1Name="";
        String s2="";
        for (Country c :data)
        {
            s2=c.getCountryTerritoryCode();
            if(change)
            {
                s1=c.getCountryTerritoryCode();
                s1Name=c.getCountriesAndTerritories();
                change=false;
            }
            if (!s1.equals(s2))
            {

                newArrayList.add(new Graph1Model(s1Name,String.valueOf(numberCase),String.valueOf(numberDeath)));
                numberCase=0;
                numberDeath=0;
                change=true;
                numberDeath+=Integer.parseInt(c.getDeaths());
                numberCase+=Integer.parseInt(c.getCases());

            }
            else
            {

                numberDeath+=Integer.parseInt(c.getDeaths());
                numberCase+=Integer.parseInt(c.getCases());
            }
        }

        newArrayList.add(new Graph1Model(s1Name,String.valueOf(numberCase),String.valueOf(numberDeath)));

        return newArrayList;
    }
    private void loadData() {
        colCountry.setCellValueFactory(new PropertyValueFactory<Graph1Model,String>("country"));
        colTotalCases.setCellValueFactory(new PropertyValueFactory<Graph1Model,String>("totalCases"));
        colNewCases.setCellValueFactory(new PropertyValueFactory<Graph1Model,String>("newCases"));
        colTotalDeaths.setCellValueFactory(new PropertyValueFactory<Graph1Model,String>("totalDeaths"));
        colNewDeaths.setCellValueFactory(new PropertyValueFactory<Graph1Model,String>("newDeaths"));
        colPopulation.setCellValueFactory(new PropertyValueFactory<Graph1Model,String>("populatio"));
        colMortality.setCellValueFactory(new    PropertyValueFactory<Graph1Model,String>("mortality"));
        colAttackRate.setCellValueFactory(new PropertyValueFactory<Graph1Model,String>("attackRate"));

        tblView.setItems(list);
    }
}
