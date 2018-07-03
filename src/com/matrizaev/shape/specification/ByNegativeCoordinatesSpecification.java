package com.matrizaev.shape.specification;

import com.matrizaev.shape.action.CubeAction;
import com.matrizaev.shape.entity.Cube;

public class ByNegativeCoordinatesSpecification implements Specification {

    @Override
    public boolean specified(Cube cube) {
        return CubeAction.negativeCoordinates(cube);
    }
}
