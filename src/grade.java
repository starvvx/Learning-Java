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
