package at.htlhl.klassenkassamanagerweb.repositories;

import at.htlhl.klassenkassamanagerweb.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class StudentRepository {

    private static final String SELECT_LATEST_TEMPERATURE_SQL =
            "SELECT * FROM Student WHERE id = ?";

    @Autowired
    private JdbcTemplate jdbcTemplate;
    public Student getStudentById(int id) throws SQLException {
        ResultSet rs = jdbcTemplate.getDataSource().getConnection()
                .createStatement().executeQuery(SELECT_LATEST_TEMPERATURE_SQL.replace("?", (id+"")));
        Student student = new Student(
                rs.getInt("id"),
                rs.getString("firstname"),
                rs.getString("lastname"),
                rs.getFloat("depositAmount"),
                rs.getFloat("toPayAmount"),
                rs.getInt("classId")
        );


        return student;
    }
}
