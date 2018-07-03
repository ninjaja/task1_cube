package com.matrizaev.shape.action;

import com.matrizaev.shape.entity.Cube;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CubeAction {

    private static final Logger LOGGER = LogManager.getLogger();

    public static double calcCubeSurfaceArea(Cube cube) { // method defines cube's surface area
        double result = 6 * Math.pow(cube.getSideLength(), 2);
        return result;
    }

    public static double calcCubeVolume(Cube cube) { // method defines volume of a cube
        double result = Math.pow(cube.getSideLength(), 3);
        return result;
    }

    public static Double calcProportionXY(Cube cube) {
        double result = 0;

        if (Math.abs(cube.getCenter().getZ()) < cube.getSideLength() / 2) {
            double largerPartOfSide = Math.abs(cube.getCenter().getZ()) + cube.getSideLength() / 2;
            double largerPartVol = largerPartOfSide * Math.pow(cube.getSideLength(), 2);
            double smallerPartOfSide = cube.getSideLength() - largerPartOfSide;
            double smallerPartVol = smallerPartOfSide * Math.pow(cube.getSideLength(), 2);
            result = largerPartVol/smallerPartVol;
        } else {
            LOGGER.log(Level.INFO, "The cube has no crossings with XY-plane");
        }
        LOGGER.log(Level.INFO, "Proportion by crossing with XY-plane is: " + result);
        return result;
    }

    public static Double calcProportionXZ(Cube cube) {
        double result = 0;

        if (Math.abs(cube.getCenter().getY()) < cube.getSideLength() / 2) {
            double largerPartOfSide = Math.abs(cube.getCenter().getY()) + cube.getSideLength() / 2;
            double largerPartVol = largerPartOfSide * Math.pow(cube.getSideLength(), 2);
            double smallerPartOfSide = cube.getSideLength() - largerPartOfSide;
            double smallerPartVol = smallerPartOfSide * Math.pow(cube.getSideLength(), 2);
            result = largerPartVol/smallerPartVol;
        } else {
            LOGGER.log(Level.INFO, "The cube has no crossings with XZ-plane");
        }
        LOGGER.log(Level.INFO, "Proportion by crossing with XZ-plane is: " + result);
        return result;
    }

    public static Double calcProportionYZ(Cube cube) {
        double result = 0;

        if (Math.abs(cube.getCenter().getX()) < cube.getSideLength() / 2) {
            double largerPartOfSide = Math.abs(cube.getCenter().getX()) + cube.getSideLength() / 2;
            double largerPartVol = largerPartOfSide * Math.pow(cube.getSideLength(), 2);
            double smallerPartOfSide = cube.getSideLength() - largerPartOfSide;
            double smallerPartVol = smallerPartOfSide * Math.pow(cube.getSideLength(), 2);
            result = largerPartVol/smallerPartVol;
        } else {
            LOGGER.log(Level.INFO, "The cube has no crossings with YZ-plane");
        }
        LOGGER.log(Level.INFO, "Proportion by crossing with YZ-plane is: " + result);
        return result;
    }

    public static String tangencyToPlanes(Cube cube) {
        StringBuilder result = new StringBuilder("The cube is tangent to plane(s): ");
        boolean xy = Math.abs(cube.getCenter().getZ()) - cube.getSideLength() / 2 == 0;
        boolean xz = Math.abs(cube.getCenter().getY()) - cube.getSideLength() / 2 == 0;
        boolean yz = Math.abs(cube.getCenter().getX()) - cube.getSideLength() / 2 == 0;
        if (xy) {
            result.append("XY ");
        }
        if (xz) {
            result.append("XZ ");
        }
        if (yz) {
            result.append("YZ ");
        } if (!xy && !xz && !yz) {
            result.append("to none of the planes");
        }
        LOGGER.log(Level.INFO, result.toString());
        return result.toString();
    }

    public static boolean positiveCoordinates(Cube cube) { //method checks if all of the cube's coordinates are positive
        double x = cube.getCenter().getX();
        double y = cube.getCenter().getY();
        double z = cube.getCenter().getZ();
        double halfSideLength = cube.getSideLength()/2;
        return x > 0 && y > 0 && z > 0 && halfSideLength < x && halfSideLength < y && halfSideLength < z;
    }

    public static boolean negativeCoordinates(Cube cube) { //method checks if all of the cube's coordinates are negative
        double x = cube.getCenter().getX();
        double y = cube.getCenter().getY();
        double z = cube.getCenter().getZ();
        double xAbs = Math.abs(cube.getCenter().getX());
        double yAbs = Math.abs(cube.getCenter().getY());
        double zAbs = Math.abs(cube.getCenter().getZ());
        double halfSideLength = cube.getSideLength()/2;
        return x < 0 && y < 0 && z < 0 && halfSideLength < xAbs && halfSideLength < yAbs && halfSideLength < zAbs;
    }
}
