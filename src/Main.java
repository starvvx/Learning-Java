public class Main {

    public static void main(String[] args) {
        Departments se = new softwareEngineering("Software Engineering","Ruchika Malhotra",10,127);
        Departments se1 = new softwareEngineering("Software Engineering","Ruchika Malhotra",10,127);
        System.out.println(se.equals(se1));
        se.showDetails();
    }

}
