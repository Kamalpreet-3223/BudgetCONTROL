package com.example.budgetcontrol;

public class Budget {


    private String month;
    private String year;
    private String date;
    private Integer id=0;
    private Double amt_paid;
    private String description;

    public Budget(String year, String month, String date, Double amt_paid, String description) {
        this.id = ++id;
        this.month = month;
        this.year = year;
        this.date = date;
        this.amt_paid = amt_paid;
        this.description = description;
    }


    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public Double getAmt_paid() {
        return amt_paid;
    }

    public void setAmt_paid(Double amt_paid) {
        this.amt_paid = amt_paid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}
