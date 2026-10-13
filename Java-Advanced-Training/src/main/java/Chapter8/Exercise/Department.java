package Chapter8.Exercise;

public class Department {
    private String departmentName;
    private int departmentID;
    private int numOfEmp;

    public Department(String departmentName, int departmentID, int numOfEmp) throws DepartmentException {
        setDepartmentName(departmentName);
        setDepartmentID(departmentID);
        setNumOfEmp(numOfEmp);
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) throws DepartmentException{
        if (departmentName.length() != 2){
            throw new DepartmentException("The dpeartment name does not have 2 letters." +
                    "\nNumber of letters in department name: [" + departmentName.length() + "]");
        }
        this.departmentName = departmentName;
    }

    public int getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(int departmentID) throws DepartmentException{
        if (departmentID < 100 && departmentID > 499)
        {
            throw new DepartmentException("Department ID is not part of the range [100 - 499]." +
                    "\nCurrent department ID : [" + departmentID + "]");
        }
        this.departmentID = departmentID;
    }

    public int getNumOfEmp() {
        return numOfEmp;
    }

    public void setNumOfEmp(int numOfEmp) throws DepartmentException{
        if (numOfEmp < 4 && numOfEmp > 10){
            throw new DepartmentException("Number of employees out of bounds {4 - 10}." +
                    "\nCurrent number of employees is: [" + numOfEmp + "]");
        }
        this.numOfEmp = numOfEmp;
    }

    @Override
    public String toString() {
        return String.format("""
                Department Name               :   %s
                Department ID                 :   %d
                Number Of Employees           :   %d""", getDepartmentName(), getDepartmentID(), getNumOfEmp());
    }
}
