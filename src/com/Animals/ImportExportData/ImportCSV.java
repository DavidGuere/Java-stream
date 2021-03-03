package com.Animals.ImportExportData;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ImportCSV {

        public static List<String[]> readFile (String path){

            String line = "";
            List<String[]> animals = new ArrayList<>();
            // BufferedReader sends data first to a buffer
            try {
                BufferedReader br = new BufferedReader(new FileReader(path));

                while ((line = br.readLine()) != null){
                    String[] value = line.split(",");

                    animals.add(value);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            return animals;
        }
}
