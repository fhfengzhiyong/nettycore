package com.straw.nettycore.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author fengzy
 * @date 3/5/2018
 */
public class UserJdbcTest {
    public static void main(String[] args) {
        UserJdbcTest test = new UserJdbcTest();
        User user = test.select();
        if (user != null) {
            System.out.println(user.getName());
        }
    }

    private User select() {
        User user = null;
        Connection connection = ConnectionFactory.getConnection();
        String sql = "SELECT * FROM USERS WHERE ID=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, 1);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setEmail(resultSet.getString("email"));
                user.setName(resultSet.getString("name"));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return user;
    }
}
