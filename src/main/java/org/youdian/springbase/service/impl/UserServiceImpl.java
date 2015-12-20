package org.youdian.springbase.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.youdian.springbase.mapper.UserMapper;
import org.youdian.springbase.model.User;
import org.youdian.springbase.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserMapper userMapper;
	
	public int insertUser(User user) {
		// TODO Auto-generated method stub
		return userMapper.insertUser(user);
	}

	public void updateUser(User user) {
		// TODO Auto-generated method stub
		userMapper.updateUser(user);
	}

	public List<User> listUser() {
		// TODO Auto-generated method stub
		return userMapper.listUser();
	}

	public void deleteUser(User user) {
		// TODO Auto-generated method stub
		userMapper.deleteUser(user);
	}

	public User selectUser(int id) {
		// TODO Auto-generated method stub
		return userMapper.selectUser(id);
	}

}
