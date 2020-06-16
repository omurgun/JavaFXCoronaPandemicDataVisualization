package CoronaPandemic.Model;

import javafx.beans.property.SimpleStringProperty;

public class Graph1Model {



    private SimpleStringProperty country;
    private SimpleStringProperty totalCases;
    private SimpleStringProperty newCases;
    private SimpleStringProperty totalDeaths;
    private SimpleStringProperty newDeaths;
    private SimpleStringProperty populatio;
    private SimpleStringProperty mortality;
    private SimpleStringProperty attackRate;


    public Graph1Model(String country, String totalCases, String newCases, String totalDeaths, String newDeaths, String populatio, String mortality, String attackRate) {
        this.country = new SimpleStringProperty(country);
        this.totalCases = new SimpleStringProperty(totalCases);
        this.newCases = new SimpleStringProperty(newCases);
        this.totalDeaths = new SimpleStringProperty(totalDeaths);
        this.newDeaths = new SimpleStringProperty(newDeaths);
        this.populatio = new SimpleStringProperty(populatio);
        this.mortality = new SimpleStringProperty(mortality);
        this.attackRate = new SimpleStringProperty(attackRate);
    }
    public Graph1Model() {

    }
    public Graph1Model(String country, String newCases, String newDeaths, String populatio) {
        this.country = new SimpleStringProperty(country);
        this.newCases = new SimpleStringProperty(newCases);
        this.newDeaths = new SimpleStringProperty(newDeaths);
        this.populatio = new SimpleStringProperty(populatio);
    }
    public Graph1Model(String country, String totalCases, String totalDeaths) {
        this.country = new SimpleStringProperty(country);
        this.totalCases = new SimpleStringProperty(totalCases);
        this.totalDeaths = new SimpleStringProperty(totalDeaths);
    }
    public String getCountry() {
        return country.get();
    }
    public SimpleStringProperty countryProperty() {
        return country;
    }
    public void setCountry(String country) {
        this.country.set(country);
    }
    public String getTotalCases() {
        return totalCases.get();
    }
    public SimpleStringProperty totalCasesProperty() {
        return totalCases;
    }
    public void setTotalCases(String totalCases) {
        this.totalCases.set(totalCases);
    }
    public String getNewCases() {
        return newCases.get();
    }
    public SimpleStringProperty newCasesProperty() {
        return newCases;
    }
    public void setNewCases(String newCases) {
        this.newCases.set(newCases);
    }
    public String getTotalDeaths() {
        return totalDeaths.get();
    }
    public SimpleStringProperty totalDeathsProperty() {
        return totalDeaths;
    }
    public void setTotalDeaths(String totalDeaths) {
        this.totalDeaths.set(totalDeaths);
    }
    public String getNewDeaths() {
        return newDeaths.get();
    }
    public SimpleStringProperty newDeathsProperty() {
        return newDeaths;
    }
    public void setNewDeaths(String newDeaths) {
        this.newDeaths.set(newDeaths);
    }
    public String getPopulatio() {
        return populatio.get();
    }
    public SimpleStringProperty populatioProperty() {
        return populatio;
    }
    public void setPopulatio(String populatio) {
        this.populatio.set(populatio);
    }
    public String getMortality() {
        return mortality.get();
    }
    public SimpleStringProperty mortalityProperty() {
        return mortality;
    }
    public void setMortality(String mortality) {
        this.mortality.set(mortality);
    }
    public String getAttackRate() {
        return attackRate.get();
    }
    public SimpleStringProperty attackRateProperty() {
        return attackRate;
    }
    public void setAttackRate(String attackRate) {
        this.attackRate.set(attackRate);
    }
}
