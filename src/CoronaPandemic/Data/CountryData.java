package CoronaPandemic.Data;

import CoronaPandemic.Model.Country;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Scanner;

public class CountryData {

    public ArrayList<String> GetDataCountry(String covidUrl) throws IOException {
        System.out.println("Veri okunuyor lütfen bekleyiniz....");
        String data="";

        ArrayList<String> arrayList = new ArrayList<>();

        URL url = new URL(covidUrl);
        URLConnection urlConnection = url.openConnection();
        InputStreamReader reader = new InputStreamReader(urlConnection.getInputStream());
        Scanner scanner = new Scanner(reader);

        while (scanner.hasNext())
        {
            data = scanner.nextLine();
            arrayList.add(data);

        }
        scanner.close();

        return arrayList;
    }
    public String[] dataDivision(ArrayList<String> data1) {
        String data = data1.toString();
        String yenidata1 = data.replaceAll("^<\\?xml version=\"1.0\" encoding=\"ISO-8859-1\"\\?>|\\s|\\[|,|]|<\\?xml version=\"1.0\" encoding=\"UTF-8\"\\?>|<\\/?records>|<\\/record>|<dateRep>|<day>|<month>|<year>|<cases>|<deaths>|<continentExp>|<countriesAndTerritories>|<geoId>|<countryterritoryCode>|<popData2018>|<continentExp>","");
        String yenidata2 = yenidata1.replaceAll("<\\/record>|<\\/dateRep>|<\\/day>|<\\/month>|<\\/year>|<\\/cases>|<\\/deaths>|<\\/countriesAndTerritories>|<\\/geoId>|<\\/countryterritoryCode>|<\\/popData2018>","+");
        String yenidata3 = yenidata2.replaceAll("<\\/continentExp>","=");
        String[] arr1 = yenidata3.split("<record>");

        ArrayList<String> arrayList = new ArrayList<>();
        String result ="";
        for (String dt :arr1)
        {
            arrayList.add(dt);
        }
        result = arrayList.toString();
        String yenidata4 = result.replaceAll("\\[|,|]|","");
        String[] arr2 = yenidata4.split("=");

        return arr2;

    }
    public ArrayList<Country> ModelData(String[] data) {
        ArrayList<Country> countryArrayList = new ArrayList<Country>();
        for (int i = 0; i < data.length; i++)
        {
            String[] arr = data[i].split("\\+");
            countryArrayList.add(new Country(arr[0], arr[1], arr[2], arr[3], arr[4], arr[5], arr[6], arr[7], arr[8], arr[9], arr[10]));
        }
        System.out.println("Veri okuma bitti, herşey hazır...");
        return countryArrayList;

    }
}

