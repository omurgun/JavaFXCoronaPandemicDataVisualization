package CoronaPandemic.Model;

public class Graph2Model {
    private String cases;
    private String deaths;
    private String dates;
    private String country;
    private String continentExp;
    private int privateNumber;


    public Graph2Model(String country, String dates, String cases, String deaths , int privateNumber,String continentExp) {
        this.cases = cases;
        this.deaths = deaths;
        this.dates = dates;
        this.country = country;
        this.privateNumber = privateNumber;
        this.continentExp = continentExp;
    }
    public Graph2Model(String country, String dates, String cases, String deaths , int privateNumber) {
        this.cases = cases;
        this.deaths = deaths;
        this.dates = dates;
        this.country = country;
        this.privateNumber = privateNumber;
    }
    public String getContinentExp() {
        return continentExp;
    }
    public int getPrivateNumber() {
        return privateNumber;
    }
    public String getCases() {
        return cases;
    }
    public String getDeaths() {
        return deaths;
    }
    public String getDates() {
        return dates;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }

}
