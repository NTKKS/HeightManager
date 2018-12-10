package cz.uhk.fim.heightmanager.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class HeightItem {
    private String jmeno;
    private String prijmeni;
    private double vyska;
    private boolean dostacuje;
    private String dateTime;

    Date date = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    public HeightItem() {
    }

    public HeightItem(String jmeno, String prijmeni, double vyska) {
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
        this.vyska = vyska;
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
        return vyska > 195;
    }

    public void setDostacuje(boolean dostacuje) {
        this.dostacuje = dostacuje;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }
}
