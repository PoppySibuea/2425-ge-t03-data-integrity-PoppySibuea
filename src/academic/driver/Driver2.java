package academic.driver;

import academic.model.Course;
import academic.model.Student;
import academic.model.Enrollment;
import java.util.*;

public class Driver2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Gunakan TreeMap untuk course agar terurut berdasarkan ID
        Map<String, Course> courses = new TreeMap<>();
        Map<String, Student> students = new LinkedHashMap<>();
        List<Enrollment> enrollments = new ArrayList<>();
        Set<String> errors = new LinkedHashSet<>();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.equals("---")) break;

            String[] parts = line.split("#");

            if (parts[0].equals("course-add")) {
                String id = parts[1];
                String name = parts[2];
                int sks = Integer.parseInt(parts[3]);
                String grade = parts[4];
                courses.put(id, new Course(id, name, sks, grade));

            } else if (parts[0].equals("student-add")) {
                String nim = parts[1];
                String name = parts[2];
                String tahun = parts[3];
                String prodi = parts[4];
                students.put(nim, new Student(nim, name, tahun, prodi));

            } else if (parts[0].equals("enrollment-add")) {
                String courseId = parts[1];
                String studentId = parts[2];
                String tahun = parts[3];
                String semester = parts[4];

                boolean courseExists = courses.containsKey(courseId);
                boolean studentExists = students.containsKey(studentId);

                if (!studentExists) {
                    errors.add("invalid student|" + studentId);
                }
                if (!courseExists) {
                    errors.add("invalid course|" + courseId);
                }
                if (courseExists && studentExists) {
                    enrollments.add(new Enrollment(courseId, studentId, tahun, semester));
                }
            }
        }

        // Cetak error terlebih dahulu
        for (String error : errors) {
            System.out.println(error);
        }

        // Cetak courses (terurut berdasarkan ID karena pakai TreeMap)
        for (Course course : courses.values()) {
            System.out.println(course);
        }

        // Cetak students sesuai urutan input
        for (Student student : students.values()) {
            System.out.println(student);
        }

        // Cetak enrollments
        for (Enrollment enrollment : enrollments) {
            System.out.println(enrollment);
        }

        scanner.close();
    }
}
