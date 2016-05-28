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
        size(800, 500);

        DataReader dr = new DataReader();
        dataCalculator = new DataCalculator(this);
        dataDrawer = new DataDrawer(this);
        
        try {
            data = dr.parser();
            dataLists = dataCalculator.ModelToLists(data);
            
            for (int i = 0; i < dataLists.size(); i ++) {
                for (int j = 0; i < dataLists.size(); j++){
                    if(i != j){                       
                        mappedData.add(dataCalculator.mapData(dataLists.get(i), dataLists.get(j), new int[]{100,100}));
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
        rect(50, 50, 900, 500);
        fill(0,0,0);
        textSize(28);
        text("Matrix of..", 450, 30);
        fill(255,255,255);
        rect(50, 50, 225, 100);
        
        for (ArrayList<int[]> mapping : mappedData) {
            dataDrawer.drawScatterGraph(new int[]{200, 300}, new int[]{100, 100}, mapping);
        }
    }

}
