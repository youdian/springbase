package org.youdian.springbase.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.youdian.springbase.mapper.UserMapper;
import org.youdian.springbase.model.User;
import org.youdian.springbase.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Resource
	UserMapper userMapper;
	
	public int insertUser(User user) {
		// TODO Auto-generated method stub
		return userMapper.insertUser(user);
	}

}
