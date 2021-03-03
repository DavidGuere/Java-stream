package com.Animals.ImportExportData;

import com.Animals.Functions.ConvertToCSV;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExportCSV {

    public static void saveAsCSV(List<String[]> animals){
        List<String> lineJoin = new ArrayList<>();
        animals.stream().forEach(animal -> lineJoin.add(ConvertToCSV.convertLineToCSV(animal)));

        try {
            FileWriter csvWriter = new FileWriter("swimmers.csv");
            lineJoin.stream().forEach(line -> {
                try {
                    csvWriter.write(line);
                    csvWriter.write("\n");

                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            csvWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
