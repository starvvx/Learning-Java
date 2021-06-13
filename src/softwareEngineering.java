public class softwareEngineering extends Departments{

    public softwareEngineering() {

    }
    public softwareEngineering(String departmentName, String hodName, int facultyCount, int studentCount) {
        super(departmentName,hodName,facultyCount,studentCount);
    }

    @Override
    public String markingScheme() {
        return "Beta book to maine likhi hai naa";
    }

    @Override
    public void showDetails() {
        System.out.println("Department: " + getDepartmentName());
        System.out.println("Hod: " + getHodName());
        System.out.println("Student count: " + getStudentCount());
        System.out.println("Faculty count: " + getFacultyCount());
        System.out.println("Marking Scheme: " + markingScheme());
    }
}
