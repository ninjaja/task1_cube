package com.matrizaev.shape.specification;

import com.matrizaev.shape.entity.Cube;

public class ByIdSpecification implements Specification {

    private int id;

    public ByIdSpecification(int id) {
        this.id = id;
    }

    @Override
    public boolean specified(Cube cube) {
        return cube.getCubeId() == id;
    }
}
