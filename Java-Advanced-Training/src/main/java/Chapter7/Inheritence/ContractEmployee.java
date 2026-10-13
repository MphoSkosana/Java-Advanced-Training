package Chapter7.Inheritence;

public class ContractEmployee extends Employee{
    private double hourlyRate;
    private int hoursWorked;

    public ContractEmployee(String empNumber, String name, int hours, double rate){
        super(empNumber, "", name);
        setHourlyRate(rate);
        setHourlyRate(hours);
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }
}
