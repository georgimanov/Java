package com.company;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class Main {

    private static Person getPerson(Node node) {
        //XMLReaderDOM domReader = new XMLReaderDOM();
        Person emp = new Person();
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            emp.setName(getTagValue("name", element));
            emp.setRole(getTagValue("role", element));
        }

        return emp;
    }

    private static String getAttributeValue(String attr, Element element) {
        return element.getAttribute(attr);
    }

    private static String getTagValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = (Node) nodeList.item(0);
        return node.getNodeValue();
    }

    private static Date getDate(String attr, Element element) {
        try {
            SimpleDateFormat format = new SimpleDateFormat(Constants.DATE_FORMAT);
            String datetimeStr = element.getAttribute(attr);
            Date parseDate = format.parse(datetimeStr);

            return parseDate;
        }catch (ParseException e) {
                System.err.println("ParseException: " + e.getMessage());
        }

        return new Date();
    }

    private static Institution GetInstitution(List<Institution> institutions, String fileName) {
        // http://stackoverflow.com/questions/2811001/how-to-read-xml-using-xpath-in-java

        String filePath = fileName;
        File xmlFile = new File(filePath);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        Institution institution = null;

        try {
            dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();
            //System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            NodeList nodeList = doc.getElementsByTagName("Person");

            Element root = doc.getDocumentElement();
            String type = getAttributeValue("type", root);
            Date date = getDate("date", doc.getDocumentElement());
            if(type.equalsIgnoreCase(Constants.SCHOOL)) {
                institution = new School();
                institution.setName(fileName);
                institution.setDate(date);

                System.out.println("School created: " + institution.getName());

                //institutions.add(institution);

            } else if (type.equalsIgnoreCase(Constants.KINDERGARDER)) {
                institution = new Kindergarden();
                institution.setName(fileName);
                institution.setDate(date);

                //institutions.add(institution);

                System.out.println("Kindergarden created: " + institution.getName());
            }

            //now XML is loaded as Document in memory, lets convert it to Object List
            List<Person> people = new ArrayList<Person>();
            for (int i = 0; i < nodeList.getLength(); i++) {
                Person person = getPerson(nodeList.item(i));

                if(person.getRole().equalsIgnoreCase(Constants.TEACHER)){
                    Teacher teacher = new Teacher();
                    teacher.setName(person.getName());
                    institution.addTeacher(teacher);
                }

                if(person.getRole().equalsIgnoreCase(Constants.STUDENT)){
                    Student teacher = new Student();
                    teacher.setName(person.getName());
                    institution.addStudent(teacher);
                }
            }
        } catch (SAXException | ParserConfigurationException | IOException e1) {
            e1.printStackTrace();
        }

        return institution;
    }

    public static void printSortedByDate(ArrayList<Institution> institutions){
        Collections.sort(institutions, Institution.InstitutionDateComperator);

        System.out.println(" - Institutions sorted by date \n");
        for(Institution str: institutions){
            System.out.println(str);
        }
    }

    public static void printSortedByCount(ArrayList<Institution> institutions) {
        Collections.sort(institutions, Institution.InstitutionStudentsCountComperator);

        System.out.println(" - Institutions sorted by students count\n");
        for (Institution str : institutions) {
            System.out.println(str);
        }
    }

    public static void saveInstitutionsCollectionToFile(String fileName, ArrayList<Institution> institutions) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(new FileOutputStream(fileName));
        for (Institution institution : institutions)
            pw.println(institution.forFileSave());
        pw.close();
    }

    public static void main(String[] args) {
        ArrayList<Institution> institutions = new ArrayList<Institution>();

        String fileName1 = "schools/School2.xml";
        Institution institution1 = GetInstitution(institutions, fileName1);
        institutions.add(institution1);

        String fileName2 = "schools/School1.xml";
        Institution institution2 = GetInstitution(institutions, fileName2);
        institutions.add(institution2);

        String fileName3 = "schools/Kindergarden1.xml";
        Institution institution3 = GetInstitution(institutions, fileName3);
        institutions.add(institution3);

        for(Institution inst: institutions) {
            System.out.println(inst.toString());
        }

        printSortedByCount(institutions);
        printSortedByDate(institutions);

        try{
            saveInstitutionsCollectionToFile("institutions.txt", institutions);
        } catch (FileNotFoundException ex){
            //...
        }
    }
}
