import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        studentMarks [] marksInMidsem = {
                new studentMarks("Pushkar",90,80,70),
                new studentMarks("Jaljala",80,90,40),
                new studentMarks("muchhad",70,90,60),
                new studentMarks("Anupam",90,90,90)
        };

        for(studentMarks marks: marksInMidsem) {
            System.out.println(marks.calculateAvgMarks());
        }
    }

}
