package com.matrizaev.shape.entity;

import com.matrizaev.shape.generator.CubeIdGenerator;
import com.matrizaev.shape.observer.CubeObserver;

import java.util.ArrayList;
import java.util.List;

public class Cube {

    private int cubeId;
    private StringBuilder cubeName = new StringBuilder();
    private CenterPoint center;
    private double sideLength;

    private List<CubeObserver<Cube>> propertyCubeObserver = new ArrayList<>();

    public Cube (){}

    public Cube(CenterPoint center, double sideLength) {
        cubeId = CubeIdGenerator.generateId();
        cubeName.append("Cube").append(cubeId);
        this.center = center;
        this.sideLength = sideLength;
    }

    public int getCubeId() {
        return cubeId;
    }

    public String getCubeName() {
        return cubeName.toString();
    }

    public CenterPoint getCenter() {
        return center;
    }

    public double getCenterX() {return center.getX();}
    public double getCenterY() {return center.getY();}
    public double getCenterZ() {return center.getZ();}

    public void setCubeName(String newCubeName) {
        this.cubeName.replace(4, cubeName.length(), newCubeName);
        notifyObservers();
    }

    public void setCenter(CenterPoint center) {
        this.center = center;
        notifyObservers();
    }

    public double getSideLength() {
        return sideLength;
    }

    public void setSideLength(double sideLength) {
        this.sideLength = sideLength;
        notifyObservers();
    }

    public void attach(CubeObserver<Cube> cubeObserver) {
        propertyCubeObserver.add(cubeObserver);}
    public void detach(CubeObserver<Cube> cubeObserver) {
        propertyCubeObserver.remove(cubeObserver);}

    private void notifyObservers() {
        propertyCubeObserver.forEach(cubeObserver -> cubeObserver.update(this));}

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Cube cube = (Cube) object;
        if (sideLength != cube.sideLength) return false;
        return center != null ? center.equals(cube.center) : cube.center == null;
    }

    @Override
    public int hashCode() {

        final int prime = 31;
        int result = 1;
        result = prime * result + Double.valueOf(sideLength).hashCode();
        result = prime * result + (center != null ? center.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Cube (center coordinates: x=" + getCenterX() + ", y=" + getCenterY() + ", z=" + getCenterZ() + ", side length: " + getSideLength() + ")";
    }
}
