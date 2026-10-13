package Chapter7.Inheritence;

public class Employee {
    protected String name;
    protected String email;
    protected String empNumber;


    public Employee(String empNumber, String email, String name) {
        this.empNumber = empNumber;
        this.email = email;
        this.name = name;
    }

    public String getEmpNumber() {
        return empNumber;
    }

    public void setEmpNumber(String empNumber) {
        this.empNumber = empNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
