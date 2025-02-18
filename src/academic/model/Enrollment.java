package academic.model;

/**
 * @author 12S23004 - Poppy Sibuea
 * @author 12S23026 - Arif Doloksaribu
 */
public class Enrollment {

    // class definition
    private String Student;
    private String Course;
    private String Tahun;
    private String Semester;
    private String Grade = "None";

    public Enrollment(String Student, String Course, String Tahun, String Semester) {
        this.Student = Student;
        this.Course = Course;
        this.Tahun = Tahun;
        this.Semester = Semester;
    }

    public void setStudent(String Student) {
        this.Student = Student;
    }

    public void setCourse(String Course) {
        this.Course = Course;
    }

    public void setTahun(String Tahun) {
        this.Tahun = Tahun;
    }

    public void setSemester(String Semester) {
        this.Semester = Semester;
    }

    public void setGrade(String Grade) {
        this.Grade = Grade;
    }

    public String getStudent() {
        return Student;
    }

    public String getCourse() {
        return Course;
    }

    public String getTahun() {
        return Tahun;
    }

    public String getSemester() {
        return Semester;
    }

    public String getGrade() {
        return Grade;
    }

    @Override
    public String toString() {
        return Student + "|" + Course + "|" + Tahun + "|" + Semester + "|" + Grade;
    }
}