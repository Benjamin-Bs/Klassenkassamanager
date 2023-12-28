package at.htlhl.klassenkassamanagerweb.repositories;

import at.htlhl.klassenkassamanagerweb.models.Class;
import at.htlhl.klassenkassamanagerweb.models.Student;
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
                rs.getString("ownerName"),
                rs.getString("department"),
                rs.getDate("DateOfFounding")
        );
    }

    private static final String SELECT_CLASS_SQL =
            "SELECT * FROM Class WHERE id = ?;";

    private static final String SELECT_CLASS_BY_USERNAME_SQL =
            """
            SELECT Class.id AS id, ownerName, department, dateOfFounding  FROM Class 
            JOIN Student 
            ON Student.classId = Class.id
            WHERE Student.userName = ?;
            """;

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
}
