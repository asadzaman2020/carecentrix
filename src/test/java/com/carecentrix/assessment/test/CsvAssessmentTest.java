package com.carecentrix.assessment.test;

import com.carecentrix.assessment.CsvFileWriter;
import com.carecentrix.assessment.FileWatcher;
import com.carecentrix.assessment.Utils;
import org.junit.Test;

import java.io.IOException;

public class CsvAssessmentTest {

    /**
     * User is alerted when a pipe delimited file is dropped in to a folder
     */
    @Test
    public void createCSVFileTest() throws IOException {
        String fileName = System.getProperty("user.dir")+"/A/employee.csv";
        System.out.println("Write CSV file:");

        //Creates a pipe delimited csv file which contain the following fields - ID, LastName,
        // FirstName, Gender, DOB and Address.
        CsvFileWriter.writeCsvFile(fileName);

        //this function which will poll watch the location B
        FileWatcher.WatchMyFolder(System.getProperty("user.dir")+"/B");
    }

    /**
     * Search a specific word in a file and
     * print the total count of that specific word
     */
    @Test
    public void searchAndCountSpecificWordInTextFileTest() throws IOException {
        String fileName = System.getProperty("user.dir")+"/Log/serverlog.txt";
        Utils.countWordOccurrences(fileName,"error");
    }

}
