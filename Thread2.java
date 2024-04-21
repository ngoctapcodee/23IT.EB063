package Baitapgk;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class Thread2 implements Runnable {
    List<Student> students;

    public Thread2(List<Student> students) {
        this.students = students;
    }

    public void run() {
        for (Student student : students) {
            Calendar ca = Calendar.getInstance();
            try {
                ca.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(student.dateOfBirth));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            int age = Calendar.getInstance().get(Calendar.YEAR) - ca.get(Calendar.YEAR);
            student.age = age;

            student.sum = 0;
            String boDau = student.dateOfBirth.replaceAll("-", ""); // Bỏ "-"
            for (char c : boDau.toCharArray()) {
                student.sum += Character.getNumericValue(c);
            }
        }
    }
}
