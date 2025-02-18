package academic.driver;

import academic.model.Course;
import academic.model.Student;
import academic.model.Enrollment;
import java.util.*;

public class Driver2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Course> courses = new ArrayList<>();
        List<Student> students = new ArrayList<>();
        List<Enrollment> enrollments = new ArrayList<>();
        Set<String> errors = new LinkedHashSet<>(); // Menggunakan LinkedHashSet agar error tidak duplikat dan urut

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.equals("---")) break;

            String[] parts = line.split("#");

            if (parts[0].equals("course-add")) {
                // Menambahkan course
                String id = parts[1];
                String name = parts[2];
                int sks = Integer.parseInt(parts[3]);
                String grade = parts[4];
                courses.add(new Course(id, name, sks, grade));

            } else if (parts[0].equals("student-add")) {
                // Menambahkan student
                String nim = parts[1];
                String name = parts[2];
                String tahun = parts[3];
                String prodi = parts[4];
                students.add(new Student(nim, name, tahun, prodi));

            } else if (parts[0].equals("enrollment-add")) {
                // Menambahkan enrollment dengan validasi
                String courseId = parts[1];
                String studentId = parts[2];
                String tahun = parts[3];
                String semester = parts[4];

                boolean courseExists = courses.stream().anyMatch(c -> c.getId().equals(courseId));
                boolean studentExists = students.stream().anyMatch(s -> s.getNim().equals(studentId));

                if (!studentExists) {
                    errors.add("invalid student|" + studentId); // Pakai Set agar tidak duplikat
                }
                if (!courseExists) {
                    errors.add("invalid course|" + courseId);
                }
                if (courseExists && studentExists) {
                    enrollments.add(new Enrollment(courseId, studentId, tahun, semester));
                }
            }
        }

        // Menampilkan error validasi terlebih dahulu (tanpa duplikat)
        for (String error : errors) {
            System.out.println(error);
        }

        // Menampilkan courses
        for (Course course : courses) {
            System.out.println(course);
        }

        // Menampilkan students
        for (Student student : students) {
            System.out.println(student);
        }

        // Menampilkan enrollments
        for (Enrollment enrollment : enrollments) {
            System.out.println(enrollment);
        }

        scanner.close();
    }
}
