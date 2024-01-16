package at.htlhl.klassenkassamanagerweb.models;

/**
 * Represents a student in the Klassenkassa Manager application.
 */
public class Student {

    /**
     * The identifier of the class to which the student belongs.
     */
    private int classId;

    /**
     * The username of the student.
     */
    private String userName;

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

    /**
     * Constructs a Student object with the specified parameters.
     *
     * @param classId       The identifier of the class to which the student belongs.
     * @param userName      The username of the student.
     * @param firstname     The first name of the student.
     * @param lastname      The last name of the student.
     * @param depositAmount The amount of deposit money the student has.
     * @param toPayAmount   The amount the student needs to pay.
     */
    public Student(int classId, String userName, String firstname, String lastname, float depositAmount, float toPayAmount) {
        this.classId = classId;
        this.userName = userName;
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
    public int getClassId() {
        return classId;
    }

    /**
     * Retrieves the username of the student.
     *
     * @return The username of the student.
     */
    public String getUserName() {
        return userName;
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
}
