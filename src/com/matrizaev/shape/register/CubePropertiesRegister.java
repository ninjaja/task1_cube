package com.matrizaev.shape.register;

import com.matrizaev.shape.entity.Cube;
import com.matrizaev.shape.entity.CubeProperty;
import java.util.HashMap;
import java.util.Map;

public class CubePropertiesRegister {

    private Map<Integer, CubeProperty> CubePropertiesMap = new HashMap<>();

    private static CubePropertiesRegister instance = new CubePropertiesRegister();

    private CubePropertiesRegister(){}

    public static CubePropertiesRegister getInstance() {
        return instance;
    }

    public void putCubeToRegister(Cube cube, CubeProperty cubeProperty) {
        CubePropertiesMap.put(cube.getCubeId(), cubeProperty);
    }


}