package com.sg.assignment.service;

import java.util.List;

import com.sg.assignment.dao.UserDao;
import com.sg.assignment.dao.UserDaoImpl;
import com.sg.assignment.model.User;

public class UserServiceImpl implements UserService {

	
	UserDao dao = new UserDaoImpl();
	@Override
	public int register(User user) {
		return dao.register(user);
	}

	@Override
	public List<User> displayUserData() {
	return dao.displayUserData();
	
	}

	@Override
	public int update(User user) {
	return dao.update(user);
	}

	@Override
	public int delete(int userId) {
		return dao.delete(userId);
	}
}
