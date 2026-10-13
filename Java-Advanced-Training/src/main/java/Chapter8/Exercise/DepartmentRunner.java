package Chapter8.Exercise;


public class DepartmentRunner {
    static void main() {
        try {
            Department d = new Department("IT", 78, 15);

            d.setDepartmentID(206);
            d.setNumOfEmp(7);
            System.out.println(d);
        } catch (DepartmentException e) {
            System.err.println(e.getMessage());
        }
    }
}
