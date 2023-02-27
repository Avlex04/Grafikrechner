package com.example.grafikrechner;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.util.ArrayList;

    public class HelloController {
    double[] coefficients = new double[5];
    double x;
    double sum = 0.0;
    ArrayList<Double> zeropoints = new ArrayList<>();


    private double[] getCoefficient() {
        coefficients = new double[]{1, 1, 1, 1, 1};
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
        if(coefficients[2] < 0.0){
            pqFormel();
        }else if (coefficients[1] < 0.0) {
            firstGradeY();
        }
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
}