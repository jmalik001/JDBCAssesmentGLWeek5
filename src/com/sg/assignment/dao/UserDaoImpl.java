package com.sg.assignment.dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sg.assignment.exception.JDBCSQLException;
import com.sg.assignment.model.User;
import com.sg.assignment.util.QueryBuilder;

public class UserDaoImpl implements UserDao {

	// QueryBuilder builder = new QueryBuilder();
	public static final  String DB_URL = "jdbc:postgresql://localhost:54330/postgres";
	public static final String USER_NAME = "postgres";
	public static final String PASSWORD = "postgres";
	
	@Override
	public int register(User user) {

		try (PreparedStatement pStatement = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD)
				.prepareStatement(QueryBuilder.getRegisterQuery())) {

			pStatement.setString(1, user.getFirstName());
			pStatement.setString(2, user.getLastName());
			pStatement.setString(3, user.getEmail());
			return pStatement.executeUpdate();
		} catch (SQLException e) {
			throw new JDBCSQLException(e.getMessage());
		}

	}

	@Override
	public List<User> displayUserData() {
		List<User> userData = new ArrayList<>();
		try (PreparedStatement pStatement = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD)
				.prepareStatement(QueryBuilder.getDisplayUserQuery())) {

			ResultSet result = pStatement.executeQuery();
			while (result.next()) {
				String firstName = result.getString(1);
				String lastName = result.getString(2);
				String email = result.getString(3);
				int userId = result.getInt(4);

				User user = new User(firstName, lastName, email, userId);
				userData.add(user);
			}

			return userData;

		} catch (SQLException e) {
			throw new JDBCSQLException(e.getMessage());
		}
	}

	@Override
	public int update(User user) {
		try (PreparedStatement pStatement = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD)
				.prepareStatement(QueryBuilder.getUpdateUserQuery())) {
			
			pStatement.setString(1, user.getFirstName());
			pStatement.setString(2, user.getLastName());
			pStatement.setString(3, user.getEmail());
			
			pStatement.setInt(4, user.getUserId());
			
			return pStatement.executeUpdate();
		}catch (SQLException e) {
			throw new JDBCSQLException(e.getMessage());
		}
	}

	@Override
	public int delete(int userId) {

		try (PreparedStatement pStatement = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD)
				.prepareStatement(QueryBuilder.getDeleteUserQuery())) {

			pStatement.setInt(1, userId);

			return pStatement.executeUpdate();

		} catch (SQLException e) {
			throw new JDBCSQLException(e.getMessage());
		}
	}

}
