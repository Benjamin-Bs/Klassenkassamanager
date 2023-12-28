package at.htlhl.klassenkassamanagerweb.models;

public class User {
    private int id;
    private String varchar;

    public User(int id, String varchar) {
        this.id = id;
        this.varchar = varchar;
    }

    public int getId() {
        return id;
    }

    public String getVarchar() {
        return varchar;
    }
}
