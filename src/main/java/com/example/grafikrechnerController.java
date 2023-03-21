package com.example;
import com.example.grafikrechner.Polynom;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
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
    Polynom polynomial;

    @FXML
    private Canvas canvas;

   /* private void drawPolynomial(double scale) {
        drawArea.getGraphicsContext2D().setStroke(Color.BLACK);
        drawArea.getGraphicsContext2D().setLineWidth(5); // make one pixel of screen width
        // scales work as follows: a scale of 2 means 2x zoom and a scale .1 means 10% zoom
        double step = (drawArea.getWidth() / scale) / drawArea.getWidth();
        double lastPointX = drawArea.getWidth() / scale;
        drawArea.getGraphicsContext2D().strokeLine(350, 210, 370, 240);

        for (double i = 0; i < lastPointX; i += step) {
            double yCoordinate = this.polynomial.calculateY(i);
            drawArea.getGraphicsContext2D().strokeLine(i, yCoordinate, i, yCoordinate);

        }
    } */

    private void drawPolynomial(Polynom methodPolynomial, double scale) {
        // get the graphics context of the canvas to draw on it
        GraphicsContext gc = canvas.getGraphicsContext2D();
        // set the color of the lines
        gc.setStroke(Color.BLACK);
        // set the width of the lines
        gc.setLineWidth(1.0);

        // the starting point of the function is in the lower left (or third) quadrant
        // of the cartesian coordinate system. (values are converted later for canvas)
        double previousX = -canvas.getWidth() / 2 / scale  ;
        double previousY = methodPolynomial.calculateY(previousX);
        System.out.println(previousX);
        System.out.println(previousY);
        // get the screen width, divide it by the scale (bigger scale is smaller, smaller scale is bigger)
        // also, don't forget to divide by the width to get only one pixel (we don't want the entire width)
        double lineDistance = (canvas.getWidth() / scale) / canvas.getWidth();

        // go from the very left to the very right of the canvas, all the while plugging in the x values
        // and getting y values.
        for (double currentX = previousX; currentX < canvas.getWidth() / 2 / scale; currentX += lineDistance) {
            double currentY = methodPolynomial.calculateY(currentX);
            // adapt the calculated point to make it canvas-friendly and stroke a line using it.
            gc.strokeLine(
                    ((previousX + canvas.getWidth()) / 2) * scale,
                    ((canvas.getHeight() - previousY) / 2) * scale,
                    ((currentX + canvas.getWidth()) / 2) * scale,
                    ((canvas.getHeight() - currentY) / 2) * scale
            );
            previousX = currentX;
            previousY = currentY;
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
            drawPolynomial(polynomial, canvas.getWidth() / 10);
        } else {
            // Display an error message on the label
            outputLabel.setText("Bitte in jedes Feld Nummern eingeben");
            System.out.println("test2");
        }
    }
}