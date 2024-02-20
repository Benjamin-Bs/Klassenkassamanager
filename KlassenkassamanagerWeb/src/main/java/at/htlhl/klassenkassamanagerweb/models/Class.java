package at.htlhl.klassenkassamanagerweb.models;

import java.sql.Date;

/**
 * Represents a class in the Klassenkassa Manager application.
 */
public class Class {

    /**
     * The unique identifier for the class.
     */
    private int id;

    /**
     * The name of the owner of the class.
     */
    private int ownerId;

    /**
     * The department to which the class belongs.
     */
    private String department;

    /**
     * The date when the class was founded.
     */
    private Date dateOfFounding;

    /**
     * Constructs a Class object with the specified parameters.
     *
     * @param id              The unique identifier for the class.
     * @param ownerId         The name of the owner of the class.
     * @param department      The department to which the class belongs.
     * @param dateOfFounding  The date when the class was founded.
     */
    public Class(int id, int ownerId, String department, Date dateOfFounding) {
        this.id = id;
        this.ownerId = ownerId;
        this.department = department;
        this.dateOfFounding = dateOfFounding;
    }

    /**
     * Retrieves the unique identifier of the class.
     *
     * @return The unique identifier of the class.
     */
    public int getId() {
        return id;
    }

    /**
     * Retrieves the department to which the class belongs.
     *
     * @return The department of the class.
     */
    public String getDepartment() {
        return department;
    }

    /**
     * Retrieves the name of the owner of the class.
     *
     * @return The owner's name of the class.
     */
    public int getOwnerId() {
        return ownerId;
    }

    /**
     * Retrieves the date when the class was founded.
     *
     * @return The date of founding of the class.
     */
    public Date getDateOfFounding() {
        return dateOfFounding;
    }
}
