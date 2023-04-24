package com.example;
import com.example.grafikrechner.Polynom;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.function.Function;

public class grafikrechnerController {
    public Label symmetry;
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
    @FXML
    private Canvas canvas;

    Polynom polynomial;

    private int Scale = 5; // Default Scale

    ArrayList<Polynom> polynomials = new ArrayList<>();
    private void drawPolynomial(Polynom methodPolynomial, Integer Scale) {

        // get the graphics context of the canvas to draw on it
        GraphicsContext gc = canvas.getGraphicsContext2D();

        // set the color of the lines
        gc.setStroke(Color.BLACK);
        // set the width of the lines
        gc.setLineWidth(1.0);

        // Scaling
        double xMin = -Scale;
        double xMax = Scale;
        double yMin = -Scale;
        double yMax = Scale;
        double xScale = canvas.getWidth() / (xMax - xMin);
        double yScale = canvas.getHeight() / (yMax - yMin);

        gc.setStroke(Color.BLACK);
        gc.setLineWidth(1);

        // Drawing Polynom on canvas
        for (double x = xMin; x < xMax; x += 0.1) {

            double y = polynomial.calculateY(x);
            double xPixel = (x - xMin) * xScale;
            double yPixel = canvas.getHeight() - (y - yMin) * yScale;
            gc.strokeLine(xPixel, yPixel, (x + 0.1 - xMin) * xScale,
                    canvas.getHeight() - (polynomial.calculateY(x + 0.1) - yMin) * yScale);
        }
        for (Polynom i : polynomials) {
            for (double x = xMin; x < xMax; x += 0.1) {

                double y = i.calculateY(x);
                double xPixel = (x - xMin) * xScale;
                double yPixel = canvas.getHeight() - (y - yMin) * yScale;
                gc.strokeLine(xPixel, yPixel, (x + 0.1 - xMin) * xScale,
                        canvas.getHeight() - (i.calculateY(x + 0.1) - yMin) * yScale);
            }

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
        intercept();
        System.out.println(polynomials);
        if (text1.matches("-?\\d+(\\.\\d+)?") && text2.matches("-?\\d+(\\.\\d+)?") && text3.matches("-?\\d+(\\.\\d+)?") && text4.matches("-?\\d+(\\.\\d+)?") && text5.matches("-?\\d+(\\.\\d+)?") && text6.matches("-?\\d+(\\.\\d+)?")) {


            polynomial = new Polynom(new double[]{Double.parseDouble(text1), Double.parseDouble(text2),
                    Double.parseDouble(text3), Double.parseDouble(text4), Double.parseDouble(text5),
                    Double.parseDouble(text6)});

            drawPolynomial(polynomial, Scale);
            if(polynomial.getPointSymmetry()){
                symmetry.setText("Symmetrie: Punksymmetrisch");
            }
            if(polynomial.getAxisSymmetry()){
                symmetry.setText("Symmetrie: Achsensymmetrisch");
            }
            if(!polynomial.getAxisSymmetry() && !polynomial.getPointSymmetry()){
                symmetry.setText("Symmetrie: Keine");
            }

            if (!polynomials.contains(polynomial)){
                polynomials.add(polynomial);
        }

        } else {
            // Display an error message on the label
            outputLabel.setText("Bitte in jedes Feld Nummern eingeben");
            System.out.println("test2");
        }
    }
    public void intercept() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());


        gc.setStroke(Color.GREY);
        gc.setLineWidth(1);
        // Draw the X-axis (Made dynamic with canvas size) # Change done by Michael
        gc.strokeLine(-canvas.getWidth(), canvas.getHeight()/2, canvas.getWidth(), canvas.getHeight()/2);

        // Draw the Y-axis (Made dynamic with canvas size) # Change done by Michael
        gc.strokeLine(canvas.getWidth()/2, -canvas.getHeight(), canvas.getWidth()/2, canvas.getHeight());
    }
    @FXML
    private void handleMenuItemAction(ActionEvent event) {
        MenuItem menuItem = (MenuItem) event.getSource();
        String text = menuItem.getText();

        Scale = Integer.parseInt(text);

        initialize();

    }

}
