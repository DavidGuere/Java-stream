package com.Animals;

import com.Animals.CustomSort.CustomSortEnum;
import com.Animals.Functions.SearchingFunctions;
import com.Animals.ImportExportData.ExportCSV;
import com.Animals.ImportExportData.ImportCSV;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Animals {
    public static void main(String[] args) {


        String path = "C:\\Anaconda3\\Java_learn\\Animals\\animals.csv";

        List<String[]> animal = new ArrayList<>();
        animal = ImportCSV.readFile(path);

        // 1) Print the animals out in alphabetical order by their name (one should be able to choose either ascending
        // or descending).

        // For increasing sort type: false
        // for decreasing sort type: true
        SearchingFunctions.nameAlphabeticalOrder(animal, false);

        // 2) Print out the animals filtered by swimmers in alphabetical order by their name (one should be able to
        // choose either ascending or descending).
        SearchingFunctions.nameAlphabeticalOrderCanSwim(animal, true);

        // 3) Write a method that allows filtering a collection of animals using a custom filter. The method should
        // return a collection of animals that satisfy the custom filter.

        // Select the custom sort from the "CustomSort" enum (TYPE, NAME, BIRTH_YEAR, SWIMMER)
        List<String[]> customSortedAnimals = SearchingFunctions.customSort(animal, CustomSortEnum.SWIMMER);

        for (String[] animalArray : customSortedAnimals){
            System.out.println(Arrays.toString(animalArray));
        }

        // 4) Create a new CSV file "swimmers.csv" with the contents of the "swimmers" collection sorted chronologically
        // by birth date. This new CSV file should have the same format as the original file "animals.csv".
        List<String[]> yearIncreasingSwimmer = SearchingFunctions.sortByAge(customSortedAnimals);
        ExportCSV.saveAsCSV(yearIncreasingSwimmer);


    }
}
