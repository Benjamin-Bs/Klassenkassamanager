package at.htlhl.klassenkassamanagerweb.repositories;

import at.htlhl.klassenkassamanagerweb.models.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

@Repository
public class StudentRepository {

    public static final Logger LOGGER = (Logger) LoggerFactory.getLogger(StudentRepository.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private Student createStudent(ResultSet rs) throws SQLException {
        return new Student(
                rs.getInt("userId"),
                rs.getString("firstname"),
                rs.getString("lastname"),
                rs.getFloat("depositAmount"),
                rs.getFloat("toPayAmount")
        );
    }

    private static final String SELECT_STUDENT_SQL =
            "SELECT * FROM Student WHERE id = ?;";

    private static final String SELECT_STUDENTS_BY_ARG_SQL =
            """
                SELECT * FROM Student 
                WHERE >ARG< = ?;
            """;


    public Student getStudentById(int id) throws SQLException {
        PreparedStatement ps = jdbcTemplate.getDataSource().getConnection()
                .prepareStatement(SELECT_STUDENT_SQL);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            LOGGER.info("Selected Student: " + rs.getInt("id"));
            return createStudent(rs);
        } else {
            throw new SQLException("Could not fetch data from database");
        }
    }

    public ArrayList<Student> getStudentsByArg(String arg, int value) throws SQLException {
        PreparedStatement ps = jdbcTemplate.getDataSource().getConnection()
                .prepareStatement(SELECT_STUDENTS_BY_ARG_SQL.replace(">ARG<", arg));
        ps.setInt(1, value);
        ResultSet rs = ps.executeQuery();

        ArrayList<Student> students = new ArrayList<>();
        while (rs.next()) {
            students.add(createStudent(rs));
        }
        LOGGER.info("Selected Students: " + students);
        return students;
    }

}
