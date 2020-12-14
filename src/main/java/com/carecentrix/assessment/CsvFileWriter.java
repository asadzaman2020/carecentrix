package com.carecentrix.assessment;

import java.io.FileWriter;
import java.io.IOException;

public class CsvFileWriter {

    //Delimiter used in CSV file
    private static final String PIPE_DELIMITER = "|";
    private static final String NEW_LINE_SEPARATOR = "\n";


    /**
     * Creates a pipe delimited csv file which contain the following fields - ID, LastName, FirstName, Gender, DOB and Address.
     * Some fields should randomly generated data under the given constraint
     * ID = between 1000 to 2000
     * Gender = M or F
     * DOB = between 1950 to 2010
     */
    public static void writeCsvFile(String fileName) {

        int ID = Utils.randBetween(1000,2000);
        String gender = Utils.generateRandomGender();
        String DOB = Utils.generateRandomDOB(1950,2000);

        //Create new Employee objects
        Employee employee = new Employee(ID, "Zaman", "Asad", gender, DOB, "131 francis ave");

        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(fileName);

            //Write the CSV file header
            fileWriter.append("ID");
            fileWriter.append(PIPE_DELIMITER);
            fileWriter.append("LastName");
            fileWriter.append(PIPE_DELIMITER);
            fileWriter.append("FirstName");
            fileWriter.append(PIPE_DELIMITER);
            fileWriter.append("Gender");
            fileWriter.append(PIPE_DELIMITER);
            fileWriter.append("DOB");
            fileWriter.append(PIPE_DELIMITER);
            fileWriter.append("Address");
            fileWriter.append(PIPE_DELIMITER);

            //Add a new line separator after the header
            fileWriter.append(NEW_LINE_SEPARATOR);

            //Write a new employee object list to the CSV file
            fileWriter.append(String.valueOf(employee.getId()));
            fileWriter.append(PIPE_DELIMITER);
            fileWriter.append(employee.getLastName());
            fileWriter.append(PIPE_DELIMITER);
            fileWriter.append(employee.getFirstName());
            fileWriter.append(PIPE_DELIMITER);
            fileWriter.append(employee.getGender());
            fileWriter.append(PIPE_DELIMITER);
            fileWriter.append(String.valueOf(employee.getDob()));
            fileWriter.append(PIPE_DELIMITER);
            fileWriter.append(String.valueOf(employee.getAddress()));
            fileWriter.append(PIPE_DELIMITER);
            fileWriter.append(NEW_LINE_SEPARATOR);

            System.out.println("CSV file was created successfully !!!");

        } catch (Exception e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        } finally {

            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
            }

        }
    }
}
