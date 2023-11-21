package at.htlhl.klassenkassamanagerweb.models;

public class Student {
    private int id;
    private String firstname;
    private String lastname;
    private float depositAmount;
    private float toPayAmount;
    private int classId;

    public Student(int id, String firstname, String lastname, float depositAmount, float toPayAmount, int classId) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.depositAmount = depositAmount;
        this.toPayAmount = toPayAmount;
        this.classId = classId;
    }
}
