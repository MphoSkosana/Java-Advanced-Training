package Chapter7;

public class Student {
    private String studentNum;
    private String firstName;
    private String lastName;
    private String email;
    private int testMark, assignment1, assignment2;

    //constructors
    public Student() {
        studentNum = "0000000";
        firstName = "No name";
        lastName = "no lastname";
        email = "none";
        testMark = 0;
        assignment1 = 0;
        assignment2 = 0;

    }

    /**
     * construct an object of Student with attributes
     * @param studentNum student Number
     * @param firstName first name
     * @param lastName last name
     * @param email email
     */
    public Student(String studentNum, String firstName, String lastName, String email) {
        setStudentNum(studentNum);
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
    }

    //getters
    public String getName(){
        return firstName + " " + lastName;
    }

    public String getEmail(){
        return email;
    }

    public String getStudentNum(){
        return studentNum;
    }

    /**
     * get the semester mark of the student
     * @return semester mark
     */
    public double getSemesterMark(){
        //test * 40%, a1 * 35%, a2 * 25
        return (this.testMark * 0.4) + (this.assignment1 * 0.35) + (this.assignment2 * 0.25);
    }

    //setters
    private void setStudentNum(String stNum){
        this.studentNum = "ST-26" + stNum;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * set the assessment marks
     * @param testMark test mark
     * @param assignment1 assignment 1
     * @param assignment2 assignment 2
     */
    public void setAssessments(int testMark, int assignment1, int assignment2){
        this.testMark = testMark;
        this.assignment1 = assignment1;
        this.assignment2 = assignment2;
    }

    /**
     * Display the Student's information
     */
    public void display(){
        System.out.println("Student# : " + getStudentNum());
        System.out.println("Name : " + getName());
        System.out.println("Email : " + getEmail());
        System.out.println("Semester Mark : " + getSemesterMark());
    }
}
