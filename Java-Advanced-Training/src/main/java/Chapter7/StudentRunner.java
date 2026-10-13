package Chapter7;

public class StudentRunner {
    static void main() {
        Student objThabo = new Student("1213564", "Thabo", "Dlamini", "thabo.dl@gmail.com");

        objThabo.setAssessments(75, 74, 63);
        objThabo.display();
    }
}
