package com.matrizaev.shape.repository;

import com.matrizaev.shape.entity.Cube;
import com.matrizaev.shape.specification.Specification;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CubeRepositoryImpl implements CubeRepository<Cube> {

    private List<Cube> cubeList = new ArrayList<>();

    private static CubeRepositoryImpl instance = new CubeRepositoryImpl();

    private CubeRepositoryImpl() {
    }

    public static CubeRepositoryImpl getInstance() {
        return instance;
    }

    @Override
    public void add(Cube cube) {
        cubeList.add(cube);
    }

    @Override
    public void update(Cube cube) {
        cubeList.removeIf(cube1 -> cube1.getCubeId() == cube.getCubeId());
        cubeList.add(cube);
    }

    @Override
    public void remove(Cube cube) {
        cubeList.remove(cube);
    }

    @Override
    public List<Cube> query(Specification specification) {
        List<Cube> result = new ArrayList<>();
        for (Cube cube : cubeList) {
            if (specification.specified(cube)) {
                result.add(cube);
            }
        }
        return result;
    }

    public List<Cube> sortCubesById() {
        List<Cube> result = new ArrayList<>(cubeList);
        result.sort(Comparator.comparingInt(Cube::getCubeId));
        return result;
    }

    public List<Cube> sortCubesByName() {
        List<Cube> result = new ArrayList<>(cubeList);
        result.sort(Comparator.comparing(Cube::getCubeName));
        return result;
    }

    public List<Cube> sortCubesBySideLength() {
        List<Cube> result = new ArrayList<>(cubeList);
        result.sort(Comparator.comparingDouble(Cube::getSideLength));
        return result;
    }

    public List<Cube> sortCubesByCenterX() {
        List<Cube> result = new ArrayList<>(cubeList);
        result.sort(Comparator.comparingDouble(Cube::getCenterX));
        return result;
    }

    public List<Cube> sortCubesByCenterY() {
        List<Cube> result = new ArrayList<>(cubeList);
        result.sort(Comparator.comparingDouble(Cube::getCenterY));
        return result;
    }

    public List<Cube> sortCubesByCenterZ() {
        List<Cube> result = new ArrayList<>(cubeList);
        result.sort(Comparator.comparingDouble(Cube::getCenterZ));
        return result;
    }
}
