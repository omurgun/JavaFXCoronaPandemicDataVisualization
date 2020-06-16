package CoronaPandemic.Utilities;

import CoronaPandemic.Controller.*;
import CoronaPandemic.Data.CountryData;
import CoronaPandemic.Model.Country;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class ThreadForThisProject implements Runnable{

    private Thread thread;
    private String threadName;
    private String url;
    private ArrayList<String> countryDataList;
    private String[] data;
    private ArrayList<Country> dataForTable;
    CountryData countryData = new CountryData();
    public ThreadForThisProject(String threadName,String url) {
        this.threadName = threadName;
        this.url=url;

    }
    public ThreadForThisProject() {

    }
    public void Data(ArrayList<Country> countries) {
            Collections.sort(countries);
            Graph1Controller graph1Controller = new Graph1Controller();
            Graph2Controller graph2Controller = new Graph2Controller();
            Graph3Controller graph3Controller = new Graph3Controller();
            Graph4Controller graph4Controller = new Graph4Controller();
            Graph5Controller graph5Controller = new Graph5Controller();
            graph1Controller.GetData(countries);
            graph2Controller.GetData(countries);
            graph3Controller.GetData(countries);
            graph4Controller.GetData(countries);
            graph5Controller.GetData(countries);
    }
    @Override
    public void run() {

        try {
            countryDataList = countryData.GetDataCountry(url);
        } catch (IOException e) {
            System.out.println("Thread error!!");
        }
        data = countryData.dataDivision(countryDataList);
        dataForTable= countryData.ModelData(data);
        Data(dataForTable);

    }
    public void start() {

        if(thread==null)
        {
            thread = new Thread(this,threadName);
            thread.start();
        }

    }
}
