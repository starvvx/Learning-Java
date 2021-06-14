public class studentMarks implements Comparable{

    private  String name;
    private int maths;
    private int english;
    private int science;
    private int totalMarks;

    public studentMarks(String name, int mathsMarks, int englishMarks, int scienceMarks) {

        this.name = name;
        this.maths = mathsMarks;
        this.english = englishMarks;
        this.science = scienceMarks;
        this.totalMarks = this.maths + this.english + this.science;

    }

    public int compareTo(Object o) {

        studentMarks s1 = (studentMarks) o;
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

}
