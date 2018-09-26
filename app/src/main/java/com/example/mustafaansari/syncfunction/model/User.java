package com.example.mustafaansari.syncfunction.model;

public class User {

    Long _ID;
    String ROW_USERNAME;
    String ROW_PASSWORD;

    public Long get_ID() {
        return _ID;
    }

    public void set_ID(Long _ID) {
        this._ID = _ID;
    }

    public String getROW_USERNAME() {
        return ROW_USERNAME;
    }

    public void setROW_USERNAME(String ROW_USERNAME) {
        this.ROW_USERNAME = ROW_USERNAME;
    }

    public String getROW_PASSWORD() {
        return ROW_PASSWORD;
    }

    public void setROW_PASSWORD(String ROW_PASSWORD) {
        this.ROW_PASSWORD = ROW_PASSWORD;
    }
}
