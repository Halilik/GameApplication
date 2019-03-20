package com.example.gameapp.app.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


//Create POJO for Platform object
public class Platform  {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("NumberOfSales")
    @Expose
    private Integer numberOfSales;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumberOfSales() {
        return numberOfSales;
    }

    public void setNumberOfSales(Integer numberOfSales) {
        this.numberOfSales = numberOfSales;
    }

}
