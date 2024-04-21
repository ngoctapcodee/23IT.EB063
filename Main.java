
package Baitapgk;

import java.io.*;
import java.util.*;
import javax.xml.parsers.*;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.*;
import java.security.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        Thread t1 = new Thread(new Thread1(students));
        Thread t2 = new Thread(new Thread2(students));
        Thread t3 = new Thread(new Thread3(students));
        Thread t4 = new Thread(new Thread4(students));

        t1.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();
        try {
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t3.start();
        try {
			t3.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        t4.start();
    }
}
