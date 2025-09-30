package Task3;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

//Student Class
class Student {
    private String id;
    private String name;
    private double grade;

    // Constructor
    public Student(String id, String name, double grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getGrade() {
        return grade;
    }

    // Display student info
    public void display() {
        System.out.println("ID: " + id + ", Name: " + name + ", Grade: " + grade);
    }
}

//Main Program
public class StudentManager {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        // 1. Add students
        students.add(new Student("S001", "Nguyen Van A", 8.5));
        students.add(new Student("S002", "Tran Thi B", 9.0));
        students.add(new Student("S003", "Le Van C", 7.2));
        students.add(new Student("S004", "Pham Thi D", 9.5));

        // 2. Display student list
        System.out.println("=== Student List ===");
        for (Student s : students) {
            s.display();
        }

        // 3. Search student by ID
        System.out.print("\nEnter ID to search: ");
        String searchId = sc.nextLine();
        boolean found = false;
        for (Student s : students) {
            if (s.getId().equalsIgnoreCase(searchId)) {
                System.out.println("Student found:");
                s.display();
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("No student found with ID: " + searchId);
        }

        // 4. Remove student by ID
        System.out.print("\nEnter ID to remove: ");
        String removeId = sc.nextLine();
        Student toRemove = null;
        for (Student s : students) {
            if (s.getId().equalsIgnoreCase(removeId)) {
                toRemove = s;
                break;
            }
        }
        if (toRemove != null) {
            students.remove(toRemove);
            System.out.println("Removed student with ID: " + removeId);
        } else {
            System.out.println("No student found to remove.");
        }

        // 5. Sort by grade in descending order
        Collections.sort(students, Comparator.comparingDouble(Student::getGrade).reversed());

        // Display after sorting
        System.out.println("\n Student List after sorting by grade ");
        for (Student s : students) {
            s.display();
        }

        sc.close();
    }
}
