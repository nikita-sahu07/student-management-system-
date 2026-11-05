
import java.util.ArrayList;
import java.util.Scanner;

class Student {
    int rollNo;
    String name;
    String course;
    double marks;

    Student(int rollNo, String name, String course, double marks) {
        this.rollNo = rollNo;
        this.name = name;
        this.course = course;
        this.marks = marks;
    }

    void display() {
        System.out.println("Roll No: " + rollNo);
        System.out.println("Name: " + name);
        System.out.println("Course: " + course);
        System.out.println("Marks: " + marks);
        System.out.println("----------------------");
    }
}

public class StudentManagement {

    static ArrayList<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    static void addStudent() {
        System.out.print("Enter Roll Number: ");
        int roll = sc.nextInt();
        sc.nextLine();

        if (searchStudent(roll) != null) {
            System.out.println("Roll Number already exists!");
            return;
        }

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Course: ");
        String course = sc.nextLine();

        System.out.print("Enter Marks: ");
        double marks = sc.nextDouble();

        students.add(new Student(roll, name, course, marks));

        System.out.println("Student Added Successfully!");
    }

    static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No Student Records Found!");
            return;
        }

        for (Student s : students) {
            s.display();
        }
    }

    static Student searchStudent(int roll) {
        for (Student s : students) {
            if (s.rollNo == roll) {
                return s;
            }
        }
        return null;
    }

    static void search() {
        System.out.print("Enter Roll Number: ");
        int roll = sc.nextInt();

        Student s = searchStudent(roll);

        if (s != null) {
            s.display();
        } else {
            System.out.println("Student Not Found!");
        }
    }

    static void updateStudent() {
        System.out.print("Enter Roll Number: ");
        int roll = sc.nextInt();
        sc.nextLine();

        Student s = searchStudent(roll);

        if (s != null) {
            System.out.print("Enter New Name: ");
            s.name = sc.nextLine();

            System.out.print("Enter New Course: ");
            s.course = sc.nextLine();

            System.out.print("Enter New Marks: ");
            s.marks = sc.nextDouble();

            System.out.println("Student Updated Successfully!");
        } else {
            System.out.println("Student Not Found!");
        }
    }

    static void deleteStudent() {
        System.out.print("Enter Roll Number: ");
        int roll = sc.nextInt();

        Student s = searchStudent(roll);

        if (s != null) {
            students.remove(s);
            System.out.println("Student Deleted Successfully!");
        } else {
            System.out.println("Student Not Found!");
        }
    }

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");

            System.out.print("Enter Your Choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addStudent();
                    break;

                case 2:
                    viewStudents();
                    break;

                case 3:
                    search();
                    break;

                case 4:
                    updateStudent();
                    break;

                case 5:
                    deleteStudent();
                    break;

                case 6:
                    System.out.println("Thank You!");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 6);

        sc.close();
    }
}

OUTPUT:

===== STUDENT MANAGEMENT SYSTEM =====
1. Add Student
2. View Students
3. Search Student
4. Update Student
5. Delete Student
6. Exit

Enter Your Choice: 1
Enter Roll Number: 101
Enter Name: Rahul
Enter Course: BCA
Enter Marks: 85

Student Added Successfully!