package com.sg.assignment.dao;

import java.util.List;

import com.sg.assignment.model.User;

public interface UserDao {
	public int register(User user);

	public List<User> displayUserData();

	public int update(User user);

	public int delete(int userId);
}
