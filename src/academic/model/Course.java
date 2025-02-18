package academic.model;

/**
 * @author 12S23026 - Arif Doloksaribu
 * @author 12S23004 - Poppy Sibuea
 */
public class Course {

    // class definition
    private String id;
    private String namaMK;
    private int sks;
    private String grade;

    public Course(String id, String namaMK, int sks, String grade) {
        this.id = id;
        this.namaMK = namaMK;
        this.sks = sks;
        this.grade = grade;
    }

    public String getId() {
        return id;
    }

    public String getNamaMK() {
        return namaMK;
    }

    public int getSks() {
        return sks;
    }

    public String getGrade() {
        return grade;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNamaMK(String namaMK) {
        this.namaMK = namaMK;
    }

    public void setSks(int sks) {
        this.sks = sks;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString(){
        return id + "|" + namaMK + "|" + sks + "|" + grade;
    }

}