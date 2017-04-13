package com.company;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.util.Date;
import java.util.List;
import java.nio.charset.Charset;

public class DataManager {

    public void savePeopleCollectionToFile(String fileName, ArrayList<String> people) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(new FileOutputStream(fileName));
        for (String person : people)
            pw.println(person);
        pw.close();
    }

    public ArrayList<Person> loadPeopleCollectionFromFile(String fileName) {
        ArrayList<Person> result = new ArrayList<Person>();
        Path filePath = Paths.get(fileName);
        Charset charset = Charset.forName(Constants.CHAR_SET);
        try {
            List<String> lines = Files.readAllLines(filePath, charset);
            for (String line : lines) {
                Person person = getPesonFromLine(line);
                if(person == null){
                    System.out.println("Person could not be parsed :" + line);
                }
                result.add(person);
            }
        } catch (IOException e) {
            System.out.println(e);
        }

        return result;
    }

    private Person getPesonFromLine(String line) {
        String[] parts = line.split("\\|");
        String occupation = parts[0];
        String name = parts[1];
        String birth = parts[2];

        SimpleDateFormat format = new SimpleDateFormat(Constants.DATE_FORMAT);
        try {
            Date birthDay = format.parse(birth);
            if (occupation.equalsIgnoreCase("Teacher")) {
                Teacher teacher = new Teacher(name, birthDay);
                return teacher;
            } else {
                Student student = new Student(name, birthDay);
                return student;
            }
        } catch (ParseException e) {
            System.err.println("ParseException: " + e.getMessage());
        }

        return null;
    }
}