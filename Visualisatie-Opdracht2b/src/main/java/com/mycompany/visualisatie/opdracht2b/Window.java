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
    
    private float x1, x2, x3;
    private float y1, y2, y3;
    private float z1, z2, z3;
    private float xy1, xy2, xy3;
    

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
        textSize(15);
        text("Matrix of analyse, development, skills, project", 85, 25);
        fill(255, 255, 255);
        System.out.println(mouseX + " " + mouseY);
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
drawAxis();
        
    }
    public void drawAxis(){
        textSize(10);
        fill(0);
        text("10", 35, 160);
        text("5", 38, 205);
        text("0", 38, 250);
        
        text("10", 35, 360);
        text("5", 38, 405);
        text("0", 38, 450);
        
        text("0", 52, 465);
        text("5", 97, 465);
        text("10", 132, 465);
        
        text("0", 455, 350);
        text("5", 455, 305);
        text("10", 455, 265);
        
        text("0", 250, 465);
        text("5", 295, 465);
        text("10", 340, 465);
        
        text("0", 455, 150);
        text("5", 455, 105);
        text("10", 455, 60);
        
        text("0", 350, 45);
        text("5", 395, 45);
        text("10", 440, 45);
        
        text("0", 150, 45);
        text("5", 195, 45);
        text("10", 240, 45);
        
        text("Analyse", 85, 105);
        text("Development", 170, 205);  
        text("Skills", 285, 305);  
        text("Project", 385, 405);  
        fill(255,255,255);
    }   
}
