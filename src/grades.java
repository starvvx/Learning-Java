public class grades implements Comparable<grades>{


    public enum grade {
        O("O: Outstanding"),
        A("A: excellent"),
        B("B: Satisfactory"),
        C("C: Average"),
        D("D: Below Average"),
        E("E: Pass"),
        F("F: Fail");

        private String title;

        grade(String title) {
            this.title = title;
        }
        public String getTitle() {
            return this.title;
        }
    }

    public int compareTo(grades g) {
        return g.getGrade().compareTo(this.getGrade());
    }

    private grade grade;

    public grades (int marks) {
        if(marks > 90) {
            this.grade = grade.O;
        }
        else if(marks > 80) {
            this.grade = grade.A;
        }
        else if(marks > 60) {
            this.grade = grade.B;
        }
        else if(marks > 50) {
            this.grade = grade.C;
        }
        else if(marks > 40) {
            this.grade = grade.D;
        }
        else if(marks > 35){
            this.grade = grade.E;
        } else {
            this.grade = grade.F;
        }
    }

    public grade getGrade() {
        return this.grade;
    }

}
