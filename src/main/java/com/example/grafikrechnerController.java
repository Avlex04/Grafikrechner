package com.example;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;


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
    @FXML
    private Label outputachsensym;
    @FXML
    private Label outputpunktnsym;
    @FXML
    private  Canvas canvas;


    public void initialize() {

        // Access the text fields and do something with them
        String text1 = hoch5.getText();
        String text2 = hoch4.getText();
        String text3 = hoch3.getText();
        String text4 = hoch2.getText();
        String text5 = hoch1.getText();
        String text6 = hoch0.getText();
        intercept();

        if (text1.matches("-?\\d+(\\.\\d+)?") && text2.matches("-?\\d+(\\.\\d+)?") && text3.matches("-?\\d+(\\.\\d+)?") && text4.matches("-?\\d+(\\.\\d+)?") && text5.matches("-?\\d+(\\.\\d+)?") && text6.matches("-?\\d+(\\.\\d+)?")) {

            //outputLabel.setText(text1 + "x^5" + " + " + text2 + "x^4" + " + " + text3 + "x^3" + " + " + text4 + "x^2" + " + " + text5 + "x" + " + " + text6);
            System.out.println("text1 + \"x^5\" + \" + \" + text2 + \"x^4\" + \" + \" + text3 + \"x^3\" + \" + \" + text4 + \"x^2\" + \" + \" + text5 + \"x\" + \" + \" + text6");
        } else {
            // Display an error message on the label
            //outputLabel.setText("Bitte in jedes Feld Nummern eingeben");
            System.out.println("test2");
        }
    }
    public void intercept() {
        GraphicsContext gc = canvas.getGraphicsContext2D();

        gc.setStroke(Color.BLACK);
        gc.setLineWidth(1);
        gc.strokeLine(0, 155, 710, 155);

        // Draw the Y-axis
        gc.strokeLine(355, 350, 355, 0);
    }
}