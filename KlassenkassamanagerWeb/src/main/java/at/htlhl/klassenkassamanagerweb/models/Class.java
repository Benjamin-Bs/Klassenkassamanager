package at.htlhl.klassenkassamanagerweb.models;

import java.util.ArrayList;
import java.util.Date;

public class Class {
    private int id;
    private String ownerName;
    private String department;
    private Date dateOfFounding;
    private ArrayList<Student> students;

    public Class(int id, String ownerName, String department, Date dateOfFounding) {
        students = new ArrayList<>();
        this.id = id;
        this.ownerName = ownerName;
        this.department = department;
        this.dateOfFounding = dateOfFounding;
    }

    public int getId() {
        return id;
    }

    public String getDepartment() {
        return department;
    }
    public String getOwnerName() {
        return ownerName;
    }

    public Date getDateOfFounding() {
        return dateOfFounding;
    }

}