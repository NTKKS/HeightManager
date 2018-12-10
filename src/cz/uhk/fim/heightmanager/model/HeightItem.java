package cz.uhk.fim.heightmanager.model;

public class HeightItem {
    private String jmeno;
    private String prijmeni;
    private double vyska;
    private boolean dostacuje;
    private String datumZapisu;

    public HeightItem() {
    }

    public HeightItem(String jmeno, String prijmeni, double vyska, String datumZapisu) {
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
        this.vyska = vyska;
        this.datumZapisu = datumZapisu;

    }

    public String getJmeno() {
        return jmeno;
    }

    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    public String getPrijmeni() {
        return prijmeni;
    }

    public void setPrijmeni(String prijmeni) {
        this.prijmeni = prijmeni;
    }

    public double getVyska() {
        return vyska;
    }

    public void setVyska(double vyska) {
        this.vyska = vyska;
    }

    public boolean isDostacuje() {
        return vyska >= 195;
    }

    public void setDostacuje(boolean dostacuje) {
        this.dostacuje = dostacuje;
    }

    public String getDatumZapisu() {
        return datumZapisu;
    }

    public void setDatumZapisu(String datumZapisu) {
        this.datumZapisu = datumZapisu;
    }
}
