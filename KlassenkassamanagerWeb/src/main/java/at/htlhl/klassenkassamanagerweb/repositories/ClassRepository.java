package at.htlhl.klassenkassamanagerweb.repositories;

import at.htlhl.klassenkassamanagerweb.models.Class;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@Repository
public class ClassRepository {
    public static final Logger LOGGER = (Logger) LoggerFactory.getLogger(StudentRepository.class);


    @Autowired
    private JdbcTemplate jdbcTemplate;

    private Class createClass(ResultSet rs) throws SQLException {
        return new Class(
                rs.getInt("id"),
                rs.getInt("ownerId"),
                rs.getString("department"),
                rs.getDate("DateOfFounding")
        );
    }

    private void addClassToResultSet(PreparedStatement ps, Class classObject) throws SQLException {
        ps.setInt(1, classObject.getOwnerId());
        ps.setString(2, classObject.getDepartment());
        ps.setDate(3, classObject.getDateOfFounding());
    }

    private static final String SELECT_CLASS_SQL =
            "SELECT * FROM Class " +
                    "WHERE id = ?;";

    private static final String SELECT_CLASS_BY_USERNAME_SQL =
            """
            SELECT Class.id as id, ownerId, department, dateOfFounding 
            FROM Class 
            JOIN Student ON Class.id = Student.classId 
            JOIN WebUser ON Student.userId = WebUser.id 
            WHERE WebUser.userName = ?;
            """;

    private static final String INSERT_CLASS_SQL =
            "INSERT INTO Class " +
                    "(ownerId, department, dateOfFounding) " +
                    "VALUES (?, ?, ?)";

    private static final String UPDATE_CLASS_SQL =
            "UPDATE Class SET " +
                    "ownerId = ?, department = ?, dateOfFounding = ? " +
                    "WHERE id = ?";

    private static final String DELETE_CLASS_SQL =
            "DELETE FROM Class " +
                    "WHERE id = ?";

    public ArrayList<Class> getClassesByUserName(String userName) throws SQLException {
        PreparedStatement ps = jdbcTemplate.getDataSource().getConnection()
                .prepareStatement(SELECT_CLASS_BY_USERNAME_SQL);

        ps.setString(1, userName);
        ResultSet rs = ps.executeQuery();

        ArrayList<Class> classes = new ArrayList<>();
        while (rs.next()) {
            classes.add(createClass(rs));
        }
        LOGGER.info("Selected Students: " + classes);
        return classes;
    }

    public Class getClassById(int id) throws SQLException {
        PreparedStatement ps = jdbcTemplate.getDataSource().getConnection()
                .prepareStatement(SELECT_CLASS_SQL);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            LOGGER.info("Selected Class: " + rs.getInt("id"));
            return createClass(rs);
        } else {
            throw new SQLException("Could not fetch data from database");
        }
    }

    public Class addClass(Class classObject) throws SQLException {
        try (PreparedStatement ps = jdbcTemplate.getDataSource().getConnection().prepareStatement(INSERT_CLASS_SQL)) {
            addClassToResultSet(ps, classObject);

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                //try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                //if (generatedKeys.next()) {
                //    int generatedId = generatedKeys.getInt(1);
                //    LOGGER.info("Student added successfully with ID: {}", generatedId);
                return classObject;
                //} else {
                //    throw new SQLException("Failed to get the auto-generated ID after student insertion");
                //}
                //}
            } else {
                throw new SQLException("Failed to Add Student");
            }
        }
    }

    public Class updateStudent(int id, Class classObject) throws SQLException {
        try (PreparedStatement ps = jdbcTemplate.getDataSource().getConnection().prepareStatement(UPDATE_CLASS_SQL)) {
            addClassToResultSet(ps, classObject);
            ps.setFloat(4, id);

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                LOGGER.info("Student with ID {} updated successfully", id);
                // Optionally, you can return the updated student
                return classObject;
            } else {
                throw new SQLException("Student with ID " + id + " not found or could not be updated");
            }
        }
    }

    public void deleteClassById(int id) throws SQLException {
        try (PreparedStatement ps = jdbcTemplate.getDataSource().getConnection().prepareStatement(DELETE_CLASS_SQL)) {
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
