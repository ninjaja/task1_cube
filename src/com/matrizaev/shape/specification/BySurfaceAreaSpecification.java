package com.matrizaev.shape.specification;

import com.matrizaev.shape.action.CubeAction;
import com.matrizaev.shape.entity.Cube;

public class BySurfaceAreaSpecification implements Specification {

    double minArea;
    double maxArea;

    public BySurfaceAreaSpecification(double minArea, double maxArea) {
        this.minArea = minArea;
        this.maxArea = maxArea;
    }

    @Override
    public boolean specified(Cube cube) {
        return minArea < CubeAction.calcCubeSurfaceArea(cube) && CubeAction.calcCubeSurfaceArea(cube) < maxArea;
    }
}
