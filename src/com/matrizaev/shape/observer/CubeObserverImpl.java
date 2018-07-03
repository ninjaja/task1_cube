package com.matrizaev.shape.observer;

import com.matrizaev.shape.action.CubeAction;
import com.matrizaev.shape.entity.Cube;
import com.matrizaev.shape.entity.CubeProperty;
import com.matrizaev.shape.register.CubePropertiesRegister;

public class CubeObserverImpl implements CubeObserver<Cube> {

    @Override
    public void update(Cube cube) {
        CubeProperty cubeProperty = new CubeProperty(CubeAction.calcCubeSurfaceArea(cube),
                CubeAction.calcCubeVolume(cube));
        CubePropertiesRegister.getInstance().putCubeToRegister(cube, cubeProperty);
    }

}
