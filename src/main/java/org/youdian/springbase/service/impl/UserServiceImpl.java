package org.youdian.springbase.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.youdian.springbase.mapper.UserMapper;
import org.youdian.springbase.model.User;
import org.youdian.springbase.service.UserService;
import org.youdian.springbase.util.StringUtils;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserMapper userMapper;
	
	public int insertUser(User user) {
		return userMapper.insertUser(user);
	}

	public void updateUser(User user) {
		userMapper.updateUser(user);
	}

	public List<User> listUser() {
		return userMapper.listUser();
	}

	public void deleteUser(int id) {
		userMapper.deleteUser(id);
	}

	public User selectUser(int id) {
		return userMapper.selectUser(id);
	}

	@Override
	public List<User> searchUser(String name) {
		name = StringUtils.encodeChineseUrl(name);
		System.out.println("name="+name);
		return userMapper.searchUser(name);
	}

}
