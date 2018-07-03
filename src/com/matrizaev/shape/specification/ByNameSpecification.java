package com.matrizaev.shape.specification;

import com.matrizaev.shape.entity.Cube;

public class ByNameSpecification implements Specification {

    private String name;

    public ByNameSpecification(String name) {
        this.name = name;
    }

    @Override
    public boolean specified(Cube cube) {
        return cube.getCubeName().equals(name);
    }
}
