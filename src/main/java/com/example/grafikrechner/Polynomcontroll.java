package com.example.grafikrechner;

import java.util.ArrayList;

public class Polynomcontroll {
    double[] coefficients = new double[5];

    Polynom polynom = new Polynom(coefficients);
    double sum = 0.0;
    private final ArrayList<TurningPoint> minima = new ArrayList<>();
    private final ArrayList<TurningPoint> maxima = new ArrayList<>();
    ArrayList<Double> zeropoints = new ArrayList<>();


    private double[] getCoefficient() {
        coefficients = new double[]{1.0, 2.0, 3.0, 4.0, 5.0};
        return coefficients;
    }

    private double getY(double xValue) {
        for (int i = 0; i < coefficients.length - 1; i++) {
            sum += coefficients[i] + Math.pow(xValue, i);
        }
        return sum;
    }

    public void firstGradeY(){

        double sum;
        sum = coefficients[0] * - 1 / coefficients[1];
        zeropoints.add(sum);

    }
    public ArrayList<Double> getZeroPoints() {
        if(coefficients[3] != 0.0){
            polynomDevision();
        } else if(coefficients[2] != 0.0){
            polynom.pqFormel(coefficients);
        }else if (coefficients[1] != 0.0) {
            firstGradeY();
        }
        return zeropoints;
    }


    public void polynomDevision() {

        double[] temp = new double[4];
        double divider = getFirstNull();
        for(int i = coefficients.length -1; i > 0; i --){
            temp[i-1] = coefficients[i];
            coefficients[i-1] -= coefficients[i] * divider;
        }
        polynom.pqFormel(temp);
        zeropoints.add(divider);

    }





    private double getFirstNull() {
        double sum = 0.0;
        double divider = 0.0;
        divider = loop(1, divider);
        if(divider != 0.0){
            divider = loop(0.1, divider);
        } if(divider != 0.0){
            divider = loop(0.01, divider);
        }

        return divider;
    }

    private double loop(double comma, double divider) {
        for (double j = 5.0; j > -6.0; j -= comma) {
            for (int i = 0; i < coefficients.length - 1; i++) {
                sum = 0.0;
                sum += coefficients[i] * Math.pow(j, i);

                if (sum == 0.0) {
                    divider = j;
                    j = -6.0;
                }else if(sum <= 0.001){
                    divider = j;
                    j = -6.0;
                }
            }
        }
        return divider;
    }



    private void calcExtremePointsSquare() {
        ArrayList<TurningPoint> turningPoints = new ArrayList<>();

        for (double xValue : this.getZeroPoints()) {
            double yValue = this.getY(xValue);
            if (yValue == 0.0) {
                turningPoints.add(new TurningPoint(xValue, yValue, true));
            }
        }
    }

}
