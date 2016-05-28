/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.visualisatie.opdracht2b;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kevin
 */
public class DataReader {

    public String reader() throws FileNotFoundException, IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("studentcijfers.txt").getFile());
        BufferedReader br = new BufferedReader(new FileReader(file));
        StringBuilder sb = new StringBuilder();
        String line = br.readLine();

        while (line != null) {
            sb.append(line);
            sb.append(System.lineSeparator());
            line = br.readLine();
        }
        String data = sb.toString();
        br.close();
        return data;
    }

    public ArrayList<DataModel> parser() throws IOException, ParseException {

        String data = reader();
        String regex = "(\\s)+";
        Scanner sc = new Scanner(data);
        String[] split = sc.nextLine().split(regex);
        ArrayList<DataModel> list = new ArrayList();
        while (sc.hasNext()) {
            String[] row = sc.nextLine().split(regex);
            DataModel dm = new DataModel();
            for (int i = 0; i < row.length; i++) {

                dm.setStudentNumber(Integer.parseInt(row[0]));
                dm.setAge(Integer.parseInt(row[1]));
                dm.setAnalyse(Float.parseFloat(row[2].replaceAll(",", ".")));
                //System.out.println(Float.parseFloat(row[2].replaceAll(",", ".")));
                dm.setDevelopment(Float.parseFloat(row[3].replaceAll(",", ".")));
                dm.setProject(Float.parseFloat(row[4].replaceAll(",", ".")));
                dm.setSkills(Float.parseFloat(row[5].replaceAll(",", ".")));

            }
            list.add(dm);
        }
        return list;
    }

}
