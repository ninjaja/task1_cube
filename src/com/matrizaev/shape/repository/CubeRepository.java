package com.matrizaev.shape.repository;

import com.matrizaev.shape.specification.Specification;

import java.util.Comparator;
import java.util.List;

public interface CubeRepository<T> {

    void add(T cube);

    void remove(T cube);

    void update(T cube);

    List<T> query(Specification specification);

}
