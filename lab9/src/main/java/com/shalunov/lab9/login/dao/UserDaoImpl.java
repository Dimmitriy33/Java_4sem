package com.shalunov.lab9.login.dao;

import com.shalunov.lab9.login.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    @Override
    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        //language=MySQL
        final String SQL = "select username, password, role from Users";

        try (
                Connection connection = Connector.getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(SQL);
        ) {
            while (resultSet.next()) {
                users.add(extractUserFromResultSet(resultSet));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return users;
    }

    public static User extractUserFromResultSet(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setUsername(resultSet.getString("username"));
        user.setPassword(resultSet.getString("password"));
        user.setRole(resultSet.getString("role"));
        return user;
    }

    @Override
    public User read(String username) {
        User user = null;
        final String SQL = "select username, password, role from Users where username=?";

        Connector connector = new Connector();
        try (PreparedStatement preparedStatement = connector.getPreparedStatement(SQL)) {
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                user = extractUserFromResultSet(resultSet);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return user;
    }

    @Override
    public boolean delete(String username) {
        return false;
    }

    @Override
    public boolean create(User user) {
        final String SQL = "insert into Users(username, password, role) values(?, ?, ?)";
        Connector connector = new Connector();

        try (PreparedStatement preparedStatement = connector.getPreparedStatement(SQL)) {
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getRole());

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected == 1) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            connector.close();
        }

        return false;
    }

    @Override
    public boolean update(User user) {
        return false;
    }
}
