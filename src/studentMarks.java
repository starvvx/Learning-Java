import java.util.ArrayList;
import java.util.Iterator;

public class studentMarks implements Comparable<studentMarks>, Iterable<grades>, getAvgMarks{

    private  String name;
    private int maths;
    private int english;
    private int science;
    private int totalMarks;
    private double avgMarks;
    private ArrayList<grades> gradesArrayList = new ArrayList<>();

    public studentMarks(String name, int mathsMarks, int englishMarks, int scienceMarks) {

        this.name = name;
        this.maths = mathsMarks;
        this.english = englishMarks;
        this.science = scienceMarks;
        this.totalMarks = this.maths + this.english + this.science;
        fillGradesList();

    }

    @Override
    public double calculateAvgMarks() {
        avgMarks = (this.totalMarks)/3d;
        return avgMarks;
    }

    public void fillGradesList() {
        gradesArrayList.add(new grades(this.maths));
        gradesArrayList.add(new grades(this.english));
        gradesArrayList.add(new grades(this.science));
    }

    public Iterator<grades> iterator() {
        return gradesArrayList.iterator();
    }

    public int compareTo(studentMarks s1) {

        int returnValue = s1.totalMarks - this.totalMarks;

        if(returnValue == 0) {
            returnValue = s1.maths - this.maths;
        }

        if(returnValue == 0) {
            returnValue = s1.english - this.english;
        }

        if(returnValue == 0) {
            returnValue = s1.science - this.science;
        }

        return returnValue;
    }

    public void getDetails() {
        System.out.println(this.name + " Got " + this.maths + " in maths " +
                this.english + " in english " + this.science + " in science and a total of "
                + this.totalMarks + " marks");
    }

    public String getName() {
        return this.name;
    }

}
