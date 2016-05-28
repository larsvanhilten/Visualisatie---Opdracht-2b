/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.visualisatie.opdracht2b;

import java.util.ArrayList;
import processing.core.PApplet;
import static processing.core.PApplet.map;

/**
 *
 * @author Lars
 */
public class DataCalculator {

    private PApplet window;

    public DataCalculator(PApplet window) {
        this.window = window;
    }

    public ArrayList<ArrayList<Float>> ModelToLists(ArrayList<DataModel> data) {
        ArrayList<ArrayList<Float>> mappedData = new ArrayList();

        ArrayList<Float> analyse = new ArrayList();
        ArrayList<Float> development = new ArrayList();
        ArrayList<Float> project = new ArrayList();
        ArrayList<Float> skills = new ArrayList();

        for (DataModel model : data) {
            
            analyse.add(model.getAnalyse());
            development.add(model.getDevelopment());
            project.add(model.getProject());
            skills.add(model.getSkills());

        }
        
        mappedData.add(analyse);
        mappedData.add(development);
        mappedData.add(project);
        mappedData.add(skills);

        return mappedData;
    }

    public ArrayList<int[]> mapData(ArrayList<Float> dataOne, ArrayList<Float> dataTwo, int[] position) {
        ArrayList<int[]> mappedData = new ArrayList();

        float[] minMaxOne = getMinMax(dataOne);
        float[] minMaxTwo = getMinMax(dataTwo);

        for (int i = 0; i < dataOne.size(); i++) {
            int[] mapping = {0,0};
            mapping[0] = (int) map(dataOne.get(i), minMaxOne[0], minMaxOne[1], position[0] + 100, position[0]);
            mapping[1] = (int) map(dataTwo.get(i), minMaxTwo[0], minMaxTwo[1], position[1], position[1] - 100);

            mappedData.add(mapping);
        }

        return mappedData;

    }

    public float[] getMinMax(ArrayList<Float> data) {
        float min = data.get(0);
        float max = data.get(0);

        for (float i : data) {
            if (i < min) {
                min = i;
            }
            if (i > max) {
                max = i;
            }
        }

        float[] minMax = {min, max};

        return minMax;
    }
}
