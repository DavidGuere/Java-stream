package com.Animals.Functions;

import com.Animals.AditionalFunctions.TryParseInt;
import com.Animals.CustomSort.CustomSortEnum;

import java.util.*;
import java.util.stream.Collectors;

public class SearchingFunctions {

    public static void nameAlphabeticalOrder(List<String[]> animal, boolean reverse){

        // Creating a new List<String> that only contains the name of the animals
        List<String> selectedAnimals = new ArrayList<>();

        animal.stream().forEach(animalData -> selectedAnimals.add(animalData[1]));

        // Sorting the previously created List by the names
        List<String> sortedByName;
        sortedByName = selectedAnimals.stream().sorted().collect(Collectors.toList());

        if (reverse){
            sortedByName = selectedAnimals.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        }

        System.out.println(sortedByName);
    }

    public static void nameAlphabeticalOrderCanSwim (List<String[]> animals, boolean reverse){
        // Selection animals that can swim
        List<String[]> canSwim = animals.stream().filter(animal -> animal[3].equals("yes")).collect(Collectors.toList());

        nameAlphabeticalOrder(canSwim, reverse);
    }

    public static List<String[]> customSort(List<String[]> animals, CustomSortEnum customSort){

        // Retrieving string from enum
        String specialSort = customSort.getSpecialSort();
        // String to store filtered animals
        List<String[]> customSortAnimal;

        Scanner userInput = new Scanner(System.in);

        // Selecting the type of filter to perform
        switch (specialSort){
            case "type":
                System.out.println("Enter the type of animal:");
                String type = userInput.nextLine().toLowerCase(Locale.ROOT);
                customSortAnimal = animals.stream().filter(animal -> animal[0].equals(type)).collect(Collectors.toList());

                break;
            case "name":
                System.out.println("Enter the name of the animal:");
                String name = userInput.nextLine().toLowerCase(Locale.ROOT);

                customSortAnimal = animals.stream().filter(animal -> animal[1].equals(name)).collect(Collectors.toList());
                break;
            case "birth":
                System.out.println("Enter the birth year of the animal");
                String year = userInput.nextLine();
                customSortAnimal = animals.stream().filter(animal -> animal[2].equals(year)).collect(Collectors.toList());
                break;
            case "swim":
                System.out.println("To sort animal that can't swim type 'no', \nTo sort animal that can swim type 'yes'");
                String swim = userInput.nextLine().toLowerCase(Locale.ROOT);
                customSortAnimal = animals.stream().filter(animal -> animal[3].equals(swim)).collect(Collectors.toList());
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + specialSort);
        }
        return customSortAnimal;
    }

    public static List<String[]> sortByAge (List<String[]> animals){

        // List to separate animals with correct years from animals with incorrect years
        List<String[]> intBirthYear = new ArrayList<>();
        List<String[]> notIntBirthYear = new ArrayList<>();

        // Taking each string array and sorting according to the validity of the year
        for(String[] animal : animals){
            if (TryParseInt.tryParseInt(animal[2])){
                intBirthYear.add(animal);
            } else {
                notIntBirthYear.add(animal);
            }
        }

        System.out.println("The following years are not convertible to int");
        for (String[] animalArray : notIntBirthYear){
            System.out.println(Arrays.toString(animalArray));
        }
        // Comparing the string arrays according to the year
        return intBirthYear.stream().sorted(Comparator.comparing(animal -> animal[2])).collect(Collectors.toList());

//      Compare in reverse order
//      intBirthYear.stream().sorted(Comparator.comparing(animal -> animal[2] , Comparator.reverseOrder())).forEach(animal -> System.out.println(Arrays.toString(animal)));


    }


}
