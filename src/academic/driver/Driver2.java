package academic.driver;

import java.util.*;
import java.util.LinkedList;
import academic.model.Student;
import academic.model.Course;
import academic.model.Enrollment;

/**
* @author 12S23004 Poppy Sibuea
 * @author 12S23026 Arif M. Doloksaribu
 */
public class Driver2 {
    public static void main(String[] _args) {
        Scanner sc = new Scanner(System.in);

        LinkedList<Course> courses = new LinkedList<>();
        LinkedList<Student> students = new LinkedList<>();
        LinkedList<Enrollment> enrollments = new LinkedList<>();

        LinkedList<String> invalidStudents = new LinkedList<>();
        LinkedList<String> invalidCourses = new LinkedList<>();

        List<String> inputs = new ArrayList<>();
        while (true) {
            String input = sc.nextLine();
            if (input.equals("---")) break;
            inputs.add(input);
        

            String[] data = input.split("#");

            switch (data[0]) {
                case "course-add":
                if (!isCourseExists(courses, data[1])) {
                    courses.addFirst(new Course(data[1], data[2], Integer.parseInt(data[3]), data[4]));
                }
                break;

                case "student-add":
                if (!isStudentExists(students, data[1])) {
                    students.add(new Student(data[1], data[2], data[3], data[4]));
                }
                break;

                case "enrollment-add":
                    Course course = findCourseById(courses, data[1]);
                    Student student = findStudentById(students, data[2]);

                    if (course == null) {
                        invalidCourses.add("invalid course|" + data[1]);
                    } else if (student == null) {
                        invalidStudents.add("invalid student|" + data[2]);
                    } else if (!isEnrollmentExists(enrollments, data[1], data[2], data[3], data[4])) {
                        enrollments.add(new Enrollment(course, student, data[3], data[4]));
                    }
                    break;

                default:
                    System.out.println("Perintah tidak dikenali!");
                    break;
            }

        }

        for (String error : invalidStudents) {
            System.out.println(error);
        }
        for (String error : invalidCourses) {
            System.out.println(error);
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

    private static boolean isCourseExists(LinkedList<Course> courses, String id) {
        for (Course course : courses) {
            if (course.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isStudentExists(LinkedList<Student> students, String id) {
        for (Student student : students) {
            if (student.getNim().equals(id)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isEnrollmentExists(LinkedList<Enrollment> enrollments, String courseId, String studentId, String year, String semester) {
        for (Enrollment enrollment : enrollments) {
            if (enrollment.getCourseId().equals(courseId) &&
                enrollment.getStudentId().equals(studentId) &&
                enrollment.getTahun().equals(year) &&
                enrollment.getSemester().equals(semester)) {
                return true;
            }
        }
        return false;
    }

    private static Student findStudentById( LinkedList<Student> students, String id) {
        for (Student student : students) {
            if (student.getNim().equals(id)) return student;
        }
        return null;
    }

    private static Course findCourseById(LinkedList<Course> courses, String id) {
        for (Course course : courses) {
            if (course.getId().equals(id)) return course;
        }
        return null;
    }
}
