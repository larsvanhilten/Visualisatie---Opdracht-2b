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

    public void setup() {
        size(800, 500);

        dataDrawer = new DataDrawer(this);

    }

    public void draw() {
        dataDrawer.drawScatterGraph(new int[] {200,300}, 100, 100, new String[] {"Analyse", "Development"});

    }
}
