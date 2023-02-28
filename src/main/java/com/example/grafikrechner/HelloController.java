package com.example.grafikrechner;

import extra.TurningPoint;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.lang.reflect.Array;
import java.util.ArrayList;

    public class HelloController {
    double[] coefficients = new double[5];
    double x;
    double sum = 0.0;
    ArrayList<Double> zeropoints = new ArrayList<>();


    private double[] getCoefficient() {
        coefficients = new double[]{1, 2, 3, 4, 5};
        return coefficients;
    }

    private double getY() {
        for (int i = 0; i < coefficients.length - 1; i++) {
            sum += coefficients[i] + Math.pow(x, i);
        }
        return sum;
    }

        public void firstGradeY(){

            double sum;
            sum = coefficients[0] * - 1 / coefficients[1];
            zeropoints.add(sum);

        }

    private ArrayList<Double> getzeroPoints() {
        if(coefficients[3] != 0.0){
            polynomDevision();
        }
        if(coefficients[2] != 0.0){
            pqFormel();
        }else if (coefficients[1] != 0.0) {
            firstGradeY();
        }
        return zeropoints;
    }


    //überarbeitung nötig für das einsetzen der Pq-formel
    public ArrayList<Double> polynomDevision() {
        double[] temp = new double[4];
        double devider = 1;
        for(int i = coefficients.length -1; i > 0; i --){
            temp[i-1] = coefficients[i];
            coefficients[i-1] -= coefficients[i] * devider;
        }
        double x1;
        double x2;
        double p = temp[1];
        double q = temp[0];
        if (temp[2] < 0) {
            p = p / -1;
            q = q / -1;

            p = p / coefficients[2];
            q = q / coefficients[2];

            double sqrtinput = Math.pow((p / 2), 2) - q;
            if (!(sqrtinput < 0)) {
                double formel = Math.sqrt(sqrtinput);
                x1 = -(p / 2) - formel;
                x2 = -(p / 2) + formel;
                zeropoints.add(x1);
                zeropoints.add(x2);
            }
        }
        zeropoints.add(devider);

        return zeropoints;
    }



        public ArrayList<Double> pqFormel() {
            double[] temp = coefficients;
            double x1;
            double x2;
            double p = coefficients[1];
            double q = coefficients[0];

            if (temp[2] < 0) {
                p = p / -1;
                q = q / -1;

                p = p / coefficients[2];
                q = q / coefficients[2];

                double sqrtinput = Math.pow((p / 2), 2) - q;
                if (!(sqrtinput < 0)) {
                    double formel = Math.sqrt(sqrtinput);
                    x1 = -(p / 2) - formel;
                    x2 = -(p / 2) + formel;
                    zeropoints.add(x1);
                    zeropoints.add(x2);
                }
            }
            return zeropoints;
        }


        private ArrayList<TurningPoint> calcExtremePoints() {
        ArrayList<TurningPoint> turningPoints = new ArrayList<>();

        return turningPoints;
        }
}