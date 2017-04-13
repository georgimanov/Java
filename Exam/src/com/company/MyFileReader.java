package com.company;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;

public class MyFileReader implements Callable<Institution> {

    private String _filePath = Constants.EMPTY_STRING;
    public MyFileReader(String filePath){
        this._filePath = filePath;
    }

    public Person getPerson(Node node) {
        //XMLReaderDOM domReader = new XMLReaderDOM();
        Person emp = new Person();
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            emp.setName(getTagValue("name", element));
            emp.setRole(getTagValue("role", element));
        }

        return emp;
    }

    public String getAttributeValue(String attr, Element element) {
        return element.getAttribute(attr);
    }

    public String getTagValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = (Node) nodeList.item(0);
        return node.getNodeValue();
    }

    public Date getDate(String attr, Element element) {
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

    public Institution getInstitution(String fileName) {
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

    @Override
    public Institution call() throws Exception {
        return getInstitution(this._filePath);
    }
}
