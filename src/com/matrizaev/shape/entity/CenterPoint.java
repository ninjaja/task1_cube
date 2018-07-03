package com.matrizaev.shape.entity;

public class CenterPoint {

    private double x;
    private double y;
    private double z;

    public CenterPoint() {
    }

    public CenterPoint(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        CenterPoint CenterPoint = (CenterPoint) object;
        return Double.compare(CenterPoint.x, x) == 0 &&
                Double.compare(CenterPoint.y, y) == 0 &&
                Double.compare(CenterPoint.z, z) == 0;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Double.valueOf(x).hashCode();
        result = prime * result + Double.valueOf(y).hashCode();
        result = prime * result + Double.valueOf(z).hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "CenterPoint (x=" + x + ", y=" + y + ", z=" + z + ")";
    }
}

