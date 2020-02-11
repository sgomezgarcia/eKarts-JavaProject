package com.ekarts.dto;

import com.ekarts.enums.KartTypes;

import java.util.Objects;

public class Kart {
    private int id;
    private String name;
    private KartTypes type;
    private double pricePerMinute;

    public Kart(int id) {
        this.id = id;
    }

    public Kart(String name, KartTypes type, double pricePerMinute) {
        this.name = name;
        this.type = type;
        this.pricePerMinute = pricePerMinute;
    }

    public Kart(int id, String name, KartTypes type, double pricePerMinute) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.pricePerMinute = pricePerMinute;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public KartTypes getType() {
        return type;
    }

    public void setType(KartTypes type) {
        this.type = type;
    }

    public double getPricePerMinute() {
        return pricePerMinute;
    }

    public void setPricePerMinute(double pricePerMinute) {
        this.pricePerMinute = pricePerMinute;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Kart)) return false;
        Kart kart = (Kart) o;
        return id == kart.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Kart{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", pricePerMinute=" + pricePerMinute +
                '}';
    }
}
