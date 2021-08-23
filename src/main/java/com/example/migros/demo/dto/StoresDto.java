package com.example.migros.demo.dto;

import java.util.Objects;

public class StoresDto {

    private String name;
    private Double lat;
    private Double lng;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StoresDto storesDto = (StoresDto) o;
        return name.equals(storesDto.name) && lat.equals(storesDto.lat) && lng.equals(storesDto.lng);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, lat, lng);
    }

    @Override
    public String toString() {
        return "Stores{" +
                "name='" + name + '\'' +
                ", lat=" + lat +
                ", lng=" + lng +
                '}';
    }
}
