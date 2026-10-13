package Chapter7.Inheritence;

public class PermanentEmployee extends Employee{
    private double salary;

    public PermanentEmployee(String empNumber, String email, String name, double salary){
        super(empNumber, email, name);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void output(){
        System.out.println();
    }
}
