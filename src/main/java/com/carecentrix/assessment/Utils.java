package com.carecentrix.assessment;

import java.io.*;
import java.util.*;

public class Utils {

    /**
     * Generate and return a random gender between M and F
     */
    public static String generateRandomGender(){
        if(new Random().nextBoolean()){
            return "M";
        }
        else return "F";
    }

    /**
     * @param startYear
     * @param endYear
     * Generate and return a DOB between a year range provided
     */
    public static String generateRandomDOB(int startYear, int endYear){
        GregorianCalendar gc = new GregorianCalendar();
        int year = randBetween(startYear, endYear);
        gc.set(gc.YEAR, year);
        int dayOfYear = randBetween(1, gc.getActualMaximum(gc.DAY_OF_YEAR));
        gc.set(gc.DAY_OF_YEAR, dayOfYear);
        return (gc.get(gc.MONTH) + 1) + "/" + gc.get(gc.DAY_OF_MONTH) + "/" + gc.get(gc.YEAR);
    }

    /**
     * @param start
     * @param end
     * Generate and return a random integer number between a range provided
     */
    public static int randBetween(int start, int end) {
        return start + (int)Math.round(Math.random() * (end - start));
    }

    /**
     * @param filePath
     * @param searchTerm
     * Count the word occurrences in a file
     */
    public static void countWordOccurrences(String filePath, String searchTerm){
        HashMap<String, Integer> map = new HashMap<String, Integer>(50, 10);

        try {
            File input = new File(filePath);
            Scanner read = new Scanner(new FileInputStream(input));
            ArrayList<String> list = new ArrayList<>();

            while (read.hasNext()) {
                list.add(read.next());
            }

            long searchTermCount = list.stream()
                    .filter(p -> p.contains(searchTerm))
                    .count();

            if(searchTermCount!=0)  //Check for count not equal to zero
            {
                System.out.println("The given word '" +searchTerm+ "' is present for "+searchTermCount+ " Times in the file");
            }
            else
            {
                System.out.println("The given word '" +searchTerm+ "' is not present in the file");
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
