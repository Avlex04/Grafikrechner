package com.example;
import com.example.grafikrechner.Polynom;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class grafikrechnerController {
    @FXML
    private TextField hoch5;
    @FXML
    private TextField hoch4;
    @FXML
    private TextField hoch3;
    @FXML
    private TextField hoch2;
    @FXML
    private TextField hoch1;
    @FXML
    private TextField hoch0;
    @FXML
    private Label outputLabel;
    Canvas drawArea = new Canvas(700, 420);
    Polynom polynomial;

    private void drawPolynomial(double scale) {
        drawArea.getGraphicsContext2D().setStroke(Color.BLACK);
        drawArea.getGraphicsContext2D().setLineWidth(1); // make one pixel of screen width
        // scales work as follows: a scale of 2 means 2x zoom and a scale .1 means 10% zoom
        double step = (drawArea.getWidth() / scale) / drawArea.getWidth();
        double lastPointX = drawArea.getWidth() / scale;

        for (double i = 0; i < lastPointX; i += step) {
            double yCoordinate = this.polynomial.calculateY(i);
            drawArea.getGraphicsContext2D().strokeLine(i, yCoordinate, i, yCoordinate);
        }
    }

    public void initialize() {

        // Access the text fields and do something with them
        String text1 = hoch5.getText();
        String text2 = hoch4.getText();
        String text3 = hoch3.getText();
        String text4 = hoch2.getText();
        String text5 = hoch1.getText();
        String text6 = hoch0.getText();

        if (text1.matches("-?\\d+(\\.\\d+)?") && text2.matches("-?\\d+(\\.\\d+)?") && text3.matches("-?\\d+(\\.\\d+)?") && text4.matches("-?\\d+(\\.\\d+)?") && text5.matches("-?\\d+(\\.\\d+)?") && text6.matches("-?\\d+(\\.\\d+)?")) {

            outputLabel.setText(text1 + "x^5" + " + " + text2 + "x^4"+ " + " + text3 + "x^3"+ " + " + text4 + "x^2"+ " + " + text5 + "x" + " + " + text6);
            System.out.println("test");
            polynomial = new Polynom(new double[]{Double.parseDouble(text1), Double.parseDouble(text2),
                    Double.parseDouble(text3), Double.parseDouble(text4), Double.parseDouble(text5),
                            Double.parseDouble(text6)});
            drawPolynomial(1.0);
        } else {
            // Display an error message on the label
            outputLabel.setText("Bitte in jedes Feld Nummern eingeben");
            System.out.println("test2");
        }
    }
}