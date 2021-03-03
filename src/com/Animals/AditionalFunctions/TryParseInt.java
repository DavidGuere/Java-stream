package com.Animals.AditionalFunctions;

public class TryParseInt {

    // Function that return true if the string can be converted to int, otherwise returns false
    public static boolean tryParseInt(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
