package ge.tbc.testautomation.data;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseSteps {
    public List<UserModel> selectAllUsers(){
        List<UserModel> allUsers = new ArrayList<>();
        try(Connection connection = MSSQLConnection.getConnection()) {
            String SQL = "SELECT * FROM Users5";
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(SQL);
            while (resultSet.next()){
                allUsers.add(new UserModel(resultSet.getString("Username"), "secret_sauce"));
            }
            return allUsers;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int createUser(){
        try(Connection connection = MSSQLConnection.getConnection()) {
            String SQL = "INSERT INTO Users5 VALUES (?, HASHBYTES('SHA2_256',?));";
            PreparedStatement statement = connection.prepareStatement(SQL);
            String username = "problem_user";
            String password = "secret_sauce";

            statement.setString(1, username);
            statement.setString(2, password);

            int affectedRows = statement.executeUpdate();
            return affectedRows;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int updateUser(){
        try(Connection connection = MSSQLConnection.getConnection()) {
            String SQL = "UPDATE Users5 SET Username = ? WHERE Username = ?";
            PreparedStatement statement = connection.prepareStatement(SQL);
            String oldUsername = "problem_user";
            String newUsername = "problem_user2";

            statement.setString(1, newUsername);
            statement.setString(2, oldUsername);

            int affectedRows = statement.executeUpdate();
            return affectedRows;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int deleteUser(){
        try(Connection connection = MSSQLConnection.getConnection()) {
            String SQL = "DELETE FROM Users5 WHERE Username = ?";
            PreparedStatement statement = connection.prepareStatement(SQL);
            String username = "problem_user2";

            statement.setString(1, username);

            int affectedRows = statement.executeUpdate();
            return affectedRows;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
