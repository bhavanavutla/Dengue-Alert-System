package com.example.pages;

import com.google.firebase.database.FirebaseDatabase;

public class Location {
    private String location;

    public Location() {
    }

    public Location(String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}

/*

public class Location {
    private String n;
    private String m;
    private String p;
    public Location() {
    }

    public String getN() {
        return n;
    }

    public void setN(String n) {
        this.n = n;
    }

    public String getM() {
        return m;
    }

    public void setM(String m) {
        this.m = m;
    }

    public String getP() {
        return p;
    }

    public void setP(String p) {
        this.p = p;
    }
}
*/