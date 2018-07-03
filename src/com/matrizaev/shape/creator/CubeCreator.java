package com.matrizaev.shape.creator;


import com.matrizaev.shape.entity.CenterPoint;
import com.matrizaev.shape.entity.Cube;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class CubeCreator {

    private static final Logger LOGGER = LogManager.getLogger();
    public List<Cube> createCubeList(List<Double> cubeDataList) {

        ArrayList<Cube> createdCubesList = new ArrayList<>();
        int count = 0;

        while (count < cubeDataList.size()) {
            CenterPoint CenterPoint = new CenterPoint();
            Cube cube = new Cube();
            CenterPoint.setX(cubeDataList.get(count));
            count++;
            CenterPoint.setY(cubeDataList.get(count));
            count++;
            CenterPoint.setZ(cubeDataList.get(count));
            cube.setCenter(CenterPoint);
            count++;
            cube.setSideLength(cubeDataList.get(count));
            if (count != 0) {                               //checking cubes for non-zero sideLength
                createdCubesList.add(cube);
            } else {
                LOGGER.log(Level.INFO, "Cube with zero-length side skipped");
            }
            count++;
        }
        return createdCubesList;
    }
}
