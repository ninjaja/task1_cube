package com.matrizaev.shape.entity;

public class CubeProperty {

    private double cubeSurfaceArea;
    private double cubeVolume;

    public CubeProperty(double cubeSurfaceArea, double cubeVolume) {
        this.cubeSurfaceArea = cubeSurfaceArea;
        this.cubeVolume = cubeVolume;
    }

    public double getCubeSurfaceArea() {
        return cubeSurfaceArea;
    }

    public double getCubeVolume() {
        return cubeVolume;
    }

}
