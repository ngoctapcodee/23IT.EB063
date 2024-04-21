
package Baitapgk;

import java.io.File;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Thread4 implements Runnable {
    List<Student> students;

    public Thread4(List<Student> students) {
        this.students = students;
    }

    public void run() {
        try {
            DocumentBuilderFactory dBF = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dBF.newDocumentBuilder();
            Document docu = db.newDocument();

            Element ele = docu.createElement("students");
            docu.appendChild(ele);

            for (Student student : students) {
                Element studentElement = docu.createElement("student");
                ele.appendChild(studentElement);

                Element ID = docu.createElement("id");
                ID.setTextContent(Integer.toString(student.id));
                studentElement.appendChild(ID);

                Element Name = docu.createElement("name");
                Name.setTextContent(student.name);
                studentElement.appendChild(Name);

                Element ADD = docu.createElement("address");
                ADD.setTextContent(student.address);
                studentElement.appendChild(ADD);

                Element AGE = docu.createElement("age");
                AGE.setTextContent(Integer.toString(student.age));
                studentElement.appendChild(AGE);

                Element SUM = docu.createElement("sum");
                SUM.setTextContent(Integer.toString(student.sum));
                studentElement.appendChild(SUM);

                Element DIGIT = docu.createElement("isDigit");
                DIGIT.setTextContent(Boolean.toString(student.isDigit));
                studentElement.appendChild(DIGIT);
            }

            TransformerFactory tranF = TransformerFactory.newInstance();
            Transformer tran = tranF.newTransformer();
            DOMSource source = new DOMSource(docu);
            StreamResult Sresult = new StreamResult(new File("./src/baitapGK/kq.xml"));

            tran.transform(source, Sresult);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
