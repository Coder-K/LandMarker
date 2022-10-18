package com.example.landmarker;

public class Marks {

    private String Address;
    private String Description;
    private String Latitude;
    private String Longitude;
    private String Name;


    public Marks() {
    }

    public Marks(String address, String description, String latitude, String longitude, String name) {
        Address = address;
        Description = description;
        Latitude = latitude;
        Longitude = longitude;
        Name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }


    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getLatitude() {
        return Latitude;
    }

    public void setLatitude(String latitude) {
        Latitude = latitude;
    }

    public String getLongitude() {
        return Longitude;
    }

    public void setLongitude(String longitude) {
        Longitude = longitude;
    }
}
