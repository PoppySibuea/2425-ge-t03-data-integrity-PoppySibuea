package academic.driver;

import academic.model.Course;
import academic.model.Student;
import academic.model.Enrollment;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author 12S23004 - Poppy Sibuea
 * @author 12S23026 - Arif Doloksaribu
 */
public class Driver2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Course> courses = new ArrayList<>();
        ArrayList<Student> students = new ArrayList<>();
        ArrayList<Enrollment> enrollments = new ArrayList<>();

        while (true) {
            String input = sc.nextLine();
            if (input.equals("---")) {
                break;
            }

            String[] parts = input.split("#");
            String command = parts[0];

            switch (command) {
                case "course-add":
                    courses.add(new Course(parts[1], parts[2], Integer.parseInt(parts[3]), parts[4]));
                    break;
                case "student-add":
                    students.add(new Student(parts[1], parts[2], parts[3], parts[4]));
                    break;
                case "enrollment-add":
                    String courseId = parts[1];
                    String studentId = parts[2];
                    String year = parts[3];
                    String semester = parts[4];

                    if (!courseExists(courses, courseId)) {
                        System.out.println("invalid course|" + courseId);
                        continue;
                    }
                    if (!studentExists(students, studentId)) {
                        System.out.println("invalid student|" + studentId);
                        continue;
                    }
                    enrollments.add(new Enrollment(studentId, courseId, year, semester));
                    break;
            }
        }
        
        for (Course course : courses) {
            System.out.println(course);
        }
        for (Student student : students) {
            System.out.println(student);
        }
        for (Enrollment enrollment : enrollments) {
            System.out.println(enrollment);
        }
        
        sc.close();
    }

    private static boolean courseExists(ArrayList<Course> courses, String id) {
        for (Course course : courses) {
            if (course.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    private static boolean studentExists(ArrayList<Student> students, String id) {
        for (Student student : students) {
            if (student.getNim().equals(id)) {
                return true;
            }
        }
        return false;
    }
}
