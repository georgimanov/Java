package com.company;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.util.Date;
import java.util.List;
import java.nio.charset.Charset;

public class DataManager {

    public void saveInstitutionsCollectionToFile(String fileName, ArrayList<Institution> institutions) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(new FileOutputStream(fileName));
        for (Institution institution : institutions)
            pw.println(institution.forFileSave());
        pw.close();
    }

    public ArrayList<String> getFilesInDirectory(String pathName)
    {
        ArrayList<String> results = new ArrayList<String>();
        File[] files = new File(pathName).listFiles();
        //If this pathname does not denote a directory, then listFiles() returns null.
        for (File file : files) {
            if (file.isFile()) {
                results.add(file.getName());
            }
        }

        return results;
    }
}