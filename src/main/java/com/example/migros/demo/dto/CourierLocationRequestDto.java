package com.example.migros.demo.dto;

import lombok.NonNull;

public class CourierLocationRequestDto {

    @NonNull
    private Integer courierId;
    @NonNull
    private Double lat;

    @NonNull
    private Double lng;

    public Integer getCourierId() {
        return courierId;
    }

    public void setCourierId(Integer courierId) {
        this.courierId = courierId;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }
}
