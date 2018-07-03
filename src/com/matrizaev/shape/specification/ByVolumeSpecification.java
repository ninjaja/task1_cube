package com.matrizaev.shape.specification;

import com.matrizaev.shape.action.CubeAction;
import com.matrizaev.shape.entity.Cube;

public class ByVolumeSpecification implements Specification {

    double minVolume;
    double maxVolume;

    public ByVolumeSpecification(double minVolume, double maxVolume) {
        this.minVolume = minVolume;
        this.maxVolume = maxVolume;
    }

    @Override
    public boolean specified(Cube cube) {
        return minVolume < CubeAction.calcCubeVolume(cube) && CubeAction.calcCubeVolume(cube) < maxVolume;
    }
}
