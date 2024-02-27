package at.htlhl.klassenkassamanagerweb.models;

/**
 * Represents a student in the Klassenkassa Manager application.
 */
public class Student {

    /**
     * The identifier of the class to which the student belongs.
     */
    private int id;
    private int classId;

    /**
     * The username of the student.
     */
    private int userId;

    private String username;

    /**
     * The first name of the student.
     */
    private String firstname;

    /**
     * The last name of the student.
     */
    private String lastname;

    /**
     * The amount of deposit money the student has.
     */
    private float depositAmount;

    /**
     * The amount the student needs to pay.
     */
    private float toPayAmount;

    public Student(){

    }

    /**
     * Constructs a Student object with the specified parameters.
     *
     * @param classId       The identifier of the class to which the student belongs.
     * @param userId      The username of the student.
     * @param firstname     The first name of the student.
     * @param lastname      The last name of the student.
     * @param depositAmount The amount of deposit money the student has.
     * @param toPayAmount   The amount the student needs to pay.
     */
    public Student(int classId, int userId, String firstname, String lastname, float depositAmount, float toPayAmount) {
        this.classId = classId;
        this.userId = userId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.depositAmount = depositAmount;
        this.toPayAmount = toPayAmount;
    }

    public Student(int classId, String username, String firstname, String lastname, float depositAmount, float toPayAmount) {
        this.classId = classId;
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.depositAmount = depositAmount;
        this.toPayAmount = toPayAmount;
    }

    public Student(int id, int classId, int userId, String firstname, String lastname, float depositAmount, float toPayAmount) {
        this.id = id;
        this.classId = classId;
        this.userId = userId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.depositAmount = depositAmount;
        this.toPayAmount = toPayAmount;
    }

    /**
     * Retrieves the identifier of the class to which the student belongs.
     *
     * @return The class identifier.
     */
    public int getId() {
        return id;
    }

    public int getClassId() {
        return classId;
    }

    /**
     * Retrieves the username of the student.
     *
     * @return The username of the student.
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Retrieves the first name of the student.
     *
     * @return The first name of the student.
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * Retrieves the last name of the student.
     *
     * @return The last name of the student.
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * Retrieves the amount of deposit money the student has.
     *
     * @return The deposit amount of the student.
     */
    public float getDepositAmount() {
        return depositAmount;
    }

    /**
     * Retrieves the amount the student needs to pay.
     *
     * @return The amount to pay for the student.
     */
    public float getToPayAmount() {
        return toPayAmount;
    }
    public String getUsername() {
        return username;
    }

    public static class Name{
        private String firstname;
        private String lastname;

        public Name(String firstname, String lastname) {
            this.firstname = firstname;
            this.lastname = lastname;
        }

        public String getFirstname() {
            return firstname;
        }

        public String getLastname() {
            return lastname;
        }
    }
}
