package com.tolet.sajib.retrofitgetparttwo.modelclass;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ModelTwo {
    @SerializedName("kitchen_id")
    @Expose
    private Integer kitchenId;
    @SerializedName("kitchen_name")
    @Expose
    private String kitchenName;
    @SerializedName("kitchen_image")
    @Expose
    private String kitchenImage;
    @SerializedName("det_address")
    @Expose
    private String detAddress;
    @SerializedName("area_name")
    @Expose
    private String areaName;
    @SerializedName("cuisine")
    @Expose
    private String cuisine;
    @SerializedName("owener_info")
    @Expose
    private String owenerInfo;
    @SerializedName("location_lang")
    @Expose
    private Float locationLang;
    @SerializedName("location_lat")
    @Expose
    private Float locationLat;
    @SerializedName("slogan")
    @Expose
    private String slogan;
    @SerializedName("open_hour")
    @Expose
    private String openHour;
    @SerializedName("closing_hour")
    @Expose
    private String closingHour;
    @SerializedName("rating")
    @Expose
    private Float rating;
    @SerializedName("kitchen_status")
    @Expose
    private Integer kitchenStatus;
    @SerializedName("kitchen_vat")
    @Expose
    private Integer kitchenVat;

    public Integer getKitchenId() {
        return kitchenId;
    }

    public void setKitchenId(Integer kitchenId) {
        this.kitchenId = kitchenId;
    }

    public String getKitchenName() {
        return kitchenName;
    }

    public void setKitchenName(String kitchenName) {
        this.kitchenName = kitchenName;
    }

    public String getKitchenImage() {
        return kitchenImage;
    }

    public void setKitchenImage(String kitchenImage) {
        this.kitchenImage = kitchenImage;
    }

    public String getDetAddress() {
        return detAddress;
    }

    public void setDetAddress(String detAddress) {
        this.detAddress = detAddress;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public String getOwenerInfo() {
        return owenerInfo;
    }

    public void setOwenerInfo(String owenerInfo) {
        this.owenerInfo = owenerInfo;
    }

    public Float getLocationLang() {
        return locationLang;
    }

    public void setLocationLang(Float locationLang) {
        this.locationLang = locationLang;
    }

    public Float getLocationLat() {
        return locationLat;
    }

    public void setLocationLat(Float locationLat) {
        this.locationLat = locationLat;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public String getOpenHour() {
        return openHour;
    }

    public void setOpenHour(String openHour) {
        this.openHour = openHour;
    }

    public String getClosingHour() {
        return closingHour;
    }

    public void setClosingHour(String closingHour) {
        this.closingHour = closingHour;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public Integer getKitchenStatus() {
        return kitchenStatus;
    }

    public void setKitchenStatus(Integer kitchenStatus) {
        this.kitchenStatus = kitchenStatus;
    }

    public Integer getKitchenVat() {
        return kitchenVat;
    }

    public void setKitchenVat(Integer kitchenVat) {
        this.kitchenVat = kitchenVat;
    }
}
