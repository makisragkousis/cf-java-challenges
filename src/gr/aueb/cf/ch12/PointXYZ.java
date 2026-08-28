package gr.aueb.cf.ch12;

import java.util.Scanner;

public class PointXYZ {
    private double x;
    private double y;
    private double z;

    public PointXYZ() {
    }

    public PointXYZ(double x, double y, double z) {
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

    public double getXYDistance() {
        return Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2));
    }

    public double getYZDistance() {
        return Math.sqrt(Math.pow(this.y, 2) + Math.pow(this.z, 2));
    }

    public double getXZDistance() {
        return Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.z, 2));
    }

    public double getXYZDistance() {
        return Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2) + Math.pow(this.z, 2));
    }
}
