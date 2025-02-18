package academic.driver;

import java.util.ArrayList;
import java.util.Scanner;
import academic.model.Student;
import academic.model.Course;
import academic.model.Enrollment;
/**
 * @author 12S23026 - Arif Doloksaribu
 * @author 12S23004 - Poppy Sibuea
 */
public class Driver1 {

    public static void main(String[] _args) {

        // codes
        Scanner sc = new Scanner (System.in);
        ArrayList<Course> courses = new ArrayList<Course>();
        ArrayList<Student> stu = new ArrayList<Student>();
        ArrayList<Enrollment> enrol = new ArrayList<Enrollment>();

        while (true){
            String input = sc.nextLine();
            if(input.equals("---")){
                break;
            }

            String[] data = input.split("#");

            if (data[0].equals("course-add")){
            courses.add(new Course(data[1], data[2], Integer.parseInt(data[3]), data[4]));
            }
            else if (data[0].equals("student-add")){
            stu.add(new Student(data[1], data[2], data[3], data[4]));
            }
            else if (data[0].equals("enrollment-add")){
            enrol.add(new Enrollment(data[1], data[2], data[3], data[4]));
            }
        }
    
        for (int i = courses.size() - 1; i >= 0; i--) {
            System.out.println(courses.get(i).toString());
        }

        for (int i = 0; i < stu.size(); i++) {
            System.out.println(stu.get(i).toString());
        }

        for (int i = 0; i < enrol.size(); i++) {
            System.out.println(enrol.get(i).toString());
        }
        sc.close();
    }

}