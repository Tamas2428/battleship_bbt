package com.matritellabs.utama.helper;
import java.util.*;

public abstract class Ship {
    private int hitPoints;
    private int size;
    private List<String> listOfCoordinates;

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<String> getListOfCoordinates() {
        return listOfCoordinates;
    }

    public void setListOfCoordinates(List<String> listOfCoordinates) {
        this.listOfCoordinates = listOfCoordinates;
    }
}
