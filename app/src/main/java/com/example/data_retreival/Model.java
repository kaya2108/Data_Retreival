package com.example.data_retreival;

public class Model {
    private String fxn;
    private String name;
    private String regno;
    private String phone;
    private String year;
    private String branch;
    private String size;
    private String amtPaid;
    private String comments;

    public Model(String fxn, String name, String regno, String phone, String year, String branch, String size, String amtPaid, String comments) {
        this.fxn = fxn;
        this.name = name;
        this.regno = regno;
        this.phone = phone;
        this.year = year;
        this.branch = branch;
        this.size = size;
        this.amtPaid = amtPaid;
        this.comments = comments;
    }

    public String getFxn() {
        return fxn;
    }

    public void setFxn(String fxn) {
        this.fxn = fxn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegno() {
        return regno;
    }

    public void setRegno(String regno) {
        this.regno = regno;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getAmtPaid() {
        return amtPaid;
    }

    public void setAmtPaid(String amtPaid) {
        this.amtPaid = amtPaid;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
