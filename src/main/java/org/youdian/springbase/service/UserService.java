package org.youdian.springbase.service;

import java.util.List;

import org.youdian.springbase.model.User;

public interface UserService {

	public int insertUser(User user);
	public void updateUser(User user);
	public User selectUser(int id);
	public List<User> listUser();
	public void deleteUser(User user);
}
