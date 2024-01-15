package at.htlhl.klassenkassamanagerweb.models;

public class Student {

    private int id;
    private int classId;
    private String userName;
    private String firstname;
    private String lastname;
    private float depositAmount;
    private float toPayAmount;

    public Student(int id, int classId, String userName, String firstname, String lastname, float depositAmount, float toPayAmount) {
        this.id = id;
        this.classId = classId;
        this.userName = userName;
        this.firstname = firstname;
        this.lastname = lastname;
        this.depositAmount = depositAmount;
        this.toPayAmount = toPayAmount;
    }

    public int getId() {
        return id;
    }

    public int getClassId() {
        return classId;
    }

    public String getUserName() {
        return userName;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public float getDepositAmount() {
        return depositAmount;
    }

    public float getToPayAmount() {
        return toPayAmount;
    }

    public void setId(int id) {
        this.id = id;
    }
}
