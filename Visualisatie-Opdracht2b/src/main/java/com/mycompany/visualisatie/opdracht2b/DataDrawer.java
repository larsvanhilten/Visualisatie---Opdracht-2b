/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.visualisatie.opdracht2b;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import processing.core.PApplet;

/**
 *
 * @author Lars
 */
public class DataDrawer {

    private PApplet window;
    private ArrayList<DataModel> data;

    public DataDrawer(PApplet window) {
        this.window = window;
        DataReader dr = new DataReader();
        try {
            data = dr.parser();
        } catch (IOException ex) {
            Logger.getLogger(Window.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Window.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //String[] input is de 2 data die je wilt laten tekenen
    public void drawScatterGraph(int[] position, int length, int width, String[] input) {
        window.line(position[0], position[1], position[0] + width, position[1]);
        window.line(position[0], position[1], position[0], position[1] - length);

        for (DataModel model : data) {
            float dataOne = 0;
            float dataTwo = 0;
            switch (input[0]) {
                case "Analyse":
                    dataOne = model.getAnalyse();
                    break;
                case "Development":
                    dataOne = model.getDevelopment();
                    break;
                case "Project":
                    dataOne = model.getProject();
                    break;
                case "Skills":
                    dataOne = model.getSkills();
                    break;
            }

            switch (input[1]) {
                case "Analyse":
                    dataTwo = model.getAnalyse();
                    break;
                case "Development":
                    dataTwo = model.getDevelopment();
                    break;
                case "Project":
                    dataTwo = model.getProject();
                    break;
                case "Skills":
                    dataTwo = model.getSkills();
                    break;
            }

            window.ellipse(dataOne, dataTwo, 1, 1);

        }

    }
}
