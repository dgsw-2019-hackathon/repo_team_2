package com.example.a2019hack.data;

public class ChildProtect {

    private int childProtectPhoto;

    private String childProtectWeight;
    private String childProtectHeight;

    private String childProtectName;
    private String childProtectSex;
    private String childProtectPlace;
    private String childProtectAge;

    public ChildProtect(
            int childProtectPhoto, String childProtectName, String childProtectSex, String childProtectPlace,
            String childProtectAge, String childProtectHeight, String childProtectWeight) {

        this.childProtectPhoto = childProtectPhoto;
        this.childProtectName = childProtectName;
        this.childProtectSex = childProtectSex;
        this.childProtectAge = childProtectAge;
        this.childProtectPlace = childProtectPlace;
        this.childProtectHeight = childProtectHeight;
        this.childProtectWeight = childProtectWeight;
    }

    public int getChildProtectPhoto() {

        return childProtectPhoto;
    }

    public void setChildProtectPhoto(int childProtectPhoto) {

        this.childProtectPhoto = childProtectPhoto;
    }

    public String getChildProtectHeight() {

        return childProtectHeight;
    }

    public void setChildProtectHeight(String childProtectHeight) {

        this.childProtectHeight = childProtectHeight;
    }

    public String getChildProtectWeight() {

        return childProtectWeight;
    }

    public void setChildProtectWeight(String childProtectWeight) {

        this.childProtectWeight = childProtectWeight;
    }

    public String getChildProtectName() {

        return childProtectName;
    }

    public void setChildProtectName(String childProtectName) {

        this.childProtectName = childProtectName;
    }

    public String getChildProtectSex() {

        return childProtectSex;
    }

    public void setChildProtectSex(String childProtectSex) {

        this.childProtectSex = childProtectSex;
    }

    public String getChildProtectPlace() {

        return childProtectPlace;
    }

    public void setChildProtectPlace(String childProtectPlace) {

        this.childProtectPlace = childProtectPlace;
    }

    public String getChildProtectAge() {

        return childProtectAge;
    }

    public void setChildProtectAge(String childProtectAge) {

        this.childProtectAge = childProtectAge;
    }
}
