package com.example.hp.maps.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GarduInduk {

    @SerializedName("id")
    public Integer id;
    @SerializedName("nama_gi")
    public String namaGi;
    @SerializedName("longitude")
    public Double longitude;
    @SerializedName("latitude")
    public Double latitude;
    @SerializedName("alamat")
    public String alamat;

    public GarduInduk(Integer id, String namaGi, String longitude, String latitude, String alamat) {
        this.id = id;
        this.namaGi = namaGi;
        this.longitude = Double.parseDouble(longitude);
        this.latitude = Double.parseDouble(latitude);
        this.alamat = alamat;
    }
}
