package com.itplus.demolistview;

import java.io.Serializable;

/**
 * Created by Administrator on 19/05/2017.
 */

public class CountryInfo implements Serializable{
    private String countryName ="";
    private String countryPosition="";

    public CountryInfo(String countryName, String countryPosition) {
        this.countryName = countryName;
        this.countryPosition = countryPosition;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryPosition() {
        return countryPosition;
    }

    public void setCountryPosition(String countryPosition) {
        this.countryPosition = countryPosition;
    }
}
