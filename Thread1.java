package Baitapgk;

import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Thread1 implements Runnable {
    List<Student> students;

    public Thread1(List<Student> students) {
        this.students = students;
    }

    public void run() {
        try {
            DocumentBuilderFactory dBF = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dBF.newDocumentBuilder();
            Document docu = db.parse("./src/baitapGK/student.xml");

            NodeList studentList = docu.getElementsByTagName("student");
            for (int i = 0; i < studentList.getLength(); i++) {
                Node studentNode = studentList.item(i);
                if (studentNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element studentElement = (Element) studentNode;

                    int id = Integer.parseInt(studentElement.getElementsByTagName("id").item(0).getTextContent());
                    String name = studentElement.getElementsByTagName("name").item(0).getTextContent();
                    String add = studentElement.getElementsByTagName("address").item(0).getTextContent();
                    String dOB = studentElement.getElementsByTagName("dateOfBirth").item(0).getTextContent();
                    students.add(new Student(id, name, add, dOB));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}