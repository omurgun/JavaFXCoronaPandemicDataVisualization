package CoronaPandemic.Model;

public class Country implements Comparable<Country>{
    private String cases;
    private String deaths;
    private String countriesAndTerritories;
    private String geoId;
    private String countryTerritoryCode;
    private String popData2018;
    private String continentExp;
    private String year;
    private String month;
    private String day;
    private String dateRep;

    public Country() {

    }
    public Country(String dateRep, String day, String month, String year, String cases, String deaths, String countriesAndTerritories, String geoId, String countryTerritoryCode, String popData2018, String continentExp) {
        this.cases = cases;
        this.deaths = deaths;
        this.countriesAndTerritories = countriesAndTerritories;
        this.geoId = geoId;
        this.countryTerritoryCode = countryTerritoryCode;
        this.popData2018 = popData2018;
        this.continentExp = continentExp;
        this.year = year;
        this.month = month;
        this.day = day;
        this.dateRep = dateRep;
    }

    public String getCases() {
        return cases;
    }
    public String getDeaths() {
        return deaths;
    }
    public String getCountriesAndTerritories() {
        return countriesAndTerritories;
    }
    public String getCountryTerritoryCode() {
        return countryTerritoryCode;
    }
    public String getPopData2018() {
        return popData2018;
    }
    public String getContinentExp() {
        return continentExp;
    }
    public String getDateRep() {
        return dateRep;
    }

    @Override
    public int compareTo(Country o) {
        return this.getCountriesAndTerritories().compareTo(o.countriesAndTerritories);
    }


}