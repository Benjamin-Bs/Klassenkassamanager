package at.htlhl.klassenkassamanagerweb.models;

public class Student {
    private int id;
    private String firstname;
    private String lastname;
    private float depositAmount;
    private float toPayAmount;

    public Student(int id, String firstname, String lastname, float depositAmount, float toPayAmount) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.depositAmount = depositAmount;
        this.toPayAmount = toPayAmount;
    }

    public int getId() {
        return id;
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

}
