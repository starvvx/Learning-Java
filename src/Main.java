import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        studentMarks [] marksInMidsem = {
                new studentMarks("Pushkar",10,20,30),
                new studentMarks("Jaljala",20,30,40),
                new studentMarks("muchhad",10,10,30),
                new studentMarks("Anupam",40,40,30)
        };
        Arrays.sort(marksInMidsem);
        for(studentMarks marks: marksInMidsem) {
            marks.getDetails();
        }
    }

}
