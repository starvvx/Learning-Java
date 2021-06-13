import java.util.Objects;
import java.util.Scanner;

public class Departments {
    private String departmentName;
    private String hodName;
    private int facultyCount;
    private int studentCount;

    public Departments() {

    }

    public Departments(String departmentName, String hodName, int facultyCount, int studentCount) {
        this.departmentName = departmentName;
        this.hodName = hodName;
        this.facultyCount = facultyCount;
        this.studentCount = studentCount;
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof Departments) {
            Departments d1 = (Departments) o;
            return d1.departmentName == this.departmentName
                    && d1.hodName == this.hodName;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(departmentName, hodName, facultyCount, studentCount);
    }

    public void setFacultyCount(int facultyCount) {
        this.facultyCount = facultyCount;
    }

    public int getFacultyCount() {
        return this.facultyCount;
    }

    public void setHodName(String hodName) {
        this.hodName = hodName;
    }

    public String getHodName() {
        return this.hodName;
    }

    public void setStudentCount(int studentCount) {
        this.studentCount = studentCount;
    }

    public int getStudentCount() {
        return this.studentCount;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void showDetails() {
        System.out.println("Department: " + this.departmentName);
        System.out.println("Hod: " + this.hodName);
        System.out.println("Faculty count: " + this.facultyCount);
        System.out.println("Student count: " + this.studentCount);
    }

}
