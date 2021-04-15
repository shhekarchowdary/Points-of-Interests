package com.arr.pointsofinterests;

public class PointOfInterest {
    private String country,name,description,imageName1,imageName2;

    public PointOfInterest(String country, String name, String description, String imageName1, String imageName2) {
        this.country = country;
        this.name = name;
        this.description = description;
        this.imageName1 = imageName1;
        this.imageName2 = imageName2;
    }

    public String getCountry() {
        return country;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getImageName1() {
        return imageName1;
    }

    public String getImageName2() {
        return imageName2;
    }
}
