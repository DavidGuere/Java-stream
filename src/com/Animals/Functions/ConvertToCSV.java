package com.Animals.Functions;

public class ConvertToCSV {

    public static String convertLineToCSV(String[] stringArray){
        return String.join(",", stringArray);
    }
}
