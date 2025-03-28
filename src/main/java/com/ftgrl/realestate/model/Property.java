package com.ftgrl.realestate.model;

public abstract class Property {
    private final double price;
    private final double squareMeters;
    private final int rooms;
    private final int livingRooms;

    public Property(double price, double squareMeters, int rooms, int livingRooms) {
        this.price = price;
        this.squareMeters = squareMeters;
        this.rooms = rooms;
        this.livingRooms = livingRooms;
    }

    public double getPrice() {
        return price;
    }

    public double getSquareMeters() {
        return squareMeters;
    }

    public int getRooms() {
        return rooms;
    }

    public int getLivingRooms() {
        return livingRooms;
    }
}
