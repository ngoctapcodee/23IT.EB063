package Baitapgk;

import java.util.List;

public class Thread3 implements Runnable {
    List<Student> students;

    public Thread3(List<Student> students) {
        this.students = students;
    }

    public void run() {
        for (Student student : students) {
            // Check số nguyên tố
            boolean nguyenTo = true;
            int sOfDigits = student.sum;
            if (sOfDigits < 2) {
                nguyenTo = false;
            } else {
                for (int i = 2; i <= Math.sqrt(sOfDigits); i++) {
                    if (sOfDigits % i == 0) {
                        nguyenTo = false;
                        break;
                    }
                }
            }

            if (nguyenTo) {
                System.out.println("ID: " + student.id + " Name: " + student.name + " Address: " + student.address + " Age: " + student.age + " Sum of date of birth digits: " + sOfDigits + " is a prime number");
            } else {
                System.out.println("ID: " + student.id + " Name: " + student.name + " Address: " + student.address + " Age: " + student.age + " Sum of date of birth digits: " + sOfDigits + " is not a prime number");
            }
        }
    }
}
