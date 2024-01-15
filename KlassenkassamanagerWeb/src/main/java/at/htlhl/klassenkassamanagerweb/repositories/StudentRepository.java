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
                rs.getInt("classId"),
                rs.getString("userName"),
                rs.getString("firstname"),
                rs.getString("lastname"),
                rs.getFloat("depositAmount"),
                rs.getFloat("toPayAmount")
        );
    }

    private void addStudentToResultSet(PreparedStatement ps, Student student) throws SQLException {
        ps.setInt(1, student.getClassId());
        ps.setString(2, student.getUserName());
        ps.setString(3, student.getFirstname());
        ps.setString(4, student.getLastname());
        ps.setFloat(5, student.getDepositAmount());
        ps.setFloat(6, student.getToPayAmount());
    }

    private static final String SELECT_STUDENT_SQL =
            "SELECT * FROM Student " +
            "WHERE id = ?;";

    private static final String INSERT_STUDENT_SQL =
            "INSERT INTO Student " +
            "(classId, userName, firstname, lastname, depositAmount, toPayAmount) " +
            "VALUES (?, ?, ?, ?, ?, ?)";

    private static final String UPDATE_STUDENT_SQL =
            "UPDATE Student SET " +
            "classId = ?, userName = ?, firstname = ?, lastname = ?, depositAmount = ?, toPayAmount = ? " +
            "WHERE id = ?";

    private static final String DELETE_STUDENT_SQL =
            "DELETE FROM Student " +
            "WHERE id = ?";

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

    public Student addStudent(int classId, Student student) throws SQLException {
        try (PreparedStatement ps = jdbcTemplate.getDataSource().getConnection().prepareStatement(INSERT_STUDENT_SQL)) {
            addStudentToResultSet(ps, student);
            ps.setInt(1, classId);

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                //try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                    //if (generatedKeys.next()) {
                    //    int generatedId = generatedKeys.getInt(1);
                    //    LOGGER.info("Student added successfully with ID: {}", generatedId);
                        return student;
                    //} else {
                    //    throw new SQLException("Failed to get the auto-generated ID after student insertion");
                    //}
                //}
            } else {
                throw new SQLException("Failed to Add Student");
            }
        }
    }

    public Student updateStudent(int id, Student student) throws SQLException {
        try (PreparedStatement ps = jdbcTemplate.getDataSource().getConnection().prepareStatement(UPDATE_STUDENT_SQL)) {
            addStudentToResultSet(ps, student);
            ps.setFloat(7, id);

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                LOGGER.info("Student with ID {} updated successfully", id);
                // Optionally, you can return the updated student
                return student;
            } else {
                throw new SQLException("Student with ID " + id + " not found or could not be updated");
            }
        }
    }

    public void deleteStudentById(int id) throws SQLException {
        try (PreparedStatement ps = jdbcTemplate.getDataSource().getConnection().prepareStatement(DELETE_STUDENT_SQL)) {
            ps.setInt(1, id);
            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                LOGGER.info("Student with ID {} deleted successfully", id);
            } else {
                throw new SQLException("Student with ID " + id + " not found or could not be deleted");
            }
        }
    }
}
