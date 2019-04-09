package com.example.hp.mail.adapterclass;

import android.location.Location;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by HP on 6/26/2017.
 */

public class Adapter {
    //public static String str1;


    public String getDesp() {
        return desp;
    }

    public void setDesp(String desp) {
        this.desp = desp;
    }



    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    String desp;

    public String getSd() {
        return sd;
    }

    public void setSd(String sd) {
        this.sd = sd;
    }

    public String getEd() {
        return ed;
    }

    public void setEd(String ed) {
        this.ed = ed;
    }

    String sd;
    String ed;


    String Location;

    public Adapter(){}

    public Adapter(String desp, String sd, String ed, String location, String name, double latitude, double longitude, String url) {
        this.desp = desp;
        this.sd = sd;
        this.ed = ed;
        Location = location;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.url = url;
    }

    String name;
    double latitude,longitude;

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    String url;





}
