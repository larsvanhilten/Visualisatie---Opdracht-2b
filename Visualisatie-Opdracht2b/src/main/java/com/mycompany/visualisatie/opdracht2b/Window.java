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
public class Window extends PApplet {

    private DataDrawer dataDrawer;
    private DataCalculator dataCalculator;

    private ArrayList<DataModel> data;
    private ArrayList<ArrayList<Float>> dataLists;
    private ArrayList<ArrayList<int[]>> mappedData;

    public void setup() {
        size(500, 500);

        DataReader dr = new DataReader();
        dataCalculator = new DataCalculator(this);
        dataDrawer = new DataDrawer(this);

        try {
            data = dr.parser();
            dataLists = dataCalculator.ModelToLists(data);

            mappedData = new ArrayList();
            for (int i = 0; i < dataLists.size(); i++) {
                for (int j = 0; j < dataLists.size(); j++) {
                    if (i != j) {
                        int posY = 150;
                        switch (i) {
                            case 1:
                                posY = 250;
                                break;
                            case 2:
                                posY = 350;
                                break;
                            case 3:
                                posY = 450;
                                break;
                        }

                        mappedData.add(dataCalculator.mapData(dataLists.get(i), dataLists.get(j), new int[]{50 + (j * 100), posY}));
                    }

                }

            }

        } catch (IOException ex) {
            Logger.getLogger(Window.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Window.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void draw() {
        rect(50, 50, 400, 400);
        fill(0, 0, 0);
        textSize(28);
        text("Matrix of..", 200, 30);
        fill(255, 255, 255);

        for (int i = 0; i < 16; i++) {
            int posY = 150;
            int posX = i;

            if (i >= 12) {
                posY = 450;
                posX -= 12;
            } else if (i >= 8) {
                posY = 350;
                posX -= 8;
            } else if (i >= 4) {
                posY = 250;
                posX -= 4;
            }
            if (i > 11) {

                dataDrawer.drawScatterGraph(new int[]{50 + (posX * 100), posY}, new int[]{100, 100}, null);
            } else if (i != 0 || i != 5 || i != 10 || i != 15) {
                dataDrawer.drawScatterGraph(new int[]{50 + (posX * 100), posY}, new int[]{100, 100}, mappedData.get(i));
            }
        }
    }
}
