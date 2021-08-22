package com.sg.assignment.service;


import java.util.List;

import com.sg.assignment.model.User;

public interface UserService {

	public int register(User user);

	public List<User> displayUserData();

	public int update(User user);

	public int delete(int userId);
}
