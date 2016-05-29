/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.visualisatie.opdracht2b;

import java.util.ArrayList;
import processing.core.PApplet;

/**
 *
 * @author Lars
 */
public class DataDrawer {

    private PApplet window;

    public DataDrawer(PApplet window) {
        this.window = window;

    }

    //String[] input is de 2 data die je wilt laten tekenen
    public void drawScatterGraph(int[] position, int[] dimension, ArrayList<int[]> data) {
        window.line(position[0], position[1], position[0] + dimension[1], position[1]);
        window.line(position[0], position[1], position[0], position[1] - dimension[0]);

        if (data != null) {
            for (int[] mappedData : data) {
                window.ellipse(mappedData[0], mappedData[1], 1, 1);
            }
        }
    }
}
