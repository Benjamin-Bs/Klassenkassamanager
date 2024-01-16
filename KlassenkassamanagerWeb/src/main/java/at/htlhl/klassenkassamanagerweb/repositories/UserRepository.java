package at.htlhl.klassenkassamanagerweb.repositories;

import at.htlhl.klassenkassamanagerweb.models.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class UserRepository {

    public static final Logger LOGGER = (Logger) LoggerFactory.getLogger(UserRepository.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private User createUser(ResultSet rs) throws SQLException {
        return new User(
                rs.getString("userName"),
                rs.getString("password")
        );
    }

    private void addUserToResultSet(PreparedStatement ps, User user) throws SQLException {
        ps.setString(1, user.getUsername());
        ps.setString(2, user.getPassword());
    }

    private static final String SELECT_USER_SQL =
            "SELECT * FROM WebUser " +
                    "WHERE id = ?;";

    private static final String INSERT_USER_SQL =
            "INSERT INTO WebUser " +
                    "(userName, password) " +
                    "VALUES (?, ?)";

    private static final String UPDATE_USER_SQL =
            "UPDATE WebUser SET " +
                    "userName = ?, password = ? " +
                    "WHERE id = ?";

    private static final String DELETE_USER_SQL =
            "DELETE FROM WebUser " +
                    "WHERE id = ?";


    public User getUserById(int id) throws SQLException {
        PreparedStatement ps = jdbcTemplate.getDataSource().getConnection()
                .prepareStatement(SELECT_USER_SQL);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            LOGGER.info("Selected User: " + rs.getInt("id"));
            return createUser(rs);
        } else {
            throw new SQLException("Could not fetch data from database");
        }
    }


    public User addUser(User user) throws SQLException {
        try (PreparedStatement ps = jdbcTemplate.getDataSource().getConnection().prepareStatement(INSERT_USER_SQL)) {
            addUserToResultSet(ps, user);

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                //try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                //if (generatedKeys.next()) {
                //    int generatedId = generatedKeys.getInt(1);
                //    LOGGER.info("Student added successfully with ID: {}", generatedId);
                return user;
                //} else {
                //    throw new SQLException("Failed to get the auto-generated ID after student insertion");
                //}
                //}
            } else {
                throw new SQLException("Failed to Add User");
            }
        }
    }

    public User updateUserById(int id, User user) throws SQLException {
        try (PreparedStatement ps = jdbcTemplate.getDataSource().getConnection().prepareStatement(UPDATE_USER_SQL)) {
            addUserToResultSet(ps, user);
            ps.setInt(3, id);

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                LOGGER.info("User with id {} updated successfully", id);
                // Optionally, you can return the updated user
                return user;
            } else {
                throw new SQLException("User with id " + id + " not found or could not be updated");
            }
        }
    }

    public void deleteUserById(int id) throws SQLException {
        try (PreparedStatement ps = jdbcTemplate.getDataSource().getConnection().prepareStatement(DELETE_USER_SQL)) {
            ps.setInt(1, id);
            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                LOGGER.info("User with id {} deleted successfully", id);
            } else {
                throw new SQLException("User with id " + id + " not found or could not be deleted");
            }
        }
    }
}

