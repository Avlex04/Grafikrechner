package com.example.grafikrechner;

public abstract class SpecialPoint {

    double xValue;
    double yValue;

    public SpecialPoint(double xValue, double yValue) {
        this.xValue = xValue;
        this.yValue = yValue;
    }

    public double getxValue() {
        return xValue;
    }

    public void setxValue(double xValue) {
        this.xValue = xValue;
    }

    public double getyValue() {
        return yValue;
    }

    public void setyValue(double yValue) {
        this.yValue = yValue;
    }
}